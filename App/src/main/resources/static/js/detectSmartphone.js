function detectSmartPhoneDeviceAndDirectToSmartphonePage()
{
	$(function () {
    const isMobile = /iPhone|iPad|iPod|Android/i.test(navigator.userAgent);
    if (isMobile) {
        $.ajax({
            type: "GET",
            url: "/downloadSmartphoneApp",
            success: function () {
                console.log("Detected smartphone. Redirecting...");
                window.location.href = "/smartphone";
            },
            error: function (error) {
                console.error("AJAX error:", error);
            }
        });
    }
	});

    
}
$(function() {
    detectSmartPhoneDeviceAndDirectToSmartphonePage();
});