package com.Library.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.DAO.BooksDAO;
import com.Library.Entity.Books;

/**
 * 
 * @author Navita Mann
 *
 */
@Service
public class BooksServiceImpl implements BooksService{
	
	
	@Autowired
	private BooksDAO dao;
	
	/**
	 * This method adds the book details to the H2 DB
	 */
	@Override
	public String addBookDetails(Books bookDetails) {
		dao.save(bookDetails);	
		return "Successfully Added";
	}

	/**
	 * This method allows to get the book details with bookId
	 */
	@Override
	public Books getBookDetails(Long bookId) {
		return dao.findById(bookId).get();
	}

	/**
	 * This method delete the not required book details
	 */
	@Override
	public String deleteBookDetails(Long bookId) {
		 dao.deleteById(bookId);
		 return "Successfully Deleted";
	}

	/**
	 * This method allows to update the book details in H2 db
	 */
	@Override
	public String updateBookDetails(Books bookUpdate,Long id) {
		
		dao.findById(id).map(books -> {
			books.setCategory(bookUpdate.getCategory());
			books.setBookName(bookUpdate.getBookName());
			books.setBookAuthor(bookUpdate.getBookAuthor());
			books.setRole(bookUpdate.getRole());
            return dao.save(books);
        }).orElseGet(() -> {
        	bookUpdate.setId(id);
            return dao.save(bookUpdate);
        });
		return "Successfully updated";
	}

}
