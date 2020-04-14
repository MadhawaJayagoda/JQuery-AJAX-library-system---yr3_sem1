package bookservice;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.NumberLiteral;

public class Books {
	private static ArrayList<Book> books = new ArrayList<>();
	private static int lastBookId;
	static {
		books.add(new Book(1, "The Outliers", 500));
		books.add(new Book(2, "World Is Flat", 550));
	}
	public static List<Book> getBooks() {
		return books;
	}
	public static Book addBook(String title, double price) {
		if (books != null && !books.isEmpty()) {
			Book lastBook = books.get(books.size() - 1);
			lastBookId = lastBook.getId();
		}
		int newBookId = lastBookId + 1; 
		Book newBook = new Book( newBookId, title, price); 
		books.add(newBook);
		System.out.println("New Book added to the ArrayList =>\n\tBookID : " + newBookId + "\n\tBookName : " + title + "\n\tBookPrice : " + price + "\n");
		return newBook;
	}
	public static void removeBook(int bookId) {
		int resp = returnRemoveBookIndex(bookId);
		try {
			if (resp != -1) {
				books.remove(resp);
			} else {
				System.out.println("Item cannot be found to delete...!");
			}
		} catch (NullPointerException err) {
			err.printStackTrace();
			System.out.println("Your are trying to access something that deos not exist...!!!");
		}

	}

	public static int returnRemoveBookIndex(int bookId) {
		if (books != null && !books.isEmpty()) {
			// books.remove(bookId);
			for (Book book : books) {
				if (book.getId() == bookId) {
					return (books.indexOf(book));
				}
			}
			return -1;
		}
		return -1;
	}
}