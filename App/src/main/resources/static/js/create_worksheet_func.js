$(document).ready(function(){
	// create one more column to expanse] list
    $("#add_expanse_column").click(function() {
		$("tbody#repeatedExpanseList").append("<tr> \
									<td><input type='text'></td>\
									<td><input type='number'></td>\
									<td>\ <input name='repeatedExpanseID' type='hidden' value='-1'/> <button id='delete' class='btn btn-danger'>Delete</button> \ </td>\
						  </tr>");
    });
	
    $("#add_tenant_column").click(function() {
		$("tbody#tenantList").append("<tr> \
									<td><input type='text'></td>\
									<td><input type='number'></td>\
									<td><input type='number'></td>\
									<td>\ <button id='delete' class='btn btn-danger'>Delete</button> \ </td>\
						  </tr>");
    });
    
	//goi danh sach product de hien thi.
    assignDataToTable();
	
	
	//xoa image ra khoi image list bang jquery 
    $('table').on('click', 'button[id="delete"]', function(e){
       $(this).closest('tr').remove();
    });


	//add new product by jequery via API.
    $("#save").click(function() {
		var propertyID = $( "#propertyID" ).val();
		var tenantList=[];
		
		
		//add head of household to tenant list
		var tenant={
					tenantName:$("headOfHouseholdName").val(),
					tenantCI:$("headOfHouseholdCI").val(),
					tenantPhoneNumber:$("headOfHouseholdPhoneNumber").val()
		}	
		tenantList.push(tenant);
		//add head of household to tenant list
		
		$('#tenantListTable>tbody tr').each(function(key,tr) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
			var tenant={
					tenantName:$(tr).children('td:eq(0)').children('input').val(),
					tenantCI:$(tr).children('td:eq(1)').children('input').val(),
					tenantPhoneNumber:$(tr).children('td:eq(2)').children('input').val()
			}
			tenantList.push(tenant);
		});
		//https://stackoverflow.com/questions/14234646/adding-elements-to-object
		
		
		var repeatedExpanseList=[];
		$('#repeatedExpanseListTable>tbody tr').each(function(key,tr) { // we ve to tag as "tbody tr" becauce thead_included_tr too. If u call only ll be redundant one ( tr sum from thead and tbody)
		    var repeatedExpanse={
					repeatedExpanseName:$(tr).children('td:eq(0)').children('input').val(),
					repeatedExpanseCurrentCost:$(tr).children('td:eq(1)').children('input').val(),
					repeatedExpanseID:$(tr).children('td:eq(2)').children('input').val()
			}
			repeatedExpanseList.push(repeatedExpanse);
			
		});
		var newWorksheet={
			paidDeposit: $("#paidDeposit").val(),
			timeInterval: $("#timeInterval  option:selected").val(),
			repeatedExpanses: repeatedExpanseList,
			tenants:tenantList,
			propertyID:propertyID
		}
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/worksheet/add",
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
//load danh sach status
function assignDataToTable() {
		//add option for timeInvertal
		$("#timeInterval").
                append("<option value='3600'>1 giờ</option>" );
		$("#timeInterval").
                append("<option value='86400'>1 ngày</option>" );
       	$("#timeInterval").
                append("<option value='2592000'>1 tháng</option>" );
                
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
