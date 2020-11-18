insert into Tour (id, destinationPlz, startPlz, dateTime,arriveDrive,hasSize,isSmoker,isAnimal,isLuggage,wishedPerson,discription)
VALUES (3,5033,3453,'2020-11-18 23:18',false,5,false,false,false,1,'discription');

CREATE TABLE IF NOT EXISTS Tour
(
    id int auto_increment,
    destinationPlz int,
    startPlz int,
    dateTime DATETIME,
 arriveDrive boolean,
 hasSize int,
 isSmoker boolean,
 isAnimal boolean,
 isLuggage boolean,
 wishedPerson int,
 discription varchar (30),
        PRIMARY KEY (id)
);

Select WEEKDAY(dateTime) from Tour where id = 2;
Select DATE (dateTime) from Tour where id = 2;
Select DATE_FORMAT (dateTime)  from Tour where id = 2;


select * from user , sex where user.sex = 17 and user.sex = sex.id and user.id = 20 ;

select * from user where userName = 'AUTO' and password='test'