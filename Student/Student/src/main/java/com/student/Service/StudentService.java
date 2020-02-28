package com.student.Service;

import com.student.Entity.Student;


public interface StudentService{

	Student addStudentDetails(Student studentDetails);

	Student getStudentDetails(Long mobileNumber);

}