package com.Library.Service;

import com.Library.Entity.Books;

/**
 * 
 * @author Navita Mann
 *
 */
public interface BooksService{

	String addBookDetails(Books bookDetails);

	Books getBookDetails(Long bookId);

	String deleteBookDetails(Long bookId);

	String updateBookDetails(Books bookUpdate, Long id);

}
