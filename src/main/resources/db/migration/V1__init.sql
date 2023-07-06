
CREATE TABLE IF NOT EXISTS goal (
    id serial UNIQUE,
    t_title varchar(255),
    t_protein real,
    t_fat real,
    t_carbohydrate real
);

CREATE TABLE IF NOT EXISTS activity (
    id serial UNIQUE,
    t_title varchar(255),
    t_coefficient real
);

CREATE TYPE sex as ENUM('male', 'female');

CREATE TABLE IF NOT EXISTS person (
    id bigserial,
    t_sex sex,
    t_birthday date,
    t_weight smallint,
    t_height smallint,
    activity_id smallint,
    goal_id smallint,
    created_at timestamp DEFAULT current_timestamp,
    updated_at timestamp DEFAULT current_timestamp,
    PRIMARY KEY (id),
    FOREIGN KEY (activity_id) REFERENCES activity (id),
    FOREIGN KEY (goal_id) REFERENCES goal(id)
);