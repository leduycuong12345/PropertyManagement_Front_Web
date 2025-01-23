package com.cuongsolution.manageproperty.front.web.Controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_AddTenantToWorksheetDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_BookDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_CreateOrderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_CreateWorksheetDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_DepositDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_EditFastRecurringExpanseListDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_EditPropertyDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_FastCreateOrderListDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_PropertyDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.OrderInfo.ManageProperty_OrderInfoService;
import com.cuongsolution.manageproperty.front.web.Service.Property.ManageProperty_PropertySer;
import com.cuongsolution.manageproperty.front.web.Service.PropertyService.PropertyServiceSer;
import com.cuongsolution.manageproperty.front.web.Service.Tenant.TenantService;
import com.cuongsolution.manageproperty.front.web.Service.Worksheet.WorksheetService;
@Controller
public class ManagePropertyController {
	private Logger logger = LoggerFactory.getLogger(ManagePropertyController.class);
	
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@Autowired
	private ManageProperty_PropertySer propertyService;
	@Autowired
	private PropertyServiceSer propertyServiceSer;
	@Autowired
	private TenantService tenantService;
	@Autowired
	private ManageProperty_OrderInfoService manageProperty_OrderInfoService;
    @Autowired
	private WorksheetService worksheetService;
	@GetMapping(value="/quan-ly")
	public String managePropertyPage( HttpSession session,Model model,Principal principal)  {
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
						model.addAttribute("selectedLand",land );//to display selected-land-name at layout-sidebar
					}
				}
				model.addAttribute("propertyList",this.propertyService.getPropertyBelongToLand_ManageProperty(selectedLandID));
				model.addAttribute("newWorksheet",new ManageProperty_CreateWorksheetDTO());//for create-worksheet function
				model.addAttribute("newOrder",new ManageProperty_CreateOrderDTO());//for create-order function
				model.addAttribute("editFastExpanseList",new ManageProperty_EditFastRecurringExpanseListDTO());//for edit-fast-recurring-expanse-list function;
				model.addAttribute("newTenant",new ManageProperty_AddTenantToWorksheetDTO());//for add-tenant-to-worksheet function;
				model.addAttribute("fastCreateOrderList",new ManageProperty_FastCreateOrderListDTO());//for fast-create-order-list function;
				model.addAttribute("newDeposit",new ManageProperty_DepositDTO());//for deposit function of worksheet which signed by tenant;
				model.addAttribute("newBooking",new ManageProperty_BookDTO());//for book function;
			}
			else//neu chua chon land
			{
				
				List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());//for land list/delete/update func
				List<ManageProperty_PropertyDTO> propertyListBelongToLand=this.propertyService.getPropertyBelongToLand_ManageProperty(landList.get(0).getLandID());
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				model.addAttribute("selectedLandID",landList.get(0).getLandID());//to create-property belong to land
				model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
				model.addAttribute("propertyList",propertyListBelongToLand);
				model.addAttribute("newWorksheet",new ManageProperty_CreateWorksheetDTO());//for create-worksheet function
				model.addAttribute("newOrder",new ManageProperty_CreateOrderDTO());//for create-order function
				model.addAttribute("editFastExpanseList",new ManageProperty_EditFastRecurringExpanseListDTO());//for edit-fast-recurring-expanse-list function;
				model.addAttribute("newTenant",new ManageProperty_AddTenantToWorksheetDTO());//for add-tenant-to-worksheet function;
				model.addAttribute("fastCreateOrderList",new ManageProperty_FastCreateOrderListDTO());//for fast-create-order-list function;
				model.addAttribute("newDeposit",new ManageProperty_DepositDTO());//for deposit function of worksheet which signed by tenant;
				model.addAttribute("newBooking",new ManageProperty_BookDTO());//for book function;
				
				logger.info("land id:"+landList.get(0).getLandID()+" with property land:"+propertyListBelongToLand);
				for( ManageProperty_PropertyDTO dto:propertyListBelongToLand)
				{
					logger.info("property id:"+dto.getPropertyID()+" is being load.");
				}
			}
			return "manage_property";
		}
    }
	@PostMapping(value="/quan-ly")
	public String selectLandtoManage(@RequestParam("selectedLandID") Long selectedLandID, HttpSession session)  {
		session.setAttribute("selectedLandID", selectedLandID);
		return "redirect:/quan-ly";
	}
	@PostMapping(value="/quan-ly/thay-doi-tai-san")
	public String postCreateProperty( HttpSession session, @RequestParam("propertyID") Long propertyID
			,@RequestParam("propertyName") String propertyName
			,@RequestParam("propertyRentalPrice") double propertyRentalPrice
			,@RequestParam("worksheetTotalDeposit") double worksheetTotalDeposit
			,@RequestParam("worksheetOrderCreationDate") int worksheetOrderCreationDate
			,@RequestParam("WorksheetTimeInverval") int WorksheetTimeInverval
			,Model model)  {
		ManageProperty_PropertyDTO propertyDTO =new ManageProperty_PropertyDTO(propertyID,propertyName,
				propertyRentalPrice,worksheetTotalDeposit,worksheetOrderCreationDate,WorksheetTimeInverval
				);
		this.propertyService.editPropertyIncludedWorksheet(propertyDTO);
		return "redirect:/quan-ly";
    }
	
	@PostMapping(value="/quan-ly/chinh-sua-dich-vu")
	public String postEditProperty( HttpSession session, @ModelAttribute("editFastExpanseList") ManageProperty_EditFastRecurringExpanseListDTO editFastExpanseList
			,Model model)  {
		this.propertyServiceSer.fastEditExpanseList(editFastExpanseList);
		return "redirect:/quan-ly";
    }
	@PostMapping(value="/quan-ly/them-khach-thue")
	public String addTenantToWorksheetProperty( HttpSession session, @ModelAttribute("newTenant") ManageProperty_AddTenantToWorksheetDTO newTenant
			,Model model)  {
		this.tenantService.addTenantToWorksheet_ManageProperty(newTenant);
		return "redirect:/quan-ly";
    }
	@PostMapping(value="/tai-san/them")
	public String createPropertyAtManagePage(@RequestParam("landID") Long landID,
			@RequestParam("propertyName") String propertyName,
			@RequestParam("propertyRentalPrice") double propertyRentalPrice) throws Exception {
		//test add_db with inheritance relationship
		this.propertyService.createProperty(propertyName,
				propertyRentalPrice,
				landID);
		
		return "redirect:/quan-ly";
    }
	@PostMapping("/property/delete")
	public String deleteProperty(@RequestParam(value = "propertyID") Long propertyID) {
	  	this.propertyService.deleteById(propertyID);
		return "redirect:/quan-ly";
	}
	@PostMapping(value="/hoa-don/them")
	public String createOrder_ManageProperty( @ModelAttribute("newOrder") ManageProperty_CreateOrderDTO newOrder) throws Exception {
		manageProperty_OrderInfoService.createOrder_ManageProperty(newOrder);
		//System.out.println("i was here: "+newOrder.getOrderBelongMonth());
		return "redirect:/quan-ly";
    }
	@PostMapping("/quan-ly/sua-tai-san")
    public ResponseEntity<String>  editProperty_ManageProperty(@Validated @RequestBody ManageProperty_EditPropertyDTO property) throws Exception {
		this.propertyService.editProperty_ManageProperty(property);
		return ResponseEntity.ok("Đã lưu đối tượng thành công!");
    }
    @PostMapping("/quan-ly/tao-nhanh-danh-sach-hoa-don")
    public String createFastOrderList_ManageProperty(  @Validated @RequestBody ManageProperty_FastCreateOrderListDTO ManageProperty_FastCreateOrderListDTO)  {
		//System.out.println("haha: "+orderList.getWorksheetList_withCurrentReading());
    	ManageProperty_FastCreateOrderListDTO.setParsedOrderBelongMonth(ManageProperty_FastCreateOrderListDTO.getOrderBelongMonth());
    	
    	logger.info("create fast order list with created order:"+ManageProperty_FastCreateOrderListDTO.getOrderCreateDate()
		+" and end-rental-date:"+ManageProperty_FastCreateOrderListDTO.getOrderExpireDate()+" and belong month:"+ManageProperty_FastCreateOrderListDTO.getOrderBelongMonth()
		+" and parsed the date:" +ManageProperty_FastCreateOrderListDTO.getParsedOrderBelongMonth());
		
    	this.manageProperty_OrderInfoService.createFastOrderList_ManageProperty(ManageProperty_FastCreateOrderListDTO);
		return "redirect:/quan-ly";
    }
    @PostMapping("/quan-ly/nop-tien-coc")
    public String createReceiptForDeposit_ManageProperty(  @ModelAttribute("newDeposit")  ManageProperty_DepositDTO manageProperty_DepositDTO)  {
		//System.out.println("haha: "+orderList.getWorksheetList_withCurrentReading());
    	manageProperty_DepositDTO.setParsedOrderBelongMonth(manageProperty_DepositDTO.getOrderBelongMonth());
    	this.manageProperty_OrderInfoService.createOrderForDeposit_ManageProperty(manageProperty_DepositDTO);
		return "redirect:/quan-ly";
    }
	@PostMapping("/hop-dong/them")
	public String createWorksheet_PropertyManagePage(@ModelAttribute("newWorksheet") ManageProperty_CreateWorksheetDTO newWorksheet) {
	        // Process the submitted form data
	        // ...
		this.worksheetService.createWorksheet_At_ManageProperty(newWorksheet);
	    return "redirect:/quan-ly";
	}
    @PostMapping("/quan-ly/dat-coc-phong")
    public String bookProperty_ManageProperty(  @ModelAttribute("newBooking")  ManageProperty_BookDTO manageProperty_BookDTO)  {
		//System.out.println("haha: "+manageProperty_BookDTO);
    	this.worksheetService.bookProperty_At_ManageProperty(manageProperty_BookDTO);
		return "redirect:/quan-ly";
    }
    @PostMapping("/quan-ly/huy-coc")
    public String deleteWorksheet(@RequestParam("worksheetID") Long worksheetID) {
    	this.worksheetService.dropPrePaid_manageProperty(worksheetID);
    	//System.out.println(result);
    	return "redirect:/quan-ly";
    }
    @PostMapping("/quan-ly/checkin")
    public String checkinProperty(@RequestParam("worksheetID") Long worksheetID) {
    	this.worksheetService.checkinProperty_manageProperty(worksheetID);
    	//System.out.println(result);
    	return "redirect:/quan-ly";
    }
}
