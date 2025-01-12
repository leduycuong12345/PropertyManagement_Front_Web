function parseToNewTabAndPrintOrder(orderHTML) {
  	document.open();
  	document.write("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.css' rel='stylesheet'>" +
	      "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.js'></script></head><body onload='window.print();'>" + orderHTML + "</body></html>");
	document.close();
}
function printOrderFunction(){
	$('button[name="printButton"]').click(function(){
      var selectedMonth=$('li[name="selectedMonth"]').children("a").children("span").text();
      var selectedYear=$('input[name="selectedYear"]').val();
      var propertyName=$(this).closest('tr').children('td[name="propertyName"]').children("p:eq(0)").text();
      var propertyRentPrice=$(this).closest('tr').children('input[name="propertyRentPrice"]').val();//don gia tien phong
      var totalRentCost=$(this).closest('tr').children('td[name="totalRentCost"]').children('p:eq(0)').text();// tong tien phong
	  var totalAmount=$(this).closest('tr').children('td[name="totalAmount"]').children('p:eq(0)').text();//tong gia tri order
	  var remainingAmount=$(this).closest('tr').children('input[name="remainingAmount"]').val();//tong tien can phai thanh toan cua phieu thu tien nay
	  var totalDay=$(this).closest('tr').children('td[name="totalDay"]').children('p:eq(0)').text();
      var totalMonth=$(this).closest('tr').children('td[name="totalMonth"]').children('p:eq(0)').text();
	  var deligatedTenantName=$(this).closest('tr').children('input[name="deligatedTenantName"]').val();
	  var deligatedTenantPhoneNumber=$(this).closest('tr').children('input[name="deligatedTenantPhoneNumber"]').val();
	  var expanseNote=$(this).closest('tr').children('input[name="expanseNote"]').val();
	  var expanseType=$(this).closest('tr').children('td').children('input[name="expanseType"]').val();
	  var expanseCost=$(this).closest('tr').children('td').children('p[name="expanseCost"]').text();
	  var amount=$(this).closest('tr').children('input[name="debtAmount"]').val();        
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
	       var previousReadingValue=$(recurringExpansePreviousReadingValueList[index]).children("p:eq(0)").text();
	       var currentReadingValue=$(recurringExpanseCurrentReadingValueList[index]).children("p:eq(0)").text();
	       var totalExpanseCost=$(recurringExpanseTotalCostList[index]).children("p:eq(0)").text();
	       var expansePrice=$(recurringExpansePriceList[index]).val();
	       var expanseQuantity=$(recurringExpanseQuantityList[index]).val();
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
	                <td>${recurringExpanse.recurringExpanseName}</td>
	                <td>${recurringExpanse.expansePrice}</td>
	                <td>${recurringExpanse.previousReadingValue}</td>
	                <td>${recurringExpanse.currentReadingValue}</td>
	                <td>${recurringExpanse.expanseQuantity}</td>
	                <td>${recurringExpanse.totalExpanseCost}</td>
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
	                   <td>-${expanseCost}</td>
	                   `;
		 }
		 else
		 {
			 orderHtml += `
	    		   <tr>
	                   <td>Chi phí phát sinh</td>
	                   <td colspan="4"> Chi tiết : ${expanseNote} </td>
	                   <td>+${expanseCost}</td>
	                   `;
		 }
	  	 
	     orderHtml += `
	               </tr>
	               <tr>
	                   <td>Giá phòng</td>
	                   <td>${propertyRentPrice}</td>
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
    	var totalDay=$(element).closest('tr').children('td[name="totalDay"]').children('p').text();
    	var totalMonth=$(element).closest('tr').children('td[name="totalMonth"]').children('p').text();
    	var propertyRentMonthPrice=$(element).closest('tr').children('input[name="propertyRentPrice"]').val();
    	
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
      var number = parseInt(content);

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
      var number = parseInt(content);

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
	      var number = parseInt(content);
	
	      // Format the number with commas every 3 digits
	      var formattedNumber = number.toLocaleString();
	
	      // Replace the content of the <p> element with the formatted number
	      $(this).text(formattedNumber);
      });
     
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
    //end formatting number zone
});