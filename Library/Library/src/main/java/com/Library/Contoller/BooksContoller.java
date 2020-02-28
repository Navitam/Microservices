package com.Library.Contoller;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Library.Entity.Books;
import com.Library.Service.BooksService;

/**
 * 
 * @author Navita Mann
 *
 */
@RestController
@RequestMapping("/microserviceLibrary")
public class BooksContoller {

	@Autowired
	private BooksService bookService;

	/**
	 * 
	 * @param bookDetails
	 * @return
	 * @throws ParseException
	 */
	@PostMapping(value = "/addNewBook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBookDetails(@RequestBody Books bookDetails) throws ParseException {
		if (bookDetails.getRole().equalsIgnoreCase("Librarian")) {
			String status = this.bookService.addBookDetails(bookDetails);
			return new ResponseEntity<>(status, HttpStatus.OK);
		}
		return new ResponseEntity<>("User not authorised", HttpStatus.UNAUTHORIZED);
	}

	/**
	 * 
	 * @param bookId
	 * @return
	 */
	@GetMapping(value = "/viewBookDetails/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Books> viewBookDetails(@PathVariable("bookId") Long bookId) {
		Books book = this.bookService.getBookDetails(bookId);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	/**
	 * 
	 * @param bookId
	 * @return
	 */
	@DeleteMapping(value = "/deleteBookDetails/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteReleaseConfig(@RequestBody Books bookDetails,
			@PathVariable("bookId") Long bookId) {
		if (bookDetails.getRole().equalsIgnoreCase("Librarian")) {
			String status = this.bookService.deleteBookDetails(bookId);
			return new ResponseEntity<>(status, HttpStatus.OK);
		}
		return new ResponseEntity<>("User not authorised", HttpStatus.UNAUTHORIZED);
	}

	/**
	 * 
	 * @param bookUpdate
	 * @param id
	 * @return
	 * @throws ParseException
	 */
	@PutMapping(value = "/updateBookDetails/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateUser(@RequestBody Books bookUpdate, @PathVariable Long id)
			throws ParseException {
		String status = this.bookService.updateBookDetails(bookUpdate, id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
