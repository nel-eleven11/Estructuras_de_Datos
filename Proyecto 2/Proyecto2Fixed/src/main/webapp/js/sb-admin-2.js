(function($) {
  "use strict"; // Start of use strict
    
    
    $("#user-send-button").click(function(){
		    $.ajax( {
			type: "GET",
			url: '/Seccion10Grupo15/AddUserServlet?userId=' + $('#userInputName').val() + $('#userInputLastname').val() + $('#userInputAge').val() + '&name=' + $('#userInputName').val() + '&lastName=' + $('#userInputLastname').val() + '&city=' + $('#userInputLocation').val() + '&age=' + $('#userInputAge').val() + '&sex=' + $('#userInputSex').val() + '&relationshipType=' + $('#userInputRelationshipType').val() + '&interests=' + $('#userInputInterests').val(),
			success: function(data) {
                console.log("Resultado: " + data);			    
			}
		} );
	});

})(jQuery); // End of use strict
