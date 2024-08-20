$(document).ready(function(){
	// create one more column to expanse] list
    $("#add_expanse_column").click(function() {
		$("tbody#repeatedExpanseList").append("<tr> \
									<td><input type='text'></td>\
									<td><input type='number'></td>\
									<td>\ <input name='repeatedExpanseID' type='hidden' value='-1'/><button id='delete' class='btn btn-danger'>Delete</button> \ </td>\
						  </tr>");
    });
	
    $("#add_tenant_column").click(function() {
		$("tbody#tenantList").append("<tr> \
									<td><input type='text'></td>\
									<td>\ <button id='delete' class='btn btn-danger'>Delete</button> \ </td>\
						  </tr>");
    });
    
	//goi danh sach product de hien thi.
    assignDataToTable();
    
	
	//xoa newTenant,newRepeatedExpanse  bang jquery 
    $('table').on('click', 'button[id="delete"]', function(e){
       $(this).closest('tr').remove();
    });

	//edit property by jequery via API.
    $("#save").click(function() {
		var statusID = $( "#status" ).val();
		//them newTenant
		var tenantList=[];
		$('#tenantListTable>tbody#tenantList tr').each(function(key,tr) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
			var tenant={
					tenantName:$(tr).children('td:eq(0)').children('input').val()
			}
			tenantList.push(tenant);
		});
		//https://stackoverflow.com/questions/14234646/adding-elements-to-object
		
		
		//them newRepeatedExpanse
		var repeatedExpanseList=[];
		$('#repeatedExpanseListTable>tbody#repeatedExpanseList tr').each(function(key,tr) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
		    var repeatedExpanse={
					repeatedExpanseName:$(tr).children('td:eq(0)').children('input').val(),
					repeatedExpanseCurrentCost:$(tr).children('td:eq(1)').children('input').val(),
					repeatedExpanseID:$(tr).children('td:eq(2)').children('input').val()
			}
			repeatedExpanseList.push(repeatedExpanse);
			
		});
		var newWorksheet={
			paidDeposit: $("#paidDeposit").val(),
			timeInterval: $("#timeInterval").val(),
			repeatedExpanses: repeatedExpanseList,
			tenants:tenantList,
			worksheetID:$("#worksheetID").val()
		}
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/worksheet/edit",
            data: JSON.stringify(newWorksheet), 
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
function loadTimeInterval(timeInterval)
{
	if(timeInterval==3600)
	{
		$("#timeInterval").
                append("<option value='3600' selected>1 giờ</option>" );
        $("#timeInterval").
                append("<option value='86400'>1 ngày</option>" );
    	$("#timeInterval").
                append("<option value='2592000'>1 tháng</option>" );
	}
	else
	{
		if(timeInterval==86400)
		{
			$("#timeInterval").
                append("<option value='3600'>1 giờ</option>" );
			$("#timeInterval").
                append("<option value='86400' selected>1 ngày</option>" );
   			 $("#timeInterval").
                append("<option value='2592000'>1 tháng</option>" );
		}
		else
		{
			$("#timeInterval").
                append("<option value='3600'>1 giờ</option>" );
			$("#timeInterval").
                append("<option value='86400' >1 ngày</option>" );
   			 $("#timeInterval").
                append("<option value='2592000' selected>1 tháng</option>" );
		}
	}
	
}
function loadWorksheet(worksheet)
{
	//load paidDeposit
	$("#paidDeposit").val(worksheet.paidDeposit);
	$("#propertyName").val(worksheet.propertyName);
	
	//load timeInterval
	loadTimeInterval(worksheet.timeInterval)
}
function loadTenantList(tenantList)
{
	for (var i in tenantList) {
		$("tbody#oldTenantList").append("<tr> \
									<td>"+ tenantList[i].tenantName+"</td>\
									<td>\ <button id='edit' class='btn btn-danger'>Edit</button><form method='POST' action='http://www.localhost:8080/contact/delete'><input type='hidden' id='contactID' name='contactID' value='"+tenantList[i].contactID+"'><input type='submit' value='Delete'></form>\ </td>\
						  </tr>");
    }
}
function loadRecurringExpanseList(repeatedExpanseList,propertyID)
{
	for (var i in repeatedExpanseList) {
		$("tbody#oldRepeatedExpanseList").append("<tr> \
									<td>"+ repeatedExpanseList[i].repeatedExpanseName+"</td>\
									<td>"+ repeatedExpanseList[i].repeatedExpanseCurrentCost+"</td>\
									<td><button id='edit' class='btn btn-danger'>Edit</button><form method='POST' action='http://www.localhost:8080/recurringexpanse/delete'><input type='hidden' id='recurringExpanseID' name='recurringExpanseID' value='"+repeatedExpanseList[i].recurringExpanseID+"'><input type='submit' value='Delete'></form> \ </td>\
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
                loadTenantList(worksheet.tenants);
                loadRecurringExpanseList(worksheet.repeatedExpanses,worksheetID);
            },
            error: function(xhr, ajaxOptions, thrownError) {
                alert("loi roi bay oi"+xhr.status);
            }
        });
        
        
		
};
//autocomplete search for repeated_expanse_list
function autocomplete_search_repeated_expanse(repeatedExpanseList){
	// jQuery inbuild function
    $("#search_concurring_expanse").autocomplete({
        source: repeatedExpanseList,// list of items.
        minLength: 1,
        select: function( event, ui ) { 
            $("tbody#repeatedExpanseList").append("<tr> \
									<td><input type='text' value='"+ui.item.value+"' readonly></td>\
									<td><input type='number' value='"+ui.item.repeatedExpanseCurrentCost+"' readonly></td>\
									<td>\ <input name='repeatedExpanseID' type='hidden' value='"+ui.item.repeatedExpanseID+"'/><button id='delete' class='btn btn-danger'>Delete</button> \ </td>\
						  </tr>");
        },
	    html: true,
	    open: function(event, ui) {
	       $(".ui-autocomplete").css("z-index", 1000);
	    }
    })
    .autocomplete( "instance" )._renderItem = function( ul, repeatedExpanse ) {
        return $( "<li><div><span>"+repeatedExpanse.value+"</span></div></li>" ).appendTo( ul );
    };

};

$(document).ready(function() {
	$.ajax({    
          type:"GET",
          contentType: "application/json",
          url:"http://localhost:8080/repeatedexpanse/list",
          success: function(data) {
			var repeatedExpanseList = JSON.parse(JSON.stringify(data));
            autocomplete_search_repeated_expanse(repeatedExpanseList);
          },
          error: function(data) {	 
            console.log(data);
            }
        });

 });
function alertUsing(text, flag) {

    var alert = $(".alert");

    if(flag){
        alert.removeClass("alert-danger").addClass("alert-success");
    }else{
        alert.removeClass("alert-success").addClass("alert-danger");
        
    }
    
    alert.fadeIn(400);
    alert.css("display", "block");
    alert.text(text);
    setTimeout(function() {
        alert.fadeOut();
    }, 2000);

  }

});
