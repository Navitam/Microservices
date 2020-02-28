package com.student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.DAO.StudentDAO;
import com.student.Entity.Student;

/**
 * 
 * @author Navita Mann
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO dao;

	/**
	 * This service method adds the student details to H2 DB
	 */
	@Override
	public Student addStudentDetails(Student studentDetails) {
		return dao.save(studentDetails);
	}
	
	/**
	 * This service method gets the student details from H2 DB
	 */
	@Override
	public Student getStudentDetails(Long mobileNumber) {
		Student student=dao.findByPhoneNum(mobileNumber);
		return student;
	}
	
}
