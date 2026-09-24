//function for create-worksheet sequences
function updateValueWithID_RecurringExpanse_CreateWorksheet() {
	$('input[name="recurringExpanseValue"]').change(function(x){
	  var reccuringExpanseID=$(this).closest('div[name="expanseContainer"]').children('input[name="expanseID"]').val();//find the id of reccuringExpanse
	  var readingValue=	$(this).val();
	  var result=reccuringExpanseID+"_"+readingValue;
	  //add value to input type=checkbox th:field="selectedExpanseList" which s init as List<String> selectedExpanseList=new ArrayList<String>();
	  $(this).closest('div[name="expanseContainer"]').children('input[name="selectedExpanseList"]').val(result);
  });
}
function safeLoadFloatValue(containerValue)
{
	return parseFloat(containerValue.replace(/,/g, ''));
}
function safeLoadIntValue(containerValue)
{
	return parseInt(containerValue.replace(/,/g, ''));
}
function callFunctionFor_CreateWorksheet_Sequences()
{
	updateValueWithID_RecurringExpanse_CreateWorksheet();
}
//end function for create-worksheet sequences

//calculateTotalCost CreateOrder ManageProperty
function calculateTotalCost_CreateOrder_ManageProperty()
{
	//all input ve class="calculateTotalCost_CreateOrder" ll trigger this function when change value.
	$(".calculateTotalCost_CreateOrder").change(function(x){
	  let currentWorksheetPrice=0;
	  currentWorksheetPrice=parseFloat($(this).closest('form').children('input[name="currentPropertyRentalPrice"]').val());//find the id of reccuringExpanse
	  let averageCostPerDay=0;
	  averageCostPerDay=currentWorksheetPrice/30;
	  let totalMonth=0;
	  totalMonth=parseInt($(this).closest('form').children('div').children('input[name="totalMonth"]').val());
	  let totalDay=0;
	  totalDay=parseInt($(this).closest('form').children('div').children('input[name="totalDay"]').val());
	  let unexpectedExpanseCost=0;
	  unexpectedExpanseCost=safeLoadFloatValue($(this).closest('form').children('div').children('input[name="expanseCost"]').val());
	  if(isNaN(currentWorksheetPrice))
	  {
		currentWorksheetPrice=0;
	  }
	  if(isNaN(totalMonth))
	  {
		totalMonth=0;
	  }
	  if(isNaN(totalDay))
	  {
		totalDay=0;
	  }
	  if(isNaN(unexpectedExpanseCost))
	  {
		unexpectedExpanseCost=0;
	  }
	  let totalCost=(totalMonth*currentWorksheetPrice)+(totalDay*averageCostPerDay);
	  
	  //calculate unexpectedExpanse
	  let isPlus=$(this).closest('form').children('input[name="expanseType"]:checked').val();
      if(isPlus==='true')
      {
        totalCost=totalCost+unexpectedExpanseCost;
      }
      else
      {
		totalCost=totalCost-unexpectedExpanseCost;
      }
      
      //calculate repeatedExpanse
      $(this).closest('form').children('div').children('div').children('div').children('div[name="expanseContainer"]').each(function(key,container) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
			
		    let expanseType=parseInt($(container).children('input[name="recurringExpanseType"]').val());
			if(isNaN(expanseType))
			{
				expanseType=0;
			}
			if(expanseType==3)
	  		{
		     	let currentReading=safeLoadFloatValue($(container).children('div').children('input[name="currentReading"]').val());
				if(isNaN(currentReading))
				{
						currentReading=0;
				}
				let lastReading=safeLoadFloatValue($(container).children('div').children('input[name="lastReading"]').val());
				if(isNaN(lastReading))
				{
					lastReading=0;
				}
				let expansePrice=safeLoadFloatValue($(container).children('input[name="recurringExpansePrice"]').val());
				if(isNaN(expansePrice))
				{
					expansePrice=0;
				}
				if(currentReading>0 && lastReading>=0 && lastReading<currentReading &&expansePrice>0)
				{
					let expanseCost=(currentReading-lastReading)*expansePrice;
					totalCost=totalCost+expanseCost;
				}
		    }
		    else
		    {
				if(expanseType==2 || expanseType==1)
				{
					let currentReading=safeLoadFloatValue($(container).children('div').children('input[name="currentReading"]').val());
					if(isNaN(currentReading))
					{
							currentReading=0;
					}
					let expansePrice=safeLoadFloatValue($(container).children('input[name="recurringExpansePrice"]').val());
					if(isNaN(expansePrice))
					{
						expansePrice=0;
					}
					if(currentReading>0  &&expansePrice>0)
					{
						let expanseCost=currentReading*expansePrice;
						totalCost=totalCost+expanseCost;
					}	
				}
			}
			
	  });
      //end calculate repeatedExpanse
	  
	  //làm tròn totalCost
	  //totalCost = Math.round(totalCost * 1000) / 1000;
	  totalCost=totalCost.toFixed(3);
	  let orderDetails="";
	  orderDetails=""+totalMonth+" tháng," +totalDay+" ngày x"+currentWorksheetPrice+" = "+totalCost;
	  //set value for detailsOrder so user know what they entered.
	  $(this).closest('form').children('textarea[name="orderDetails"]').val(orderDetails);
  	  //set value to totalCost and display it as totalCostText
  	  $(this).closest('form').children('input[name="totalCost"]').val(totalCost);
  	  $(this).closest('form').children('textarea[name="orderDetailsText"]').val(orderDetails);
  	  $(this).closest('.modal-content').children('.modal-footer').children('input[name="totalCostText"]').val(totalCost);
  	});
  	
}
function generate_IDwithReading_RecurringExpanse_CreateOrder() {
	$("input.updateReadingWithID").change(function(x){
	  let expanseType=parseInt($(this).closest('div[name="expanseContainer"]').children('input[name="recurringExpanseType"]').val());
	  if(isNaN(expanseType))
	  {
		 expanseType=0;
	  }
	  if(expanseType==3)
	  {
			var reccuringExpanseID=$(this).closest('div[name="expanseContainer"]').children('input[name="propertyServiceID"]').val();//find the id of reccuringExpanse
			var currentReading=safeLoadFloatValue($(this).closest('div[name="expanseContainer"]').children('div').children('input[name="currentReading"]').val());
			var lastReading=safeLoadFloatValue($(this).closest('div[name="expanseContainer"]').children('div').children('input[name="lastReading"]').val());
			var result=reccuringExpanseID+"_"+lastReading+"_"+currentReading;
			//add value to input type=checkbox th:field="selectedExpanseList" which s init as List<String> selectedExpanseList=new ArrayList<String>();
			$(this).closest('div[name="expanseContainer"]').children('input[name="recurringExpanseList_withCurrentReading"]').val(result);
	  }
	  else
	  {
		if(expanseType==2 || expanseType ==1)
		{
			var reccuringExpanseID=$(this).closest('div[name="expanseContainer"]').children('input[name="propertyServiceID"]').val();//find the id of reccuringExpanse
			var readingValue=	safeLoadFloatValue( $(this).val());
			var result=reccuringExpanseID+"_"+readingValue;
			//add value to input type=checkbox th:field="selectedExpanseList" which s init as List<String> selectedExpanseList=new ArrayList<String>();
			$(this).closest('div[name="expanseContainer"]').children('input[name="recurringExpanseList_withCurrentReading"]').val(result);
		 }
	  }
    });
}
function callFunctionFor_CreateOrder_Sequences()
{
	generate_IDwithReading_RecurringExpanse_CreateOrder();
	calculateTotalCost_CreateOrder_ManageProperty();
}

