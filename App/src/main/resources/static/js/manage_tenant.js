function parseToNewTabAndPrintOrder(tenantListHTML) {
  	document.open();
  	document.write("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.css' rel='stylesheet'>" +
	      "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.js'></script></head><body onload='window.print();'>" + tenantListHTML + "</body></html>");
	document.close();
}
function printTenantList(){
	$("#printTenantListButton").click(function(){
    
	var landAddress=$("#landAddress").val();
	var landName=$("#landName").val();
    const tenantList=[];
	$("#worksheetList").children('tr[name="roomDetails_printTenantList"]').each(function(index, element) {
	       var propertyName= $(element).children('input[name="propertyName_printTenantList"]').val();
	       var tenantName = $(element).children('input[name="tenantName_printTenantList"]').val();
	       var tenantPhoneNumber= $(element).children('input[name="tenantPhoneNumber_printTenantList"]').val();
	       var tenantCI=$(element).children('input[name="tenantCI_printTenantList"]').val();
	       var tenant={
				   propertyName:propertyName,
				   tenantName:tenantName,
				   tenantPhoneNumber:tenantPhoneNumber,
				   tenantCI:tenantCI
			   }
			   tenantList.push(tenant);
	  });
	  
	  // Lấy thời điểm hiện tại
		var now = new Date();
		
		// Lấy ngày, tháng và năm
		var day = now.getDate();
		var month = now.getMonth() + 1; // Tháng bắt đầu từ 0, cần cộng thêm 1
		var year = now.getFullYear();
		
	  //make order HTML 
	  // Điền thông tin vào biểu mẫu
	   var tenantListHtml= `
	        <h3 style='text-align: center;'>Danh sách người đã đăng ký tạm trú và ở tại ${landName} đến ngày ${day}/${month}/${year}</h3>
	        <table class="table table-bordered">
	            <thead>
	                <tr>
	                    <th>Tên người ở</th>
	                    <th>CCCD</th>
	                    <th>Số điện thoại</th>
	                    <th>Ở phòng</th>
	                </tr>
	            </thead>
	            <tbody>
	    `;
	    tenantList.forEach(function(tenant) {
	        tenantListHtml += `
	            <tr>
	                <td>${tenant.tenantName}</td>
	                <td>${tenant.tenantCI}</td>
	                <td>${tenant.tenantPhoneNumber}</td>
	                <td>Phòng ${tenant.propertyName}</td>
	            </tr>
	        `;
	    });
		tenantListHtml+=`</table>`;
	    $("#printingTenantList").html(tenantListHtml);
	    parseToNewTabAndPrintOrder(tenantListHtml);
    });
}
$(document).ready(function(){
	printTenantList();
});