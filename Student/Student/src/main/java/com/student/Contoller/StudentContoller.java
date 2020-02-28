package com.student.Contoller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.Entity.Student;
import com.student.Service.StudentService;

/**
 * 
 * @author Navita Mann
 *
 */
@RestController
@RequestMapping("/microserviceStudent")
public class StudentContoller {

	@Autowired
	private StudentService studentService;
	
	/**
	 * 
	 * @param studentDetails
	 * @return
	 * @throws ParseException
	 */
	@PostMapping(value = "/addBookIssued", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> addStudentDetails(@RequestBody Student studentDetails) throws ParseException {
		this.studentService.addStudentDetails(studentDetails);
		return new ResponseEntity<>(studentDetails, HttpStatus.OK);
	}

	/**
	 * 
	 * @param mobileNumber
	 * @return
	 */
	@GetMapping(value = "/viewStudentBookDetails/{mobileNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> viewStudentDetails(@PathVariable("mobileNumber") Long mobileNumber) {
		Student studentDetails =this.studentService.getStudentDetails(mobileNumber);
	     return new ResponseEntity<>(studentDetails,HttpStatus.OK);
	 }

}
