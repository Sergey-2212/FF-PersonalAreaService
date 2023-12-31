CREATE TABLE IF NOT EXISTS pl_goal (
                                      goal_id serial UNIQUE,
                                      goal_title varchar(255),
                                      goal_protein real,
                                      goal_fat real,
                                      goal_carbohydrate real
);

INSERT INTO pl_goal (goal_title, goal_protein, goal_fat,goal_carbohydrate) values
                                                                               ('Keep', 1, 1, 1),
                                                                               ('Lose', 2, 2, 2),
                                                                               ('Get', 3, 3, 3);


CREATE TABLE IF NOT EXISTS pl_activity (
                                          act_id serial UNIQUE,
                                          act_title varchar(255),
                                          act_coefficient real
);

INSERT INTO pl_activity (act_title, act_coefficient) VALUES
('Min', 1),
('Light', 2),
('Medium', 3),
('High', 4),
('Extreme', 5);

CREATE TABLE IF NOT EXISTS tbl_person_info (
                                               inf_id bigserial,
                                               inf_city varchar(255),
                                               inf_street varchar(255),
                                               inf_house varchar(50),
                                               inf_apartment smallint,
                                               inf_index INTEGER,
                                               inf_phone_number varchar(20),
                                               inf_email varchar(255),
                                               person_id bigint,
                                               PRIMARY KEY (inf_id)
);

CREATE TABLE IF NOT EXISTS tbl_person (
                                         prs_id bigserial,
                                         prs_username varchar(255) NOT NULL,
                                         prs_sex varchar(10) NOT NULL,
                                         prs_birthdate date NOT NULL,
                                         prs_weight smallint NOT NULL,
                                         prs_height smallint NOT NULL,
                                         prs_activity_id smallint NOT NULL,
                                         prs_goal_id smallint NOT NULL,
                                         prs_person_info_id BIGINT,
                                         prs_created_at timestamp DEFAULT current_timestamp,
                                         prs_updated_at timestamp DEFAULT current_timestamp,
                                         PRIMARY KEY (prs_id),
                                         FOREIGN KEY (prs_activity_id) REFERENCES pl_activity (act_id),
                                         FOREIGN KEY (prs_goal_id) REFERENCES pl_goal(goal_id),
                                         FOREIGN KEY (prs_person_info_id) REFERENCES tbl_person_info(inf_id)

);

ALTER TABLE tbl_person_info
    ADD FOREIGN KEY (person_id) REFERENCES tbl_person(prs_id);




