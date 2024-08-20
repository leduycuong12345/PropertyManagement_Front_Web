$(document).ready(function(){
	// create one more column to expanse] list
    $("#add_expanse_column").click(function() {
		$("tbody#expanseList").append("<tr> \
									<td><input type='text'></td>\
									<td><input type='number' class='expanseCost'></td>\
									<td>\ <input name='expanseID' type='hidden' value='-1'/><button id='delete' class='btn btn-danger'>Delete</button> \ </td>\
						  </tr>");
    });
	
	$( "#startRentalDate" ).datepicker({
		dateFormat:"dd-mm-yy",
	});
	$( "#endRentalDate" ).datepicker({
		dateFormat:"dd-mm-yy",
	});
	//datepicker
	
	//timepicker
	$( "#startRentalTime" ).timepicker({
	    timeFormat: 'HH:mm',
	    interval: 60,
	    dynamic: false,
	    dropdown: true,
	    scrollbar: true
	});
	$( "#endRentalTime" ).timepicker({
	    timeFormat: 'HH:mm',
	    interval: 60,
	    dynamic: false,
	    dropdown: true,
	    scrollbar: true
	});
	//timepicker
	
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
					expanseName:$(tr).children('td:eq(0)').children('input').val(),
					expanseCost:$(tr).children('td:eq(1)').children('input').val(),
					expanseID:$(tr).children('td:eq(2)').children('input').val()
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
		var newOrder={
			startRentalDateTime:$("#startRentalDate").val()+ " "+ $("#startRentalTime").val(),
			endRentalDateTime:$("#endRentalDate").val()+ " "+ $("#endRentalTime").val(),
			totalCost:$("#totalCost").val(),
			repeatedExpanseList: repeatedExpanseList,
			expanseList:expanseList,
			worksheetID:$("#worksheetID").val()
		}
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/order/add",
            data: JSON.stringify(newOrder), 
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
function loadWorksheet(worksheet)
{
	//load paidDeposit
	$("#propertyName").val(worksheet.propertyName);
	$("#worksheetRentalPrice").val(worksheet.currentPropertyRentalPrice);
}
function loadRecurringExpanseList(repeatedExpanseList,propertyID)
{
	for (var i in repeatedExpanseList) {
		$("tbody#repeatedExpanseList").append("<tr> \
									<td><input type='hidden' value='"+ repeatedExpanseList[i].recurringExpanseID+"'>"+ repeatedExpanseList[i].repeatedExpanseName+"</td>\
									<td><input type='number' value='"+ repeatedExpanseList[i].repeatedExpanseCurrentCost+"' readonly></td>\
									<td><input type='number' class='repeatedExpanseQuantity' ></td>\
									<td><input type='number'  ></td>\
						  </tr>");
    }
}
//load editting property
function assignDataToTable() {
		var worksheetID = $( "#worksheetID" ).val();
		$.ajax({
			//https://stackoverflow.com/questions/6186770/ajax-request-returns-200-ok-but-an-error-event-is-fired-instead-of-success
            type:"GET",
            contentType: 'application/json; charset=utf-8',
    		dataType: 'text json',
            url:"http://localhost:8080/worksheet/details?worksheetID="+worksheetID,
            success: function(p){
                var worksheet = JSON.parse(JSON.stringify(p));
                //console.log(property);
                //alert("hey we load it");
  			    loadWorksheet(worksheet);
                loadRecurringExpanseList(worksheet.repeatedExpanses,worksheetID);
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