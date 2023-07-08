
CREATE TABLE IF NOT EXISTS plGoal (
    goalId serial UNIQUE,
    goalTitle varchar(255),
    goalProtein real,
    goalFat real,
    goalCarbohydrate real
);

CREATE TABLE IF NOT EXISTS plActivity (
    actId serial UNIQUE,
    actTitle varchar(255),
    actCoefficient real
);

CREATE TABLE IF NOT EXISTS tblPersonalInfo (
    infId bigserial UNIQUE,
    infPerson_id bigint NOT NULL,
    infCity varchar(255),
    infStreet varchar(255),
    infHouse varchar(50),
    infApartment smallint,
    infIndex INTEGER,
    infPhoneNumber varchar(20),
    email varchar(255),
    PRIMARY KEY (infId)
);

CREATE TYPE sex as ENUM('male', 'female');

CREATE TABLE IF NOT EXISTS tblPerson (
    prsId bigserial,
    prsUsername varchar(255) NOT NULL,
    prsSex sex NOT NULL,
    prsBirthdate date NOT NULL,
    prsWeight smallint NOT NULL,
    prsHeight smallint NOT NULL,
    prsActivity_id smallint NOT NULL,
    prsGoal_id smallint NOT NULL,
    prsInfo_id bigint NOT NULL,
    prsCreated_at timestamp DEFAULT current_timestamp,
    prsUpdated_at timestamp DEFAULT current_timestamp,
    PRIMARY KEY (prsId),
    FOREIGN KEY (prsActivity_id) REFERENCES plActivity (actId),
    FOREIGN KEY (prsGoal_id) REFERENCES plGoal(goalId),
    FOREIGN KEY (prsInfo_id) REFERENCES tblPersonalInfo(infId)
);


ALTER TABLE tblPersonalInfo
ADD CONSTRAINT person_personInfo_fk
FOREIGN KEY (infPerson_id) REFERENCES tblPerson(prsId);

