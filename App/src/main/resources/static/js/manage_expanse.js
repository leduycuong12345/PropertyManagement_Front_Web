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
function safeLoadFloatValue(containerValue)
{
	return parseFloat(containerValue.replace(/,/g, ''));
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
function formatAppliedPropertyTotalWithComma()
{
	// Iterate through each <li> with name "appliedPropertyTotal"
    $('p[name="appliedPropertyTotal"]').each(function() {
	      var content = $(this).text();
	      
	      // Convert the content to a number
	      var number = safeLoadFloatValue(content);
	
	      // Format the number with commas every 3 digits
	      var formattedNumber = number.toLocaleString();
	
	      // Replace the content of the <p> element with the formatted number
	      $(this).text(formattedNumber);
     
    });
    
}
$(document).ready(function(){

	//select all at edit-expanse function
	selectAllCheckbox();
    
    formatExpanseCostWithComma();
    formatAppliedPropertyTotalWithComma();
});