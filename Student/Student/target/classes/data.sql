DROP TABLE IF EXISTS Student;

CREATE TABLE Student(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  student_name VARCHAR(250) NOT NULL,
  phone_number INT NOT NULL,
  book_issued VARCHAR(250) DEFAULT NULL,
  role VARCHAR(250) NOT NULL
);
 
