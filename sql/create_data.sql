--student
insert into student (
	student_first_name, 
	student_last_name,
	student_course,
	student_group)
VALUES ('John', 'Doe', 1, 2);	

insert into student (
	student_first_name, 
	student_last_name,
	student_course,
	student_group)
VALUES ('Mary', 'Black', 1, 2);


--teacher
insert into teacher (
	teacher_first_name, 
	teacher_last_name)
VALUES ('Alex', 'Hamster');


insert into teacher (
	teacher_first_name, 
	teacher_last_name)
VALUES ('Tom', 'Brown');

--dissertation
insert into dissertation (
	dst_title, 
	dst_teacher_id,
	dst_student_id)
VALUES ('Tomato as a head vegetable', 1, 1);


--chair
insert into chair (
	chair_name, 
	chair_head_id)
VALUES ('Vegetables', 1);
