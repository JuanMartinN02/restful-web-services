insert into user_details(id,birth_date,name)
values (1001, current_date(),'Jose');

insert into user_details(id,birth_date,name)
values (1002, current_date(),'Pascual');

insert into user_details(id,birth_date,name)
values (1003, current_date(),'Pedro');

insert into user_details(id,birth_date,name)
values (1004, current_date(),'Jayme');


insert into post(id,description,user_id)
values (2001, 'My first post',1001);

insert into post(id,description,user_id)
values (2002, 'My SECOND post',1001);

insert into post(id,description,user_id)
values (2003, 'Excited for weekend',1002);