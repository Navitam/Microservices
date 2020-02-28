package com.Library.Contoller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Library.Entity.Books;
import com.Library.Service.BooksService;

import org.junit.platform.runner.JUnitPlatform;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.text.ParseException;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class BooksControllerTest {
	
	@InjectMocks
    BooksContoller bookController;
     
    @Mock
    BooksService bookService;
    
    @Test
    public void testAddBookDetails() throws ParseException
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Books book = new Books();
        book.setId(1L);
        book.setBookAuthor("Herbert");
        book.setBookName("Java");
        book.setCategory("Programming Languages");
       
        when(bookService.addBookDetails(any(Books.class))).thenReturn("true");
        ResponseEntity<String> responseEntity = bookController.addBookDetails(book);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }
   
    @Test
    public void testViewBookDetails() throws ParseException
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        Books book = new Books();
        book.setId(1L);
        book.setBookAuthor("Herbert");
        book.setBookName("Java");
        book.setCategory("Programming Languages");
       
        when(bookService.getBookDetails((long) 1)).thenReturn(book);
        ResponseEntity<Books> responseEntity = bookController.viewBookDetails((long) 1);
         
        assertThat(responseEntity.getBody().getBookName()).equals("Java");
       
    }

     
}