//end calculateTotalCost CreateOrder ManageProperty

//start fast-edit-expanse-list
function generateValue_IDwithLastReading_FastEditExpanseList() {
	$("input.updateValue_FastEditExpanseList").change(function(x){
	  let expanseType=parseInt($(this).closest('div[name="expanseContainer"]').children('input[name="recurringExpanseType"]').val());
	  if(isNaN(expanseType))
	  {
		 expanseType=0;
	  }
	  if(expanseType==2)
	  {
			var reccuringExpanseID=$(this).closest('div[name="expanseContainer"]').children('input[name="propertyServiceID"]').val();//find the id of reccuringExpanse
			var expanseIsSelect=$(this).closest('div[name="expanseContainer"]').children('input[name="selectExpanse"]').prop('checked');
			var currentReading=1;
			var result=reccuringExpanseID+"_"+expanseIsSelect+"_"+currentReading;
			//add value to input type=checkbox th:field="selectedExpanseList" which s init as List<String> selectedExpanseList=new ArrayList<String>();
			$(this).closest('div[name="expanseContainer"]').children('input[name="editExpanseList"]').val(result);
	  }
	  else
	  {
		if(expanseType==1 || expanseType ==3)
		{
			var reccuringExpanseID=$(this).closest('div[name="expanseContainer"]').children('input[name="propertyServiceID"]').val();//find the id of reccuringExpanse
			var expanseIsSelect=$(this).closest('div[name="expanseContainer"]').children('input[name="selectExpanse"]').prop('checked');
			var currentReading=safeLoadFloatValue($(this).closest('div[name="expanseContainer"]').children('div').children('input[name="currentReading"]').val());
			var result=reccuringExpanseID+"_"+expanseIsSelect+"_"+currentReading;
			//add value to input type=checkbox th:field="selectedExpanseList" which s init as List<String> selectedExpanseList=new ArrayList<String>();
			$(this).closest('div[name="expanseContainer"]').children('input[name="editExpanseList"]').val(result);
		 }
	  }
    });
}
function callFunctionFor_FastEditExpanseList_Sequences()
{
	generateValue_IDwithLastReading_FastEditExpanseList();	
}
//end fast-edit-expanse-list
var count=0;
var pointers=[];
function checkDuplicatedPointer_AllowChanged(x)
{
	//check duplicated pointer
	if(pointers.includes(x))
	{
		return true;
	}
	else
	{
		//check duplicated row because we send a whole row anyway 
		var judgePropertyID="";
		var loopResult=false;//because return ll only break $.each but neither the function itself
		judgePropertyID=$(x).closest("tr").children('input').val();
		$.each(pointers, function(index,element){
	    	var propertyID="";
	    	propertyID=$(element).closest("tr").children('input').val();
	    	if(judgePropertyID===propertyID && judgePropertyID!="" && propertyID!="")
	    	{
				loopResult= true;
			}
		});
		return loopResult;
	}
	
}
function allowToSave(x) {
  
  
  if(!checkDuplicatedPointer_AllowChanged(x))//check duplicated pointer
  //if(!pointers.includes(x))
  {
  	count+=1;
  	pointers.push(x);
  	document.getElementById("editPropertyNotificationText").innerHTML = "Bạn có muốn thay đổi "+count+ " hàng thông tin tài sản?";
  
  	// Get a reference to your modal
	/*var editPropertyNotificationModal = document.getElementById('saveChangePropertyNotificationModal'); 
	
	// Create an instance of the Bootstrap modal
	var triggerEditPropertyNotificationToast = new bootstrap.Toast(editPropertyNotificationModal)
	
	// Show the modal
	triggerEditPropertyNotificationToast.show(); */
	$('#saveChangePropertyNotificationModal').toast('show');
  }
}

