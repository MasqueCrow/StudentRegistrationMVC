/* user table */
CREATE TABLE user (
    id INT(11) PRIMARY KEY NOT NULL UNIQUE,
    username VARCHAR(45),
    password VARCHAR(45)
);

/* student table */
CREATE TABLE student (
    id INT PRIMARY KEY NOT NULL UNIQUE,
    name VARCHAR(45),
    age INT(11),
    mobile_no INT(11),
    city VARCHAR(200)
);

/* subject table */
CREATE TABLE subject (
    id INT(11) PRIMARY KEY NOT NULL,
    name VARCHAR(45)
);

/* student_subject table */
CREATE TABLE student_subject (
    student_id INT,
    subject_id INT,
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (subject_id) REFERENCES subject(id)
);

/* user record */
INSERT INTO servletDB.user
VALUES("admin", "admin");

/* student records */
INSERT INTO servletDB.student
VALUES("Naomi", 22, 91234612, "M'sia");

INSERT INTO servletDB.student
VALUES("JiaWei", 23, 94512357, "Singapore West");

INSERT INTO servletDB.student
VALUES("Lisa Ngoh", 22, 91542365, "Thailand Chang mai");

INSERT INTO servletDB.student
VALUES("Johnny", 18, 91234567, "Singapore");

INSERT INTO servletDB.student
VALUES("Nadine", 24, 91245678, "Dhoby Ghaut");

INSERT INTO servletDB.student
VALUES("Nelly", 23, 94561234, "Singapore");

/* subject records */
INSERT INTO servletDB.subject
VALUES ('Geography');

INSERT INTO servletDB.subject
VALUES ('Mathematics');

INSERT INTO servletDB.subject
VALUES ('English');

INSERT INTO servletDB.subject
VALUES ('Java');

INSERT INTO servletDB.subject
VALUES ('Physics');

/* student subject records */
INSERT INTO servletDB.student_subject
VALUES(1, 1);

INSERT INTO servletDB.student_subject
VALUES(2, 1);

INSERT INTO servletDB.student_subject
VALUES(1, 2);

INSERT INTO servletDB.student_subject
VALUES(1, 3);

INSERT INTO servletDB.student_subject
VALUES(1, 4);





