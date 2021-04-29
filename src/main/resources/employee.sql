CREATE TABLE employee(
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    last_name VARCHAR(50),
    email VARCHAR(50),
    gender VARCHAR(1),
    age INT
);

INSERT INTO employee(last_name, email, gender, age) VALUES('Tom', 'tom@sas.com', 1, 22);
INSERT INTO employee(last_name, email, gender, age) VALUES('Jerry', 'tom@sas.com', 0, 15);
INSERT INTO employee(last_name, email, gender, age) VALUES('Bob', 'tom@sas.com', 1, 28);
INSERT INTO employee(last_name, email, gender, age) VALUES('Pony', 'tom@sas.com', 0, 42);