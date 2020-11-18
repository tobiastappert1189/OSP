CREATE TABLE IF NOT EXISTS User (
    id int auto_increment,
    userName varchar(30),
    mail varchar(30),
    password varchar(30),
    isManager boolean,
    PRIMARY KEY (id)
    );

drop table user;

delete from user where id =1;

CREATE TABLE IF NOT EXISTS SEX
(
    ID          INT  NOT NULL,
    DESCRIPTION TEXT NOT NULL,

    PRIMARY KEY (ID)
);

