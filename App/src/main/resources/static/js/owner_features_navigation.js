//UI update number format of propertyRentalPrice in create_land ending
function safeLoadFloatValue(containerValue)
{
	return parseFloat(containerValue.replace(/,/g, ''));
}
function formatNumberTextarea_propertyRentalPrice_CreateNewLand_FocusOn_BlurOut()
{
	 // On focus: convert UI display from "1.500.500" -> "1500500"
    $('textarea.editable_propertyRentalPrice_CreateNewLand_textarea').on('focus', function() {
        var text = $(this).val().trim(); 
        var raw = text.replace(/\./g, ""); // remove all dot 
        $(this).text(raw);
        $(this).val(raw);
    });

    // On blur: convert display back "1500500,5" -> "1.500.500,5"
    $('textarea.editable_propertyRentalPrice_CreateNewLand_textarea').on('blur', function() {
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
function updateValueToHiddenInputField_editableTextarea_propertyRentalPrice_CreateNewLand()
{
	$(".editable_propertyRentalPrice_CreateNewLand_textarea").change(function (e) {
           var content=$(this).val();
           
           //update value of hidden input after edit at textarea to submit post form if needed be.
           $(this).closest('div').children('input[name="propertyRentalPrice"]').val(content);
     });
}
function numberInputrOnly_propertyRentalPrice_CreateNewLand_editableTextarea()
{
	$(".editable_propertyRentalPrice_CreateNewLand_textarea").keypress(function (e) {
	    var allowedCharacters = []; // Mã ký tự của dấu d0t và các số từ 0 đến 9 
	    //"." (dot) = 46"," (comma) = 44
	    var keyCode = e.which;
	    
	    if (!(allowedCharacters.includes(keyCode) || (keyCode >= 48 && keyCode <= 57))) {
	        e.preventDefault();
	    }
	});
}
function formatNumber_propertyRentalPrice_CreateNewLand_editableTextarea_firstTimeRender()
{
	$('.editable_propertyRentalPrice_CreateNewLand_textarea').each(function() {
        var content = $(this).val();
        // Convert the content to a number
	    var number = safeLoadFloatValue(content);
	    // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	    // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);
    });
}
function updateNumberFormat_propertyRentalPrice_CreateNewLand()
{
	formatNumberTextarea_propertyRentalPrice_CreateNewLand_FocusOn_BlurOut();
	formatNumber_propertyRentalPrice_CreateNewLand_editableTextarea_firstTimeRender();
	numberInputrOnly_propertyRentalPrice_CreateNewLand_editableTextarea();
	updateValueToHiddenInputField_editableTextarea_propertyRentalPrice_CreateNewLand();
} 
//UI update number format of propertyRentalPrice in create_land ending
$(document).ready(function(){

    
    //update numberformat 
    updateNumberFormat_propertyRentalPrice_CreateNewLand();
    //ending update numberformat
    
});