$(function () {
  var token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");
  $(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
  });
});
function postChangedPropertyToAPI(item, index) {
  
  
  var propertyID=$(item).closest("tr").children('input').val() ?? "";
  var worksheetTimeInverval=$(item).closest("tr").children('td:eq(4)').children('div').children('div').children('select').children('option:selected').val() ?? -1;
  var propertyName=$(item).closest("tr").children('td:eq(0)').children('textarea').val() ?? "";
  var propertyRentalPrice=parseFloat($(item).closest("tr").children('td:eq(1)').children('div').children('input.updatePropertyRentalPrice').val().replace(/,/g,'')) ?? 0;
  var worksheetTotalDeposit=parseFloat($(item).closest("tr").children('td:eq(2)').children('div').children('div').children('input.updateWorksheetTotalDeposit').val().replace(/,/g,'')) ?? 0;
  var worksheetOrderCreationDate=$(item).closest("tr").children('td:eq(3)').children('div').children('div').children('select').children('option:selected').val() ?? -1;
					
  
  var property={
					propertyID:propertyID,
					propertyName:propertyName,
					propertyRentalPrice:propertyRentalPrice,
					worksheetTotalDeposit:worksheetTotalDeposit,
					worksheetOrderCreationDate:worksheetOrderCreationDate,
					worksheetTimeInverval:worksheetTimeInverval
  }
  $.ajax({
            type: "POST",
            contentType: "application/json",
            url:"/quan-ly/sua-tai-san", // Điều chỉnh URL tương ứng với Spring Boot
            data: JSON.stringify(property),
            success: function(response) {
                console.log("Đã gửi đối tượng thành công.");
                // Xử lý phản hồi từ máy chủ nếu cần
                window.location.href ="/quan-ly";
            },
            error: function(error) {
                console.log("Lỗi khi gửi đối tượng: " + error);
            }
   });
}
//update formatNumber at updateWorksheetTotalDeposit updatePropertyRentalPrice editProperty
function numberInputrOnly_editableTextarea_editProperty()
{
	$(".editable_property_textarea").keypress(function (e) {
	    var allowedCharacters = []; // Mã ký tự của dấu d0t và các số từ 0 đến 9
	    //"." (dot) = 46"," (comma) = 44
	    var keyCode = e.which;
	    
	    if (!(allowedCharacters.includes(keyCode) || (keyCode >= 48 && keyCode <= 57))) {
	        e.preventDefault();
	    }
	});
}
function formatNumberTextarea_updateWorksheetTotalDeposit_EditProperty_FocusOn_BlurOut()
{
	 // On focus: convert UI display from "1.500.500" -> "1500500"
    $('textarea.editable_updateWorksheetTotalDeposit_EditProperty_textarea').on('focus', function() {
        var text = $(this).val().trim(); 
        var raw = text.replace(/\./g, ""); // remove all dot 
        $(this).text(raw);
        $(this).val(raw);
    });

    // On blur: convert display back "1500500,5" -> "1.500.500,5"
    $('textarea.editable_updateWorksheetTotalDeposit_EditProperty_textarea').on('blur', function() {
    	var content =  $(this).closest('div').children('input.updateWorksheetTotalDeposit').val() ;
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    //parse to textarea display UI
	    $(this).val(formattedNumber);
	    $(this).text(formattedNumber);
    });
}
function formatNumber_updateWorksheetTotalDeposit_EditProperty_editableTextarea_firstTimeRender()
{
	$('.editable_updateWorksheetTotalDeposit_EditProperty_textarea').each(function() {
        var content = $(this).val();
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);
    });
}
function updateValueToHiddenInputField_editableTextarea_updateWorksheetTotalDeposit_EditPropertỵ()
{
	$(".editable_updateWorksheetTotalDeposit_EditProperty_textarea").change(function (e) {
           var content=$(this).val();
           
           //update value of hidden input after edit at textarea to submit post form if needed be.
           $(this).closest('div').children('input.updateWorksheetTotalDeposit').val(content);
     });
}
function formatNumberTextarea_updatePropertyRentalPrice_EditProperty_FocusOn_BlurOut()
{
	 // On focus: convert UI display from "1.500.500" -> "1500500"
    $('textarea.editable_updatePropertyRentalPrice_EditProperty_textarea').on('focus', function() {
        var text = $(this).val().trim(); 
        var raw = text.replace(/\./g, ""); // remove all dot 
        $(this).text(raw);
        $(this).val(raw);
    });

    // On blur: convert display back "1500500,5" -> "1.500.500,5"
    $('textarea.editable_updatePropertyRentalPrice_EditProperty_textarea').on('blur', function() {
    	var content =  $(this).closest('div').children('input.updatePropertyRentalPrice').val() ;
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    //parse to textarea display UI
	    $(this).val(formattedNumber);
	    $(this).text(formattedNumber);
    });
}
function formatNumber_updatePropertyRentalPrice_EditProperty_editableTextarea_firstTimeRender()
{
	$('.editable_updatePropertyRentalPrice_EditProperty_textarea').each(function() {
        var content = $(this).val();
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);
    });
}
function updateValueToHiddenInputField_editableTextarea_updatePropertyRentalPrice_EditProperty()
{
	$(".editable_updatePropertyRentalPrice_EditProperty_textarea").change(function (e) {
           var content=$(this).val();
           
           //update value of hidden input after edit at textarea to submit post form if needed be.
           $(this).closest('div').children('input.updatePropertyRentalPrice').val(content);
     });
}
function updateNumberFormat_EditProperty()
{
	numberInputrOnly_editableTextarea_editProperty();
	
	formatNumberTextarea_updateWorksheetTotalDeposit_EditProperty_FocusOn_BlurOut();
	formatNumber_updateWorksheetTotalDeposit_EditProperty_editableTextarea_firstTimeRender();
	updateValueToHiddenInputField_editableTextarea_updateWorksheetTotalDeposit_EditPropertỵ();
	
	formatNumberTextarea_updatePropertyRentalPrice_EditProperty_FocusOn_BlurOut();
	updateValueToHiddenInputField_editableTextarea_updatePropertyRentalPrice_EditProperty();
	formatNumber_updatePropertyRentalPrice_EditProperty_editableTextarea_firstTimeRender();
}
//update formatNumber at updateWorksheetTotalDeposit updatePropertyRentalPrice editProperty ending

