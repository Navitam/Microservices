package com.student.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.Entity.Student;

@Repository
public interface StudentDAO  extends JpaRepository<Student, Long>{

}
