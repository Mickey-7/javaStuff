CREATE TABLE student(
  student_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  student_name varchar(30) NOT NULL,
  student_dob varchar(10) NOT NULL,
  student_email varchar(80) NOT NULL,
  student_address varchar(250) NOT NULL
);