function filter_propertyList_manageProperty()
{
	$("#noWorksheetFilter").change(function() {
		if(this.checked) {
			var value = "chưa cho thuê";
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
	$("#bookedFilter").change(function() {
		if(this.checked) {
		    var value = "đã cọc giữ chỗ";
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
	$("#noDepositFilter").change(function() {
		if(this.checked) {
		    var value = "chưa thu tiền cọc";
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
	$("#onDebtFilter").change(function() {
		if(this.checked) {
		    var value = "nợ tiền";
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
	$("#usagePropetyFilter").change(function() {
		if(this.checked) {
		    var value = "đang ở";
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
}
function sumRecurringExpanse_calculateTotalCost(x,totalCost)
{
	$(x).closest('div[name="fastCreateOrder"]').children('div').children('div').children('div').children('div[name="expanseContainer"]').each(function(key,container) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
			
		    let expanseType=parseInt($(container).children('input[name="recurringExpanseType"]').val());
			if(isNaN(expanseType))
			{
				expanseType=0;
			}
			if(expanseType==3)
	  		{
		     	let currentReading=safeLoadFloatValue( $(container).children('div').children('input[name="currentReading"]').val());
				if(isNaN(currentReading))
				{
						currentReading=0;
				}
				let lastReading=safeLoadFloatValue( $(container).children('div').children('input[name="lastReading"]').val() );
				if(isNaN(lastReading))
				{
					lastReading=0;
				}
				let expansePrice=safeLoadFloatValue( $(container).children('input[name="recurringExpansePrice"]').val());
				if(isNaN(expansePrice))
				{
					expansePrice=0;
				}
				if(currentReading>0 && lastReading>=0 && lastReading<currentReading &&expansePrice>0)
				{
					let expanseCost=(currentReading-lastReading)*expansePrice;
					totalCost=totalCost+expanseCost;
				}
		    }
		    else
		    {
				if(expanseType==1)
				{
					let currentReading=safeLoadFloatValue( $(container).children('div').children('input[name="currentReading"]').val() );
					if(isNaN(currentReading))
					{
							currentReading=0;
					}
					let expansePrice=safeLoadFloatValue( $(container).children('input[name="recurringExpansePrice"]').val() );
					if(isNaN(expansePrice))
					{
						expansePrice=0;
					}
					if(currentReading>0  &&expansePrice>0)
					{
						let expanseCost=currentReading*expansePrice;
						totalCost=totalCost+expanseCost;
					}	
				}
				if(expanseType==2 )
				{
					let currentReading=1;
					let expansePrice=safeLoadFloatValue( $(container).children('input[name="recurringExpansePrice"]').val());
					if(isNaN(expansePrice))
					{
						expansePrice=0;
					}
					if(currentReading>0  &&expansePrice>0)
					{
						let expanseCost=currentReading*expansePrice;
						totalCost=totalCost+expanseCost;
					}	
				}
			}
	  });
	  $(x).closest('div[name="fastCreateOrder"]').children('input[name="totalCost"]').val(totalCost);
}
function calculateTotalCost_CreateFastOrderList_ManageProperty()
{
	//calculatte each order-totalCost each orderList
	$("input.calculateOrderList").change(function(x){
	  let currentWorksheetPrice=0;
	  currentWorksheetPrice=parseFloat($(this).closest('div[name="fastCreateOrder"]').children('input[name="currentPropertyRentalPrice"]').val());//find the id of reccuringExpanse
	  let averageCostPerDay=0;
	  averageCostPerDay=currentWorksheetPrice/30;
	  let totalMonth=0;
	  totalMonth=parseInt($(this).closest("#fastCreateOrderListForm").children('div').children('input[name="orderList_TotalMonth"]').val());
	  let totalDay=0;
	  totalDay=parseInt($(this).closest("#fastCreateOrderListForm").children('div').children('input[name="orderList_TotalDay"]').val());
	  if(isNaN(currentWorksheetPrice))
	  {
		currentWorksheetPrice=0;
	  }
	  if(isNaN(totalMonth))
	  {
		totalMonth=0;
	  }
	  if(isNaN(totalDay))
	  {
		totalDay=0;
	  }
	  let totalCost=(totalMonth*currentWorksheetPrice)+(totalDay*averageCostPerDay);
	  
	  
      
      //calculate repeatedExpanse
      sumRecurringExpanse_calculateTotalCost(this,totalCost);
      //end calculate repeatedExpanse
	  
  	  //set value to totalCost and display it as totalCostText
  	 
  	  
  	 
  	 });
}
function updateTotalCostWhileEditTotalMonthAndTotalDay_FastCreateOrderList_ManageProperty()
{
   $("input.updateTotalCost_FastCreateOrderList").change(function(x){	
	$("#fastCreateOrderListForm").children('div').children('div').children('div[name="fastCreateOrder"]').each(function(key,container) {
	      let currentWorksheetPrice=0;
		  currentWorksheetPrice=parseFloat($(this).closest('div[name="fastCreateOrder"]').children('input[name="currentPropertyRentalPrice"]').val());//find the id of reccuringExpanse
		  let averageCostPerDay=0;
		  averageCostPerDay=currentWorksheetPrice/30;
		  let totalMonth=0;
		  totalMonth=parseInt($(this).closest("#fastCreateOrderListForm").children('div').children('input[name="orderList_TotalMonth"]').val());
		  let totalDay=0;
		  totalDay=parseInt($(this).closest("#fastCreateOrderListForm").children('div').children('input[name="orderList_TotalDay"]').val());
		  if(isNaN(currentWorksheetPrice))
		  {
			currentWorksheetPrice=0;
		  }
		  if(isNaN(totalMonth))
		  {
			totalMonth=0;
		  }
		  if(isNaN(totalDay))
		  {
			totalDay=0;
		  }
		  let totalCost=(totalMonth*currentWorksheetPrice)+(totalDay*averageCostPerDay);
		  
		  
	      
	      //calculate repeatedExpanse
	      sumRecurringExpanse_calculateTotalCost(this,totalCost);
	    });
	});
}
function renderStateCalculateTotalCost_FastCreateOrderList_ManageProperty()
{
	$("#fastCreateOrderListForm").children('div').children('div').children('div[name="fastCreateOrder"]').each(function(key,container) {
	      let currentWorksheetPrice=0;
		  currentWorksheetPrice=parseFloat($(this).closest('div[name="fastCreateOrder"]').children('input[name="currentPropertyRentalPrice"]').val());//find the id of reccuringExpanse
		  let averageCostPerDay=0;
		  averageCostPerDay=currentWorksheetPrice/30;
		  let totalMonth=0;
		  totalMonth=parseInt($(this).closest("#fastCreateOrderListForm").children('div').children('input[name="orderList_TotalMonth"]').val());
		  let totalDay=0;
		  totalDay=parseInt($(this).closest("#fastCreateOrderListForm").children('div').children('input[name="orderList_TotalDay"]').val());
		  if(isNaN(currentWorksheetPrice))
		  {
			currentWorksheetPrice=0;
		  }
		  if(isNaN(totalMonth))
		  {
			totalMonth=0;
		  }
		  if(isNaN(totalDay))
		  {
			totalDay=0;
		  }
		  let totalCost=(totalMonth*currentWorksheetPrice)+(totalDay*averageCostPerDay);
		  
		  
	      
	      //calculate repeatedExpanse
	      sumRecurringExpanse_calculateTotalCost(this,totalCost);
	});
}
function createFastOrderList() {
  let totalMonth=0;
  totalMonth=parseInt($("#fastCreateOrderListForm").children('div').children('input[name="orderList_TotalMonth"]').val());
  let totalDay=0;
  totalDay=parseInt($("#fastCreateOrderListForm").children('div').children('input[name="orderList_TotalDay"]').val());
  let orderList_BelongMonth=$("#fastCreateOrderListForm").children('div').children('input[name="orderList_BelongMonth"]').val();
  let orderListCreateDate=$("#fastCreateOrderListForm").children('div').children('input[name="orderList_CreateDate"]').val();
  let orderList_ExpireDate=$("#fastCreateOrderListForm").children('div').children('input[name="orderList_ExpireDate"]').val();
  if(isNaN(totalMonth))
  {
		totalMonth=0;
  }
  if(isNaN(totalDay))
  {
		totalDay=0;
  }
  var worksheetList_withCurrentReading=[];
  $("#fastCreateOrderListForm").children('div').children('div').children('div[name="fastCreateOrder"]').each(function(key,bigContainer) {
	 
	 var expanseList=[];
	 //if selected then this worksheet ll generate order
	
	 	$(this).closest('div[name="fastCreateOrder"]').children('div').children('div').children('div').children('div[name="expanseContainer"]').each(function(key,container) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
			
			let isSelected=$(this).children('input[name="worksheetIsSelected"]').is(":checked");
			if(isSelected)
			{
				let expanseType=parseInt($(container).children('input[name="recurringExpanseType"]').val());
				let propertyServiceID=$(container).children('input[name="propertyServiceID"]').val();
				if(isNaN(propertyServiceID))
				{
						propertyServiceID=-1;
				}
				
				if(isNaN(expanseType))
				{
					expanseType=0;
				}
				var expanse;
				if(expanseType==3)
		  		{
			     	let currentReading=safeLoadFloatValue( $(container).children('div').children('input[name="currentReading"]').val());
					if(isNaN(currentReading))
					{
							currentReading=-1;
					}
					let lastReading=safeLoadFloatValue( $(container).children('div').children('input[name="lastReading"]').val());
					if(isNaN(lastReading))
					{
						lastReading=-1;
					}
					
					expanse={
						propertyServiceID:propertyServiceID,
						expanseType:expanseType,
						previousReadingValue:lastReading,
						currentReadingValue:currentReading
					}
			    }
			    else
			    {
					if(expanseType==2)
					{
						let currentReading=safeLoadFloatValue( $(container).children('div').children('input[name="currentReading"]').val());
						if(isNaN(currentReading))
						{
								currentReading=-1;
						}
						expanse={
							propertyServiceID:propertyServiceID,
							expanseType:expanseType,
							currentReadingValue:currentReading
						}
					}
					if( expanseType==1)
					{
						let currentReading=safeLoadFloatValue( $(container).children('div').children('input[name="currentReading"]').val());
						if(isNaN(currentReading))
						{
								currentReading=-1;
						}
						expanse={
							propertyServiceID:propertyServiceID,
							expanseType:expanseType,
							currentReadingValue:currentReading
						}
					}
				}
				expanseList.push(expanse);
		
		}	
	});	
	 
	 var worksheet={
		 worksheetID:$(this).children("input[name='worksheetID']").val(),
		 totalCost:$(this).children("input[name='totalCost']").val(),
		 expanseList:expanseList
	 }
	 
	 worksheetList_withCurrentReading.push(worksheet);
  });
  
  var fastCreateOrderList={
		 orderBelongMonth:orderList_BelongMonth,
		 orderCreateDate:orderListCreateDate,
		 orderExpireDate:orderList_ExpireDate,
		 totalMonth:totalMonth,
		 totalDay:totalDay,
		 worksheetList_withCurrentReading:worksheetList_withCurrentReading
	 }
  $.ajax({
            type: "POST",
            contentType: "application/json",
            url:"/quan-ly/tao-nhanh-danh-sach-hoa-don", // Điều chỉnh URL tương ứng với Spring Boot
            data: JSON.stringify(fastCreateOrderList),
            success: function(response) {
                console.log("Đã gửi đối tượng thành công.");
                // Xử lý phản hồi từ máy chủ nếu cần
                window.location.href ="/quan-ly";
            },
            error: function(error) {
                console.log("Lỗi khi gửi đối tượng: " + error);
            }
   	});
}
function searchWorksheet_createFastOrderList()
{
	$("#searchWorksheet_createFastOrderList").sort();
	searchWorksheet_createFastOrderList	
	$("#searchWorksheet_createFastOrderList").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#fastCreateOrderListForm div div div[name='fastCreateOrder']").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
  	});
}

//UI update number format of depositAmount in create_contract
function formatNumberTextarea_depositAmount_CreateContact_FocusOn_BlurOut()
{
	 // On focus: convert UI display from "1.500.500" -> "1500500"
    $('textarea.editable_depositAmount_textarea').on('focus', function() {
        var text = $(this).val().trim(); 
        var raw = text.replace(/\./g, ""); // remove all dot 
        $(this).text(raw);
        $(this).val(raw);
    });

    // On blur: convert display back "1500500,5" -> "1.500.500,5"
    $('textarea.editable_depositAmount_textarea').on('blur', function() {
    	var content =  $(this).closest('div').children('input[name="depositAmount"]').val() ;
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    //parse to textarea display UI
	    $(this).val(formattedNumber);
	    $(this).text(formattedNumber);
    });
}
function updateValueToHiddenInputField_editableTextarea_depositAmount_CreateContact()
{
	$(".editable_depositAmount_textarea").change(function (e) {
           var content=$(this).val();
           
           //update value of hidden input after edit at textarea to submit post form if needed be.
           $(this).closest('div').children('input[name="depositAmount"]').val(content);
     });
}
function numberInputrOnly_depositAmount_CreateContact_editableTextarea()
{
	$(".editable_depositAmount_textarea").keypress(function (e) {
	    var allowedCharacters = []; // Mã ký tự của dấu d0t và các số từ 0 đến 9 
	    //"." (dot) = 46"," (comma) = 44
	    var keyCode = e.which;
	    
	    if (!(allowedCharacters.includes(keyCode) || (keyCode >= 48 && keyCode <= 57))) {
	        e.preventDefault();
	    }
	});
}
function formatNumber_depositAmount_CreateContact_editableTextarea_firstTimeRender()
{
	$('.editable_depositAmount_textarea').each(function() {
        var content = $(this).val();
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);
    });
}
function updateNumberFormat_depositAmount_CreateContact()
{
	formatNumberTextarea_depositAmount_CreateContact_FocusOn_BlurOut();
	updateValueToHiddenInputField_editableTextarea_depositAmount_CreateContact();
	numberInputrOnly_depositAmount_CreateContact_editableTextarea();
	formatNumber_depositAmount_CreateContact_editableTextarea_firstTimeRender();
}
//UI update number format of depositAmount in create_contract ending

//UI update number format of worksheetRentalPrice in create_contract
function formatNumberTextarea_worksheetRentalPrice_CreateContact_FocusOn_BlurOut()
{
	 // On focus: convert UI display from "1.500.500" -> "1500500"
    $('textarea.editable_worksheetRentalPrice_textarea').on('focus', function() {
        var text = $(this).val().trim(); 
        var raw = text.replace(/\./g, ""); // remove all dot 
        $(this).text(raw);
        $(this).val(raw);
    });

    // On blur: convert display back "1500500,5" -> "1.500.500,5"
    $('textarea.editable_worksheetRentalPrice_textarea').on('blur', function() {
    	var content =  $(this).closest('div').children('input[name="worksheetRentalPrice"]').val() ;
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    //parse to textarea display UI
	    $(this).val(formattedNumber);
	    $(this).text(formattedNumber);
    });
}
function updateValueToHiddenInputField_editableTextarea_worksheetRentalPrice_CreateContact()
{
	$(".editable_worksheetRentalPrice_textarea").change(function (e) {
           var content=$(this).val();
           
           //update value of hidden input after edit at textarea to submit post form if needed be.
           $(this).closest('div').children('input[name="worksheetRentalPrice"]').val(content);
     });
}
function numberInputrOnly_worksheetRentalPrice_CreateContact_editableTextarea()
{
	$(".editable_worksheetRentalPrice_textarea").keypress(function (e) {
	    var allowedCharacters = []; // Mã ký tự của dấu d0t và các số từ 0 đến 9 
	    //"." (dot) = 46"," (comma) = 44
	    var keyCode = e.which;
	    
	    if (!(allowedCharacters.includes(keyCode) || (keyCode >= 48 && keyCode <= 57))) {
	        e.preventDefault();
	    }
	});
}
function formatNumber_worksheetRentalPrice_CreateContact_editableTextarea_firstTimeRender()
{
	$('.editable_worksheetRentalPrice_textarea').each(function() {
        var content = $(this).val();
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);
    });
}
function updateNumberFormat_worksheetRentalPrice_CreateContact()
{
	formatNumberTextarea_worksheetRentalPrice_CreateContact_FocusOn_BlurOut();
	updateValueToHiddenInputField_editableTextarea_worksheetRentalPrice_CreateContact();
	numberInputrOnly_worksheetRentalPrice_CreateContact_editableTextarea();
	formatNumber_worksheetRentalPrice_CreateContact_editableTextarea_firstTimeRender();
}
//UI update number format of worksheetRentalPrice in create_contract ending 

//UI update number format of unexpected_expanse cost in create_order
function formatNumberTextarea_unexpectedExpanseCost_CreateOrder_FocusOn_BlurOut()
{
	 // On focus: convert UI display from "1.500.500" -> "1500500"
    $('textarea.editable_unexpectedExpanseCost_textarea').on('focus', function() {
        var text = $(this).val().trim(); 
        var raw = text.replace(/\./g, ""); // remove all dot 
        $(this).text(raw);
        $(this).val(raw);
    });

    // On blur: convert display back "1500500,5" -> "1.500.500,5"
    $('textarea.editable_unexpectedExpanseCost_textarea').on('blur', function() {
    	var content =  $(this).closest('div').children('input[name="expanseCost"]').val() ;
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    //parse to textarea display UI
	    $(this).val(formattedNumber);
	    $(this).text(formattedNumber);
    });
}
function updateValueToHiddenInputField_editableTextarea_unexpectedExpanseCost_CreateOrder()
{
	$(".editable_unexpectedExpanseCost_textarea").change(function (e) {
           var content=$(this).val();
           
           //update value of hidden input after edit at textarea to submit post form if needed be.
           $(this).closest('div').children('input[name="expanseCost"]').val(content);
     });
}
function numberInputrOnly_unexpectedExpanseCost_CreateOrder_editableTextarea()
{
	$(".editable_unexpectedExpanseCost_textarea").keypress(function (e) {
	    var allowedCharacters = []; // Mã ký tự của dấu d0t và các số từ 0 đến 9 
	    //"." (dot) = 46"," (comma) = 44
	    var keyCode = e.which;
	    
	    if (!(allowedCharacters.includes(keyCode) || (keyCode >= 48 && keyCode <= 57))) {
	        e.preventDefault();
	    }
	});
}
function formatNumber_unexpectedExpanseCost_CreateOrder_editableTextarea_firstTimeRender()
{
	$('.editable_unexpectedExpanseCost_textarea').each(function() {
        var content = $(this).val();
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);
    });
}
function updateNumberFormat_unexpectedExpanseCost_CreateOrder()
{
	formatNumberTextarea_unexpectedExpanseCost_CreateOrder_FocusOn_BlurOut();
	updateValueToHiddenInputField_editableTextarea_unexpectedExpanseCost_CreateOrder();
	numberInputrOnly_unexpectedExpanseCost_CreateOrder_editableTextarea();
	formatNumber_unexpectedExpanseCost_CreateOrder_editableTextarea_firstTimeRender();
} 
//UI update number format of unexpected_expanse cost in create_order ending 

//UI update number format of depositAmount cost in create_order_for_deposit
function formatNumberTextarea_depositAmount_CreateOrderForDeposit_FocusOn_BlurOut()
{
	 // On focus: convert UI display from "1.500.500" -> "1500500"
    $('textarea.editable_depositAmount_createOrderForDeposit_textarea').on('focus', function() {
        var text = $(this).val().trim(); 
        var raw = text.replace(/\./g, ""); // remove all dot 
        $(this).text(raw);
        $(this).val(raw);
    });

    // On blur: convert display back "1500500,5" -> "1.500.500,5"
    $('textarea.editable_depositAmount_createOrderForDeposit_textarea').on('blur', function() {
    	var content =  $(this).closest('div').children('input[name="depositAmount"]').val() ;
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    //parse to textarea display UI
	    $(this).val(formattedNumber);
	    $(this).text(formattedNumber);
    });
}
function updateValueToHiddenInputField_editableTextarea_depositAmount_CreateOrderForDeposit()
{
	$(".editable_depositAmount_createOrderForDeposit_textarea").change(function (e) {
           var content=$(this).val();
           
           //update value of hidden input after edit at textarea to submit post form if needed be.
           $(this).closest('div').children('input[name="depositAmount"]').val(content);
     });
}
function numberInputrOnly_depositAmount_CreateOrderForDeposit_editableTextarea()
{
	$(".editable_depositAmount_createOrderForDeposit_textarea").keypress(function (e) {
	    var allowedCharacters = []; // Mã ký tự của dấu d0t và các số từ 0 đến 9 
	    //"." (dot) = 46"," (comma) = 44
	    var keyCode = e.which;
	    
	    if (!(allowedCharacters.includes(keyCode) || (keyCode >= 48 && keyCode <= 57))) {
	        e.preventDefault();
	    }
	});
}
function formatNumber_depositAmount_CreateOrderForDeposit_editableTextarea_firstTimeRender()
{
	$('.editable_depositAmount_createOrderForDeposit_textarea').each(function() {
        var content = $(this).val();
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);
    });
}
function updateNumberFormat_depositAmount_CreateOrderForDeposit()
{
	formatNumberTextarea_depositAmount_CreateOrderForDeposit_FocusOn_BlurOut();
	updateValueToHiddenInputField_editableTextarea_depositAmount_CreateOrderForDeposit();
	numberInputrOnly_depositAmount_CreateOrderForDeposit_editableTextarea();
	formatNumber_depositAmount_CreateOrderForDeposit_editableTextarea_firstTimeRender();
} 
//UI update number format of depositAmount cost in create_order_for_deposit ending 

//UI update number format of propertyRentalPrice in create_property 
function formatNumberTextarea_propertyRentalPrice_CreateProperty_FocusOn_BlurOut()
{
	 // On focus: convert UI display from "1.500.500" -> "1500500"
    $('textarea.editable_propertyRentalPrice_CreateProperty_textarea').on('focus', function() {
        var text = $(this).val().trim(); 
        var raw = text.replace(/\./g, ""); // remove all dot 
        $(this).text(raw);
        $(this).val(raw);
    });

    // On blur: convert display back "1500500,5" -> "1.500.500,5"
    $('textarea.editable_propertyRentalPrice_CreateProperty_textarea').on('blur', function() {
    	var content =  $(this).closest('div').children('input[name="propertyRentalPrice"]').val() ;
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    //parse to textarea display UI
	    $(this).val(formattedNumber);
	    $(this).text(formattedNumber);
    });
}
function updateValueToHiddenInputField_editableTextarea_propertyRentalPrice_CreateProperty()
{
	$(".editable_propertyRentalPrice_CreateProperty_textarea").change(function (e) {
           var content=$(this).val();
           
           //update value of hidden input after edit at textarea to submit post form if needed be.
           $(this).closest('div').children('input[name="propertyRentalPrice"]').val(content);
     });
}
function numberInputrOnly_propertyRentalPrice_CreateProperty_editableTextarea()
{
	$(".editable_propertyRentalPrice_CreateProperty_textarea").keypress(function (e) {
	    var allowedCharacters = []; // Mã ký tự của dấu d0t và các số từ 0 đến 9 
	    //"." (dot) = 46"," (comma) = 44
	    var keyCode = e.which;
	    
	    if (!(allowedCharacters.includes(keyCode) || (keyCode >= 48 && keyCode <= 57))) {
	        e.preventDefault();
	    }
	});
}
function formatNumber_propertyRentalPrice_CreateProperty_editableTextarea_firstTimeRender()
{
	$('.editable_propertyRentalPrice_CreateProperty_textarea').each(function() {
        var content = $(this).val();
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);
    });
}
function updateNumberFormat_propertyRentalPrice_CreateProperty()
{
	formatNumberTextarea_propertyRentalPrice_CreateProperty_FocusOn_BlurOut();
	formatNumber_propertyRentalPrice_CreateProperty_editableTextarea_firstTimeRender();
	numberInputrOnly_propertyRentalPrice_CreateProperty_editableTextarea();
	updateValueToHiddenInputField_editableTextarea_propertyRentalPrice_CreateProperty();
} 
//UI update number format of propertyRentalPrice in create_property ending

$(document).ready(function(){

	//create-worksheet
	callFunctionFor_CreateWorksheet_Sequences();
	//edit expanse list 
	callFunctionFor_FastEditExpanseList_Sequences();
	//create order function	
	callFunctionFor_CreateOrder_Sequences();
	
	//filter function
	filter_propertyList_manageProperty();
	//edit property by jequery via API.
	
	
	//edit property list function
    $("#saveChange").click(function() {
		//https://stackoverflow.com/questions/14234646/adding-elements-to-object
		
		//post changed-property to api
		pointers.forEach(postChangedPropertyToAPI);
		//post changed-property to api
		
    });
    
    //calculate totalcost each order
    calculateTotalCost_CreateFastOrderList_ManageProperty();
    updateTotalCostWhileEditTotalMonthAndTotalDay_FastCreateOrderList_ManageProperty();
    searchWorksheet_createFastOrderList();
    renderStateCalculateTotalCost_FastCreateOrderList_ManageProperty();//first calculate at render_stage
    //fast craete order-list function
    $("#fastCreateOrderListButton").click(function() {
		createFastOrderList();
    });
    
    //update numberformat 
    updateNumberFormat_depositAmount_CreateContact();
    updateNumberFormat_worksheetRentalPrice_CreateContact();
    updateNumberFormat_unexpectedExpanseCost_CreateOrder();
    updateNumberFormat_depositAmount_CreateOrderForDeposit();
    updateNumberFormat_EditProperty();
    updateNumberFormat_propertyRentalPrice_CreateProperty();
    //ending update numberformat
    
});


