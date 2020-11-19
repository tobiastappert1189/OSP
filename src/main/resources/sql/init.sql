insert into sex(id,DISCRIPTION) values (1,'FEMALE');
insert into sex(id,DISCRIPTION) values (2,'MAlE');
insert into sex(id,DISCRIPTION) values (3,'FEMaLE');
insert into sex(id,DISCRIPTION) values (4,'FEMALE');

insert into wishedperson(id,DISCRIPTION) values (1,'FEMALE');
insert into wishedperson(id,DISCRIPTION) values (2,'MAlE');
insert into wishedperson(id,DISCRIPTION) values (3,'FEMaLE');
insert into wishedperson(id,DISCRIPTION) values (4,'FEMALE');


insert into user (id, userName, mail, password, isManager, sex) VALUES (3,'tobias','tobias@googlemail.com','naruto',false,1);
insert into user (id, userName, mail, password, isManager, sex) VALUES (4,'tobias','tobias@googlemail.com','naruto',false,1);
insert into user (id, userName, mail, password, isManager, sex) VALUES (5,'tobias','tobias@googlemail.com','naruto',false,1);
insert into user (id, userName, mail, password, isManager, sex) VALUES (6,'tobias','tobias@googlemail.com','naruto',false,1);
insert into user (id, userName, mail, password, isManager, sex) VALUES (7,'tobias','tobias@googlemail.com','naruto',false,1);


insert into Tour (id, destinationPlz, startPlz, dateTime,arriveDrive,hasSize,isSmoker,isAnimal,isLuggage,wishedPerson,discription,provider)
VALUES (4,5033,3453,'2020-11-18 23:18',false,5,false,false,false,1,'discription',4);

insert into Tour (id, destinationPlz, startPlz, dateTime,arriveDrive,hasSize,isSmoker,isAnimal,isLuggage,wishedPerson,discription,provider)
VALUES (5,5033,3453,'2020-11-18 23:18',false,5,false,false,false,1,'discription',5);


# Select WEEKDAY(dateTime) from Tour where id = 2;
# Select DATE (dateTime) from Tour where id = 2;
# Select DATE_FORMAT (dateTime)  from Tour where id = 2;
#
#
# select * from user , sex where user.sex = 17 and user.sex = sex.id and user.id = 20 ;
#
# select * from user where userName = 'AUTO' and password='test'