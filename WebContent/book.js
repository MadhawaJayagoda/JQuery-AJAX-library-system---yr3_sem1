/** 
 * 
 */

function getDetails(){
	jQuery.ajax({
        url: "http://localhost:8080/book_service/rest/books/" + $("#id").val(),
        type: "GET",
        contentType: "application/json",  
        dataType:'json',
        success: function(data, textStatus, errorThrown) {
            //here is your json.
              // process it
        	  $("#title").text(data.title);
        	  $("#price").text(data.price);

        },
        error : function(jqXHR, textStatus, errorThrown) {
        		$("#title").text("Sorry! Book not found!");
        		$("#price").text("");
        },
        timeout: 120000,
    });
};

function addBook(){
	jQuery.ajax({
			url: "http://localhost:8080/BookService/rest/books/" + $("#title").val() + $("#price").val(),
	        type: "POST",
	        contentType: "application/json",  
	        dataType:'json',
	        success: function(data, textStatus, errorThrown) {
	        	return JSON.parse(data);
	        },
	        error : function(jqXHR, textStatus, errorThrown) {
	        	alert("Error occured, please try again ...");
	        },
	        timeout: 120000,
	});
};

function removeBook(){
	jQuery.ajax({
		url: "http://localhost:8080/BookService/rest/books/" + $("#bookID").val(),
        type: "DELETE",
        contentType: "application/json",  
        dataType:'json',
        success: function(data, textStatus, errorThrown) {
        	alert("Book removed successfully ...!!!");
        },error : function(jqXHR, textStatus, errorThrown) {
        	alert("Error occured");
        },
        timeout: 120000,
	});
}