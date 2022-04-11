insert into course(id, name, updated_time_stamp, created_time_stamp)
            values(1001, 'React Course', sysdate(), sysdate());
insert into course(id, name, updated_time_stamp, created_time_stamp)
            values(1002, 'Spring Course', sysdate(), sysdate());
insert into course(id, name, updated_time_stamp, created_time_stamp)
            values(1003, 'JS Course', sysdate(), sysdate());


insert into passport(id,number)
             values(4000,'E123');
 insert into passport(id,number)
             values(4001,'E345');
 insert into passport(id,number)
             values(4002,'E547');


 insert into student(id,name,passport_id)
             values(2000,'Abc',4000);
 insert into student(id,name, passport_id)
             values(2001,'XYZ', 4001);
 insert into student(id,name, passport_id)
             values(2002,'NEW', 4002);


insert into review(id,rating,description,course_id)
             values(4000,'4','Nice',1001);
insert into review(id,rating,description,course_id)
             values(4001,'5', 'Good',1001);
insert into review(id,rating, description,course_id)
             values(4002,'5', 'Great',1003);


 insert into student_course(student_id, course_id)
                     values(2000,1001);
 insert into student_course(student_id, course_id)
                     values(2000,1002);
 insert into student_course(student_id, course_id)
                     values(2002,1003);

