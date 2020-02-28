package com.student.Contoller;

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

import com.student.Entity.Student;
import com.student.Service.StudentService;

import org.junit.platform.runner.JUnitPlatform;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.text.ParseException;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StudentControllerTest {
	
	@InjectMocks
    StudentContoller studentController;
     
    @Mock
    StudentService studentService;
    
    @Test
    public void testAddBookDetails() throws ParseException
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        Student student = new Student();
        student.setId(1L);
        student.setStudentName("Student1");
        student.setPhoneNumber(985678L);
        student.setBookIssued("Java");
        student.setRole("Librarian");
       
        when(studentService.addStudentDetails(any(Student.class))).thenReturn(student);
        ResponseEntity<Student> responseEntity = studentController.addStudentDetails(student);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }
   
    @Test
    public void testViewBookDetails() throws ParseException
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        Student student = new Student();
        student.setId(1L);
        student.setStudentName("Student1");
        student.setPhoneNumber(985678L);
        student.setBookIssued("Java");
        student.setRole("Librarian");
       
        when(studentService.getStudentDetails(9867L)).thenReturn(student);
        ResponseEntity<Student> responseEntity = studentController.viewStudentDetails(9867L);
         
        assertThat(responseEntity.getBody().getPhoneNumber() == 9867);
       
    }

     
}
