package com.student.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.student.Entity.Student;

@Repository
public interface StudentDAO  extends JpaRepository<Student, Long>{
	
	
	@Transactional
	@Query(value="SELECT * FROM Student student where student.phone_number = :phoneNum", nativeQuery=true) 
    public Student findByPhoneNum(@Param("phoneNum") Long phoneNumber);
}

