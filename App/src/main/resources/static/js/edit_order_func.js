$(document).ready(function(){
	// create one more column to expanse] list
    $("#add_expanse_column").click(function() {
		$("tbody#expanseList").append("<tr> \
									<td><input name='expanseID' type='hidden' value='-1'/><input type='text'></td>\
									<td><input type='number' class='expanseCost'></td>\
						  </tr>");
    });
	
	
	
	//goi danh sach product de hien thi.
    assignDataToTable();
    //datepicker
	
	
	//xoa newTenant,newRepeatedExpanse  bang jquery
    $('table').on('click', 'button[id="delete"]', function(e){
       $(this).closest('tr').remove();
    });

	//update repeatedExpanseTotalCost after enter Quantity
	//https://stackoverflow.com/questions/15420558/jquery-click-event-not-working-after-append-method
	$( "#repeatedExpanseList").on('change','.repeatedExpanseQuantity',function(){
		var repeatedExpanseQuantity=$(this).closest('tr').children('td:eq(2)').children('input').val();
		 var repeatedExpanseCost=$(this).closest('tr').children('td:eq(1)').children('input').val();
		 var repeatedExpanseTotalCost=repeatedExpanseQuantity*repeatedExpanseCost;
	 //set value to repeatedExpanseTotalCost
		 $(this).closest('tr').children('td:eq(3)').children('input').val(repeatedExpanseTotalCost);
		 
		calculateOrderTotalCost();
	});
    $( "#expanseList").on('change','.expanseCost',function(){
		var checkNullNewExpanseName=$(this).closest('tr').children('td:eq(0)').children('input').val();
		if(checkNullNewExpanseName!="")
		{
			calculateOrderTotalCost();
		}
	});
	
	//edit property by jequery via API.
    $("#save").click(function() {
		//https://stackoverflow.com/questions/14234646/adding-elements-to-object
		
		
		//them newRepeatedExpanse
		var expanseList=[];
		$('#expanseListTable>tbody#expanseList tr').each(function(key,tr) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
		    var expanse={
					expanseCost:$(tr).children('td:eq(1)').children('input').val(),
					expanseID:$(tr).children('td:eq(0)').children('input').val()
			}
			expanseList.push(expanse);
			
		});
		
		var repeatedExpanseList=[];
		$('#repeatedExpanseListTable>tbody#repeatedExpanseList tr').each(function(key,tr) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
		    var repeatedExpanse={
					repeatedExpanseCurrentCost:$(tr).children('td:eq(1)').children('input').val(),
					repeatedExpanseQuantity:$(tr).children('td:eq(2)').children('input').val(),
					repeatedExpanseTotalValue:$(tr).children('td:eq(3)').children('input').val(),
					recurringExpanseID:$(tr).children('td:eq(0)').children('input').val()
			}
			repeatedExpanseList.push(repeatedExpanse);
			
		});
		var order={
			totalCost:$("#totalCost").val(),
			repeatedExpanseList: repeatedExpanseList,
			expanseList:expanseList,
			worksheetID:$("#worksheetID").val(),
			orderID:$("#orderID").val()
		}
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/order/editted",
            data: JSON.stringify(order), 
            contentType: "application/json",
            success: function(){
                //annouce somethign
            },
            error: function(err) {
                console.log(err);
                alert(err);
            }
        });

    });
});
function loadWorksheet(worksheetID)
{
		$.ajax({
			//https://stackoverflow.com/questions/6186770/ajax-request-returns-200-ok-but-an-error-event-is-fired-instead-of-success
            type:"GET",
            contentType: 'application/json; charset=utf-8',
    		dataType: 'text json',
            url:"http://localhost:8080/worksheet/details?worksheetID="+worksheetID,
            success: function(p){
                var worksheet = JSON.parse(JSON.stringify(p));
                
                $("#propertyName").val(worksheet.propertyName);
				$("#worksheetRentalPrice").val(worksheet.currentPropertyRentalPrice);
            },
            error: function(xhr, ajaxOptions, thrownError) {
                alert("loi roi bay oi load worksheet ko dc "+xhr.status);
            }
        });
	//load paidDeposit
	
}
function loadDetailsRecurringExpanseList(repeatedExpanseList)
{
	for (var i in repeatedExpanseList) {
		$("tbody#repeatedExpanseList").append("<tr> \
									<td><input type='hidden' value='"+ repeatedExpanseList[i].recurringExpanseID+"'>"+ repeatedExpanseList[i].repeatedExpanseName+"</td>\
									<td><input type='number' value='"+ repeatedExpanseList[i].repeatedExpanseCurrentCost+"' readonly></td>\
									<td><input type='number' class='repeatedExpanseQuantity' value='"+ repeatedExpanseList[i].repeatedExpanseQuantity+"' ></td>\
									<td><input type='number'  value='"+ repeatedExpanseList[i].repeatedExpanseTotalValue+"' ></td>\
						  </tr>");
    }
}
function loadExpanseList(expanseList)
{
	for (var i in expanseList) {
		$("tbody#expanseList").append("<tr> \
									<td><input type='text' value='"+expanseList[i].expanseID+"'>"+  expanseList[i].expanseName+"</td>\
									<td><input type='number' class='expanseCost' value='"+ expanseList[i].expanseCost+"'></td>\
									<td>\<form method='POST' action='http://www.localhost:8080/expanse/delete'><input type='hidden' id='contactID' name='contactID' value='"+ expanseList[i].expanseID+"'><input type='submit' value='Delete'></form>\ </td>\
						  </tr>");
    }
}
function loadOrder(order)
{
	$("#startRentalDateTime").val(order.startRentalDateTime);
	$("#endRentalDateTime").val(order.endRentalDateTime);
	$("#totalCost").val(order.totalCost);
}
//load editting property
function assignDataToTable() {
		var orderID=$("#orderID").val();
		$.ajax({
			//https://stackoverflow.com/questions/6186770/ajax-request-returns-200-ok-but-an-error-event-is-fired-instead-of-success
            type:"POST",
            contentType: 'application/json; charset=utf-8',
    		dataType: 'text json',
            url:"http://localhost:8080/order/details?orderID="+orderID,
            success: function(p){
                var order = JSON.parse(JSON.stringify(p));
                //console.log(property); 
                //alert("hey we load it");
  			    loadWorksheet(order.worksheetID);
  			    loadExpanseList(order.expanseList);
  			    loadDetailsRecurringExpanseList(order.repeatedExpanseList);
  			    loadOrder(order);
  			    $("#worksheetID").val(order.worksheetID);
            },
            error: function(xhr, ajaxOptions, thrownError) {
                alert("loi roi bay oi"+xhr.status);
            }
        });
        
        
		
};
function calculateOrderTotalCost()
{
	 var orderTotalCost=parseFloat($("#worksheetRentalPrice").val());
		
		$('#expanseListTable>tbody#expanseList tr').each(function(key,tr) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
			    
			orderTotalCost+=parseFloat($(tr).children('td:eq(1)').children('input').val());
		});
	
		$('#repeatedExpanseListTable>tbody#repeatedExpanseList tr').each(function(key,tr) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
			    
			orderTotalCost+=parseFloat($(tr).children('td:eq(3)').children('input').val());
		});
		
		$("#totalCost").val(orderTotalCost);
}