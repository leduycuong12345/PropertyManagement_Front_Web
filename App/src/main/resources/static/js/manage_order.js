function parseToNewTabAndPrintOrder(orderHTML) {
  	document.open();
  	document.write("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.css' rel='stylesheet'>" +
	      "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.js'></script></head><body onload='window.print();'>" + orderHTML + "</body></html>");
	document.close();
}
function safeLoadFloatValue(containerValue)
{
	return parseFloat(containerValue.replace(/,/g, ''));
}
function formatValuesToWithComma_PrintFunction(value)
{
	// Format the number with commas every 3 digits
	      return formattedNumber = value.toLocaleString();
}
function printOrderFunction(){
	$('[name="printButton"]').click(function(){
      var selectedMonth=$('li[name="selectedMonth"]').children("a").children("span").text();
      var selectedYear=$('input[name="selectedYear"]').val();
      var propertyName=$(this).closest('tr').children('td[name="propertyName"]').children("p:eq(0)").text();
      var propertyRentPrice=safeLoadFloatValue($(this).closest('tr').children('input[name="propertyRentPrice"]').val());//don gia tien phong
      var totalRentCost=$(this).closest('tr').children('td[name="totalRentCost"]').children('p:eq(0)').text();// tong tien phong da duoc convert k can  parseFloat nua
	  var totalAmount=$(this).closest('tr').children('td[name="totalAmount"]').children('p:eq(0)').text();//tong gia tri order da duoc convert k can parseFloat nua
	  var remainingAmount=safeLoadFloatValue($(this).closest('tr').children('input[name="remainingAmount"]').val());//tong tien can phai thanh toan cua phieu thu tien nay
	  var totalDay=safeLoadFloatValue($(this).closest('tr').children('td[name="totalDay"]').children('p:eq(0)').text());
      var totalMonth=safeLoadFloatValue($(this).closest('tr').children('td[name="totalMonth"]').children('p:eq(0)').text());
	  var deligatedTenantName=$(this).closest('tr').children('input[name="deligatedTenantName"]').val();
	  var deligatedTenantPhoneNumber=$(this).closest('tr').children('input[name="deligatedTenantPhoneNumber"]').val();
	  var expanseNote=$(this).closest('tr').children('input[name="expanseNote"]').val();
	  var expanseType=$(this).closest('tr').children('td').children('input[name="expanseType"]').val();
	  var expanseCost=safeLoadFloatValue($(this).closest('tr').children('td').children('input[name="expanseCost"]').val());
	  var amount=safeLoadFloatValue($(this).closest('tr').children('input[name="debtAmount"]').val());        
      //get expansePreviousReadingValue
      var recurringExpansePreviousReadingValueList=[];
      recurringExpansePreviousReadingValueList=$(this).closest('tr').children("td[name='previousReadingValue']");
      //get expanseCurrentReadingValue
      var recurringExpanseCurrentReadingValueList=[];
      recurringExpanseCurrentReadingValueList=$(this).closest('tr').children("td[name='currentReadingValue']"); 
      //get expansetotalCost
      var recurringExpanseTotalCostList=[];
      recurringExpanseTotalCostList=$(this).closest('tr').children("td[name='totalExpanseCost']"); 
      var recurringExpansePriceList=[];
      recurringExpansePriceList=$(this).closest('tr').children("input[name='expansePrice']"); 
      var recurringExpanseQuantityList=[];
      recurringExpanseQuantityList=$(this).closest('tr').children("input[name='expanseQuantity']"); 
      
      const recurringExpanseList=[];
      
	  // Now you can work with the selected elements expanseHeader
	$("input[name='expanseHeader']").each(function(index, element) {
	       var recurringExpanseName= $(element).val(); 
	       var previousReadingValue=safeLoadFloatValue($(recurringExpansePreviousReadingValueList[index]).children('input[name="previousReadingValue"]').val());
	       var currentReadingValue=safeLoadFloatValue($(recurringExpanseCurrentReadingValueList[index]).children('input[name="currentReadingValue"]').val());
	       var totalExpanseCost=safeLoadFloatValue($(recurringExpanseTotalCostList[index]).children('input[name="totalExpanseCost"]').val());
	       var expansePrice=safeLoadFloatValue($(recurringExpansePriceList[index]).val());
	       var expanseQuantity=safeLoadFloatValue($(recurringExpanseQuantityList[index]).val());
	       if(currentReadingValue!=0 && currentReadingValue>previousReadingValue)//this recurringExpanse s currently active.
	       {
			   var recurringExpanse={
				   recurringExpanseName:recurringExpanseName,
				   previousReadingValue:previousReadingValue,
				   currentReadingValue:currentReadingValue,
				   totalExpanseCost:totalExpanseCost,
				   expansePrice:expansePrice,
				   expanseQuantity:expanseQuantity
			   }
			   recurringExpanseList.push(recurringExpanse);
		   }
	  });
	  
	  //make order HTML 
	  // Điền thông tin vào biểu mẫu
	   var orderHtml= `
	    	<h3 style='text-align: center;'>Tháng ${selectedMonth}/${selectedYear}</h2>
	        <h2 style='text-align: center;'>Phiếu thu tiền</h2>
	        <h4 style='text-align: center;'>Phòng ${propertyName}</h4>
	        <p>Tên khách hàng: ${deligatedTenantName}</p>
	        <p>Số điện thoại khách hàng: ${deligatedTenantPhoneNumber}</p>
	        <table class="table table-bordered">
	            <thead>
	                <tr>
	                    <th>Tên chi phí</th>
	                    <th>Đơn giá</th>
	                    <th>Số tháng trước</th>
	                    <th>Số tháng này</th>
	                    <th>Tiêu thụ</th>
	                    <th>Thành tiền</th>
	                </tr>
	            </thead>
	            <tbody>
	    `;
	    
	
	    recurringExpanseList.forEach(function(recurringExpanse) {
	        orderHtml += `
	            <tr>
	                <td>${formatValuesToWithComma_PrintFunction( recurringExpanse.recurringExpanseName )}</td>
	                <td>${formatValuesToWithComma_PrintFunction( recurringExpanse.expansePrice )}</td>
	                <td>${formatValuesToWithComma_PrintFunction( recurringExpanse.previousReadingValue )}</td>
	                <td>${formatValuesToWithComma_PrintFunction( recurringExpanse.currentReadingValue )}</td>
	                <td>${formatValuesToWithComma_PrintFunction( recurringExpanse.expanseQuantity )}</td>
	                <td>${formatValuesToWithComma_PrintFunction( recurringExpanse.totalExpanseCost )}</td>
	            </tr>
	        `;
	    });
	    orderHtml += `
	    		   <tr>
	    		   		<td colspan="6"></td>
	    		   </tr>`;
	     if(expanseType)
	     {
			 orderHtml += `
	    		   <tr>
	                   <td>Chi phí phát sinh</td>
	                   <td colspan="4"> Chi tiết : ${expanseNote} </td>
	                   <td>-${formatValuesToWithComma_PrintFunction( expanseCost )}</td>
	                   `;
		 }
		 else
		 {
			 orderHtml += `
	    		   <tr>
	                   <td>Chi phí phát sinh</td>
	                   <td colspan="4"> Chi tiết : ${expanseNote} </td>
	                   <td>+${formatValuesToWithComma_PrintFunction( expanseCost )}</td>
	                   `;
		 }
	  	 
	     orderHtml += `
	               </tr>
	               <tr>
	                   <td>Giá phòng</td>
	                   <td>${formatValuesToWithComma_PrintFunction( propertyRentPrice )}</td>
	                   <td colspan="3">Số tháng: ${totalMonth} + Số ngày: ${totalDay}  </td>
	                   <td>${totalRentCost}</td>
	               </tr>
	               <tr>
	                   <td colspan="5">Tổng phiếu thu tiền</td>
	                   <td>${totalAmount}</td>
	               </tr>
	               <tr>
	                   <td colspan="5">Tổng nợ</td>
	                   <td>${parseInt(remainingAmount).toLocaleString()}</td>
	               </tr>
	               <tr>
	                   <td colspan="5">Tổng tiền còn phải thanh toán</td>
	                   <td>${parseInt(amount).toLocaleString()}</td>
	               </tr>
	               
	            </tbody>
	        </table>
	        <div class="row">
	        	<div class="col"></div>
	        	<div class="col"></div>
	        	<div class="col">
	        	<h5>Đại diện tài sản</h5>
	        	</div>
	        </div>
	        
	    `;
	
	    $("#printingOrder").html(orderHtml);
	    parseToNewTabAndPrintOrder(orderHtml);
    });
}

