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
	
	$("#matches-retrieve-button").click(function(){
        $.ajax({
            type: "GET",
            url: '/Seccion10Grupo15/SearchSoulmate?userId=' + $('#userInputId').val(),
            success: function(data) {
                console.log("Matches: " + JSON.stringify(data));
                
                // Loop through each match and display it
                $.each(data, function(index, match){
                    console.log('Matched User: ' + match.matchedUser.userId);
                    console.log('Common Interests: ' + match.sharedInterests.toString());
                    console.log('Count of Common Interests: ' + match.commonInterestCount);
                });			    
            }
        });
    });

})(jQuery); // End of use strict
