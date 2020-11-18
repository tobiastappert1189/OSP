CREATE TABLE IF NOT EXISTS User (
    id int auto_increment,
    userName varchar(30),
    mail varchar(30),
    password varchar(30),
    isManager boolean,
    sex_id int,
    PRIMARY KEY (id),
    FOREIGN KEY  (sex_id) REFERENCES  sex(sex_id)
    );
