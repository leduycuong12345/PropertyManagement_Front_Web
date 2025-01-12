package com.cuongsolution.manageproperty.front.web.Controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ExpanseHeaderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ManageExpanse_DatePaginationDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_OrderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ReceiptDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.OrderInfo.ManageOrder_OrderInfoService;
import com.cuongsolution.manageproperty.front.web.Service.Parameter.ParameterService;
import com.cuongsolution.manageproperty.front.web.Service.Receipt.ManageOrder_ReceiptService;
import com.cuongsolution.manageproperty.front.web.Service.RecurringExpanse.RecurringExpanseService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ManageOrderController {
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@Autowired
	private ParameterService parameterService;
	@Autowired
	private ManageOrder_OrderInfoService manageOrder_OrderInfoService;
	@Autowired
	private ManageOrder_ReceiptService manageOrder_PaymentService;
	@Autowired
	private RecurringExpanseService recurringExpanseService;
	@GetMapping(value="/quan-ly-hoa-don")
	public String manageOrderPage( HttpSession session,Model model  ,Principal principal){
		if(this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName()).isEmpty())//kiem tra xem ng dung da khoi tao Land chua? chua thi khoi tao
		{
			model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
			return "new_user";
		}
		else
		{
			Long selectedLandID=(Long) session.getAttribute("selectedLandID");
			if(selectedLandID !=null)//neu da chon land
			{
				List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				
				for(ManageNavigation_FastCreateLandDTO land:landList)
				{
					if(land.getLandID()==selectedLandID)
					{
						model.addAttribute("selectedLandID",land.getLandID());//to create-property belong to land
						//model.addAttribute("selectedLandName",land.getLandName() );//to display selected-land-name at layout-sidebar
						model.addAttribute("selectedLand",land );//to display selected-land-name at layout-sidebar
						
						
						orderPagination(session, model,selectedLandID);
					}
				}
				
			}
			else//neu chua chon land
			{
				List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());//for land list/delete/update func
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				model.addAttribute("selectedLandID",landList.get(0).getLandID());//to create-property belong to land
				model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
				
				orderPagination(session, model,landList.get(0).getLandID());
				
			}
			return "manage_order";
		}
		
    }
	private void orderPagination(HttpSession session, Model model,long landID) {
		//pagination
		Integer selectedMonthPagination=(Integer) session.getAttribute("selectedMonthPagination");
		Integer selectedYearPagination=(Integer) session.getAttribute("selectedYearPagination");
		if(selectedYearPagination!=null && selectedMonthPagination!=null)
		{
			ManageOrder_ManageExpanse_DatePaginationDTO pagination=new ManageOrder_ManageExpanse_DatePaginationDTO
					(selectedMonthPagination,selectedYearPagination);
			model.addAttribute("pagination",pagination );
			
			loadOrderListBySelectedDate(model, landID, selectedMonthPagination, selectedYearPagination);
		}
		else
		{
			// Your desired time zone
		    ZoneId zoneId = ZoneId.of("Asia/Ho_Chi_Minh");
		    LocalDate currentDate = LocalDate.now(zoneId); // Specify the timezone directly here

		    int currentMonth = currentDate.getMonth().getValue();
		    int currentYear = currentDate.getYear();
		    //System.out.println("non-select pagination: " + currentMonth + "/" + currentYear);
		    ManageOrder_ManageExpanse_DatePaginationDTO pagination=new ManageOrder_ManageExpanse_DatePaginationDTO
					(currentMonth,currentYear);
			model.addAttribute("pagination",pagination );
			
			loadOrderListBySelectedDate(model, landID, currentMonth, currentYear);
		}
		//end pagination
	}
	private void loadOrderListBySelectedDate(Model model, long landID, Integer selectedMonthPagination,
			Integer selectedYearPagination) {
		YearMonth selectedYearMonth = YearMonth.of(selectedYearPagination, selectedMonthPagination);

        // Step 2: Create a LocalDate object using the YearMonth with the day set to 1
        LocalDate selectedDate = selectedYearMonth.atDay(1);

        // Step 3: Format the LocalDate object to a string in "yyyy-MM-dd" format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = selectedDate.format(formatter);

        // Output the formatted date
        //System.out.println(" Date: " + selectedDate); 
        //System.out.println("Formatted Date: " + formattedDate); 
	    
	    
        LocalDate date = null;
        
        try {
            date = LocalDate.parse(formattedDate, formatter);
            System.out.println("Parsed date: " + date);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format: " + e.getMessage());
        }
	    List<ManageOrder_OrderDTO> orderList=this.manageOrder_OrderInfoService.getOrderList_ManageOrder(landID, date);
		model.addAttribute("orderList", orderList);
		
		List<ManageOrder_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageOrder_findRecurringExpanseBelongToLand(landID);
		model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
		model.addAttribute("newPayment", new ManageOrder_ReceiptDTO()); //for create-payment function
	}
	@GetMapping(value="/quan-ly-hoa-don/pagination")
	public String selectLandtoManage(@RequestParam("selectedMonthPagination") int selectedMonthPagination,
			@RequestParam("selectedYearPagination") int selectedYearPagination,HttpSession session)  {		
		if(parameterService.checkCurrentDate(selectedMonthPagination, selectedYearPagination))
		{
			//System.out.println("select month:"+selectedMonthPagination+", year:"+selectedYearPagination);
			session.setAttribute("selectedMonthPagination", selectedMonthPagination);
			session.setAttribute("selectedYearPagination", selectedYearPagination);
			return "redirect:/quan-ly-hoa-don";
		}
		else
		{
			return "redirect:/quan-ly-hoa-don";
		}
	}
	
	@PostMapping(value="/quan-ly-hoa-don/xoa-hoa-don")
	public String deleteOrder_ManageOrder( @RequestParam("orderID") Long orderID) throws Exception {
		manageOrder_OrderInfoService.deleteOrder_ManageOrder(orderID);
		return "redirect:/quan-ly-hoa-don";
    }
	@PostMapping(value="/quan-ly-hoa-don/xoa-hoan-toan-hoa-don")
	public String hardDeleteOrder_ManageOrder( @RequestParam("orderID") Long orderID) throws Exception {
		manageOrder_OrderInfoService.hardDeleteOrder_ManageOrder(orderID);
		return "redirect:/quan-ly-hoa-don";
    }
    @PostMapping(value="/quan-ly-hoa-don/thanh-toan")
    public String createPayment_ManageOrder( @ModelAttribute("newReceipt")  ManageOrder_ReceiptDTO newReceipt) throws Exception {
    	this.manageOrder_PaymentService.createReceipt_ManageOrder(newReceipt);
		return "redirect:/quan-ly-hoa-don";
    }
}