$(function () {
  var token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");
  $(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
  });
});

function calculateTotalPrice() {
  	var calculatePrice = $('td[name="totalRentCost"]');
    
    // Now you can work with the selected input elements
    calculatePrice.each(function(index, element) {
        // Do something with each input element
        //console.log($(element).val()); // Print the value of the input element
    	var totalDay= safeLoadFloatValue( $(element).closest('tr').children('td[name="totalDay"]').children('p').text());
    	var totalMonth= safeLoadFloatValue( $(element).closest('tr').children('td[name="totalMonth"]').children('p').text());
    	var propertyRentMonthPrice= safeLoadFloatValue($(element).closest('tr').children('input[name="propertyRentPrice"]').val());
    	
    	var propertyRentDayPrice=propertyRentMonthPrice/30;
    	var totalCost=(totalDay*propertyRentDayPrice)+(propertyRentMonthPrice*totalMonth);
    	
    	//round up to 3 digit decimal
    	var totalAmount=totalCost.toFixed(3);
    	$(element).children('p').text(totalAmount);
    });
}
function filter_orderList_manageOrder()
{
	$("#deletedOrderFilter").change(function() {
		if(this.checked) {
			var value = "đã bị hủy";
		    $("#propertyList tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		}
		else
		{
			//neu uncheck checkbox thì trả lại giá trị danh sách như ban đầu
			var value = "";
		    $("#propertyList tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		}
	});
	$("#onDebtOrderFilter").change(function() {
		if(this.checked) {
		    var value = "chưa thanh toán hết";
		    $("#orderList tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
	    }
	    else
		{
			//neu uncheck checkbox thì trả lại giá trị danh sách như ban đầu
			var value = "";
		    $("#orderList tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		}
	});
	$("#paidOrderFilter").change(function() {
		if(this.checked) {
		    var value = "đã thanh toán";
		    $("#orderList tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
	    }
	    else
		{
			//neu uncheck checkbox thì trả lại giá trị danh sách như ban đầu
			var value = "";
		    $("#orderList tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		}
	});
	$("#unpaidOrderFilter").change(function() {
		if(this.checked) {
		    var value = "chưa thanh toán";
		    $("#orderList tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		}
		else
		{
			//neu uncheck checkbox thì trả lại giá trị danh sách như ban đầu
			var value = "";
		    $("#orderList tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		}
	});
}
function statisticAmount()
{
	var monthAmount=0.0;
	var unpaidMonthAmount=0.0;
	var paidMonthAmount=0.0;
	
	$("#orderList tr").each(function(key,container) { 
		var total=parseFloat($(container).children("td[name='totalAmount']").children("p:eq(0)").text());
		var orderStatus=parseInt($(container).children("input[name='orderStatus']").val());
		var remainingAmount=parseFloat($(container).children("td[name='remainingAmount']").children("p:eq(0)").text());
		switch(orderStatus) {
			case 4: // đã thanh toán hết
				monthAmount+=total;
			    paidMonthAmount+=total;
			    break;
			case 2:// chưa thanh toán
				monthAmount+=total;
				unpaidMonthAmount+=remainingAmount;
			    break;
			case 3:// xử lý chưa thanh toán hết
				monthAmount+=total;
				unpaidMonthAmount+=remainingAmount;
				paidMonthAmount+=total-remainingAmount;
			default:// đơn đã bị hủy ??
			    // code block
		}
	});
	
	$("#monthAmount").text(monthAmount);
	$("#unpaidMonthAmount").text(unpaidMonthAmount);
	$("#paidMonthAmount").text(paidMonthAmount);
}


function formatRemainingAmountWithComma()
{
	// Iterate through each <li> with name "remainingAmount"
    $('td[name="remainingAmount"]').each(function() {
      // Get the content of the <p> element
      var content = $(this).find('p').text();
      
      // Convert the content to a number
      var number = safeLoadFloatValue(content);

      // Format the number with commas every 3 digits
      var formattedNumber = number.toLocaleString();

      // Replace the content of the <p> element with the formatted number
      $(this).find('p').text(formattedNumber);
    });
}
function formatTotalRentCostWithComma()
{
	// Iterate through each <li> with name "remainingAmount"
    $('td[name="totalRentCost"]').each(function() {
      // Get the content of the <p> element
      var content = $(this).find('p').text();
      
      // Convert the content to a number
      var number = safeLoadFloatValue(content);

      // Format the number with commas every 3 digits
      var formattedNumber = number.toLocaleString();

      // Replace the content of the <p> element with the formatted number
      $(this).find('p').text(formattedNumber);
    });
    
}
function formatTotalExpanseCostWithComma()
{
	// Iterate through each <li> with name "totalExpanseCost"
    $('td[name="totalExpanseCost"]').each(function() {
      // Get the content of the <p> element
      var content = $(this).find('p').text();
      
      // Convert the content to a number
      var number = safeLoadFloatValue(content);

      // Format the number with commas every 3 digits
      var formattedNumber = number.toLocaleString();

      // Replace the content of the <p> element with the formatted number
      $(this).find('p').text(formattedNumber);
    });
    
}
function formatCurrentReadingValueWithComma()
{
	// Iterate through each <li> with name "currentReadingValue"
    $('td[name="currentReadingValue"]').each(function() {
      // Get the content of the <p> element
      var content = $(this).find('p').text();
      
      // Convert the content to a number
      var number = safeLoadFloatValue(content);

      // Format the number with commas every 3 digits
      var formattedNumber = number.toLocaleString();

      // Replace the content of the <p> element with the formatted number
      $(this).find('p').text(formattedNumber);
    });
    
}
function formatTotalAmountWithComma()
{
	// Iterate through each <li> with name "remainingAmount"
    $('td[name="totalAmount"]').each(function() {
		  $(this).find('p').each(function() {
	      		 // Get the content of the <p> element
	      var content = $(this).text();
	      
	      // Convert the content to a number
	      var number = safeLoadFloatValue(content);
	
	      // Format the number with commas every 3 digits
	      var formattedNumber = number.toLocaleString();
	
	      // Replace the content of the <p> element with the formatted number
	      $(this).text(formattedNumber);
      });
     
    });
    
}
function formatPreviousReadingValueWithComma()
{
	// Iterate through each <li> with name "previousReadingValue"
    $('td[name="previousReadingValue"]').each(function() {
		  $(this).find('p').each(function() {
	      		 // Get the content of the <p> element
	      var content = $(this).text();
	      
	      // Convert the content to a number
	      var number = safeLoadFloatValue(content);
	
	      // Format the number with commas every 3 digits
	      var formattedNumber = number.toLocaleString();
	
	      // Replace the content of the <p> element with the formatted number
	      $(this).text(formattedNumber);
      });
     
    });
    
}
function formatExpanseCostWithComma()
{
	// Iterate through each <li> with name "expanseCost"
    $('p[name="expanseCost"]').each(function() {
	      var content = $(this).text();
	      
	      // Convert the content to a number
	      var number = safeLoadFloatValue(content);
	
	      // Format the number with commas every 3 digits
	      var formattedNumber = number.toLocaleString();
	
	      // Replace the content of the <p> element with the formatted number
	      $(this).text(formattedNumber);
     
    });
    
}
function formatVnFormatCurrency()
{
	// Iterate through each <li> with name "VnFormatCurrency"
    $('.VnFormatCurrency').each(function() {
	      var content = $(this).text();
	      
	      // Convert the content to a number
	      var number = safeLoadFloatValue(content);
	
	      // Format the number with commas every 3 digits
	      var formattedNumber = number.toLocaleString();
	
	      // Replace the content of the <p> element with the formatted number
	      $(this).text(formattedNumber);
     
    });
    
}
function formatNumberTextarea_FocusOn_BlurOut()
{
	 // On focus: convert UI display from "1.500.500" -> "1500500"
    $('textarea.formatNumberTextarea').on('focus', function() {
        var text = $(this).val().trim(); 
        var raw = text.replace(/\./g, ""); // remove all dot 
        $(this).text(raw);
        $(this).val(raw);
    });

    // On blur: convert display back "1500500,5" -> "1.500.500,5"
    $('textarea.formatNumberTextarea').on('blur', function() {
    	var content =  $(this).closest('div').children('input[name="receiptAmount"]').val() ;
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    //parse to textarea display UI
	    $(this).val(formattedNumber);
	    $(this).text(formattedNumber);
    });
}
function updateValueToHiddenInputField_editableTextarea_Receipt()
{
	$(".editable_receiptAmount_textarea").change(function (e) {
           var content=$(this).val();
           
           //update value of hidden input after edit at textarea to submit post form if needed be.
           $(this).closest('div').children('input[name="receiptAmount"]').val(content);
     });
}
function numberInputrOnly_receiptAmount_editableTextarea_Receipt()
{
	$(".editable_receiptAmount_textarea").keypress(function (e) {
	    var allowedCharacters = []; // Mã ký tự của dấu d0t và các số từ 0 đến 9 
	    //"." (dot) = 46"," (comma) = 44
	    var keyCode = e.which;
	    
	    if (!(allowedCharacters.includes(keyCode) || (keyCode >= 48 && keyCode <= 57))) {
	        e.preventDefault();
	    }
	});
}
function formatNumber_receiptAmount_editableTextarea_Receipt_firstTimeRender()
{
	$('.editable_receiptAmount_textarea').each(function() {
        var content = $(this).val();
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);
    });
}
$(document).ready(function(){

	printOrderFunction();
	//calculate all rentPrice=totalTime*Price
	calculateTotalPrice();
    //filter function for orderList in manage_order
    filter_orderList_manageOrder();
    
    statisticAmount();
    
    //formatting number zone
    formatRemainingAmountWithComma();
    formatTotalRentCostWithComma();
    formatTotalAmountWithComma();
    formatTotalExpanseCostWithComma();
    formatCurrentReadingValueWithComma();
    formatPreviousReadingValueWithComma();
    formatExpanseCostWithComma();
    formatVnFormatCurrency();
    //end formatting number zone
    
    //formatting textarea create-receipt
    updateValueToHiddenInputField_editableTextarea_Receipt();
    formatNumberTextarea_FocusOn_BlurOut();
    numberInputrOnly_receiptAmount_editableTextarea_Receipt();
    formatNumber_receiptAmount_editableTextarea_Receipt_firstTimeRender();
    //formatting textarea create-receipt ending
    
});