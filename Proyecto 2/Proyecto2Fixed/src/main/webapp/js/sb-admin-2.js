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
	
	$("#userIdsendbutton").click(function(){
        $.ajax({
            type: "GET",
            url: '/Seccion10Grupo15/SearchSoulmateV2?userId=' + $('#userInputUserId').val(),
            success: function(data) {
                console.log("Success");
                console.log("Matches: " + JSON.stringify(data));
                
                
                var htmlMovieList = '<ul>';
				$.each(data, function(i,item){
					  htmlMovieList += '<li>' + item.matchedUser.name + " " + item.matchedUser.lastName + "(" + item.matchedUser.age + ") - Intereses en común: " + item.commonInterestCount + '</li>';
				});
				htmlMovieList += '</ul>';
				$('#appendResults').html("");
				$('#appendResults').append(htmlMovieList);
            }
        });
    });

})(jQuery); // End of use strict
