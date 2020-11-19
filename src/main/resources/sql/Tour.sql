
CREATE TABLE IF NOT EXISTS Tour(
    id int auto_increment,
    destinationPlz int,
    startPlz       int,
    dateTime       DATETIME,
    arriveDrive    boolean,
    hasSize        int,
    isSmoker       boolean,
    isAnimal       boolean,
    isLuggage      boolean,
    wishedPerson   int,
    discription    varchar(30),
    provider       int,
    PRIMARY KEY (id),
    FOREIGN KEY (wishedPerson) REFERENCES wishedperson (id),
    FOREIGN KEY (provider) REFERENCES user (id)
);