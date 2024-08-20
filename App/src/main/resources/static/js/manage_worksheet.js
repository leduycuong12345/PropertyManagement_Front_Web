function formatCurrentPropertyRentalPriceWithComma()
{
	// Iterate through each <li> with name "remainingAmount"
    $('p[name="currentPropertyRentalPrice"]').each(function() {
	    var content = $(this).text();
	      
	      // Convert the content to a number
	    var number = parseInt(content);
	
	      // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	
	      // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);  
     
    });
    
}
function formatDepositAmountWithComma()
{
	// Iterate through each <li> with name "remainingAmount"
    $('p[name="depositAmount"]').each(function() {
	    var content = $(this).text();
	      
	      // Convert the content to a number
	    var number = parseInt(content);
	
	      // Format the number with commas every 3 digits
	    var formattedNumber = number.toLocaleString();
	
	      // Replace the content of the <p> element with the formatted number
	    $(this).text(formattedNumber);  
     
    });
    
}
$(document).ready(function(){

    //formatting number zone
    formatCurrentPropertyRentalPriceWithComma();
    formatDepositAmountWithComma();
    //end formatting number zone
});