package bookservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookService {
	List<Book> books;
	public BookService() {
		books = Books.getBooks();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks() {
		return books;
	}
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBook(@PathParam("id") int id) {
		  for(Book b : books) {
			  if ( b.getId() == id)
				   return b;
		  }
		  // book with the given id is not found, so throw 404 error
		  throw new NotFoundException(); 
	}
	@Path("{title}/{price}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Book addBook(@PathParam("title") String title, @PathParam("price") double price) {
		Book book = Books.addBook(title, price);
		System.out.println("Book successfully added : " + book); 
		return book;
	}
	@Path("{bookID}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteBook(@PathParam("bookID") int id) {
		Books.removeBook(id);
		return ("Book successfully removed; Book id : " + id); 
	}
}