package com.Library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Library.Entity.Books;

/**
 * 
 * @author Navita Mann
 *
 */
@Repository
public interface BooksDAO  extends JpaRepository<Books, Long>{

}
