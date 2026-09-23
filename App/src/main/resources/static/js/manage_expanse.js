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

function formatNumberTextarea_recurringExpansePrice_editExpanse_FocusOn_BlurOut()
{
	 // On focus: convert UI display from "1.500.500" -> "1500500"
    $('textarea.editable_recurringExpansePrice_textarea').on('focus', function() {
        var text = $(this).val().trim(); 
        var raw = text.replace(/\./g, ""); // remove all dot 
        $(this).text(raw);
        $(this).val(raw);
    });

    // On blur: convert display back "1500500,5" -> "1.500.500,5"
    $('textarea.editable_recurringExpansePrice_textarea').on('blur', function() {
    	var content =  $(this).closest('div').children('input[name="recurringExpansePrice"]').val() ;
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    //parse to textarea display UI
	    $(this).val(formattedNumber);
	    $(this).text(formattedNumber);
    });
}
function updateValueToHiddenInputField_editableTextarea_recurringExpansePrice_editExpanse()
{
	$(".editable_recurringExpansePrice_textarea").change(function (e) {
           var content=$(this).val();
           
           //update value of hidden input after edit at textarea to submit post form if needed be.
           $(this).closest('div').children('input[name="recurringExpansePrice"]').val(content);
     });
}
function numberInputrOnly_recurringExpansePrice_editExpanse_editableTextarea()
{
	$(".editable_recurringExpansePrice_textarea").keypress(function (e) {
	    var allowedCharacters = []; // Mã ký tự của dấu d0t và các số từ 0 đến 9 
	    //"." (dot) = 46"," (comma) = 44
	    var keyCode = e.which;
	    
	    if (!(allowedCharacters.includes(keyCode) || (keyCode >= 48 && keyCode <= 57))) {
	        e.preventDefault();
	    }
	});
}
function formatNumber_recurringExpansePrice_editExpanse_editableTextarea_firstTimeRender()
{
	$('.editable_recurringExpansePrice_textarea').each(function() {
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

	//select all at edit-expanse function
	selectAllCheckbox();
    
    formatExpanseCostWithComma();
    formatAppliedPropertyTotalWithComma();
    
    //formatting textarea edit_expanse
    updateValueToHiddenInputField_editableTextarea_recurringExpansePrice_editExpanse();
    formatNumberTextarea_recurringExpansePrice_editExpanse_FocusOn_BlurOut();
    numberInputrOnly_recurringExpansePrice_editExpanse_editableTextarea();
    formatNumber_recurringExpansePrice_editExpanse_editableTextarea_firstTimeRender();
    //formatting textarea edit_expanse ending
});