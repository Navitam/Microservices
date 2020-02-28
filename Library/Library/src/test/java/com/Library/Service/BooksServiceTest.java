package com.Library.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Library.DAO.BooksDAO;
import com.Library.Entity.Books;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class BooksServiceTest {

	@InjectMocks
	BooksService bookService;

	@Mock
	BooksDAO dao;

	@Test
	public void getBookByIdTest() {
		 Long id = 1L;
	        Books book = new Books();
	        book.setId(id);
	        book.setBookAuthor("Herbert");
	        book.setBookName("Java");
	        book.setCategory("Programming Languages");
	       
		when(dao.findById((long) 1).get()).thenReturn(book);
		Books bookReturned = bookService.getBookDetails((long) 1);
		assertEquals("Programming Language", bookReturned.getCategory());
	}

	@Test
	public void createBookTest() {
		 Long id = 1L;
	        Books book = new Books();
	        book.setId(id);
	        book.setBookAuthor("Herbert");
	        book.setBookName("Java");
	        book.setCategory("Programming Languages");
	       
		bookService.addBookDetails(book);
		verify(dao, times(1)).saveAndFlush(book);
	}

}