CREATE DATABASE university CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE student(
	student_id INT(11) NOT NULL AUTO_INCREMENT, 
	student_first_name VARCHAR(50) NOT NULL,
	student_last_name VARCHAR(50) NOT NULL,
	student_course INT(11) NOT NULL,
	student_group INT(11) NOT NULL,
	PRIMARY KEY (student_id)
	);
	
CREATE TABLE teacher(
	teacher_id INT(11) NOT NULL AUTO_INCREMENT, 
	teacher_first_name VARCHAR(50) NOT NULL,
	teacher_last_name VARCHAR(50) NOT NULL,
	PRIMARY KEY (teacher_id)
	);  	
	
CREATE TABLE dissertation(
	dst_id INT(11) NOT NULL AUTO_INCREMENT, 
	dst_title VARCHAR(250) NOT NULL,
	dst_student_id INT(11),
	dst_teacher_id INT(11),
	PRIMARY KEY (dst_id)
	);  
	
CREATE TABLE chair(
	chair_id INT(11) NOT NULL AUTO_INCREMENT, 
	chair_name VARCHAR(250) NOT NULL,
	chair_head_id INT(11),
	PRIMARY KEY (chair_id)
	);	
	
ALTER TABLE dissertation
 	ADD CONSTRAINT fk_dst_teacher FOREIGN KEY (dst_teacher_id)
 	REFERENCES teacher(teacher_id);
 	
ALTER TABLE dissertation
 	ADD CONSTRAINT fk_dst_student FOREIGN KEY (dst_student_id)
 	REFERENCES student(student_id); 	
 	 	
ALTER TABLE chair
 	ADD CONSTRAINT fk_chair_teacher FOREIGN KEY (chair_head_id)
 	REFERENCES teacher(teacher_id); 		


