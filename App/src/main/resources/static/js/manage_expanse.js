$(function () {
  var token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");
  $(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
  });
});
function selectAllCheckbox()
{
	$("input.selectAllPropertyService").change(function(x){
      var isChecked=$(this).prop('checked');
	   
	  $(this).closest('form').children('div').children('input[name="selectedPropertyServiceIDList"]').prop("checked",isChecked);
  	});
}
$(document).ready(function(){

	//select all at edit-expanse function
	selectAllCheckbox();
    
});