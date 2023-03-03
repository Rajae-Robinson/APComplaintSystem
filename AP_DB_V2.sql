CREATE DATABASE student_services;

use student_services;

CREATE TABLE Students (
	studentID INT NOT NULL,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    contactNumber varchar(50) NOT NULL,
    password varchar(500) NOT NULL,
    PRIMARY KEY (studentID)
    );    
    
CREATE TABLE Supervisor (
	supervisorID 	INT NOT NULL,
    firstName 	varchar(50) NOT NULL,
    lastName 	varchar(50) NOT NULL,
    email 		varchar(50) NOT NULL,
    contactNumber varchar(50) NOT NULL,
    password 	varchar(500) NOT NULL,
    PRIMARY KEY (supervisorID)
    );
    
CREATE TABLE Advisor (
	advisorID 	INT NOT NULL,
    firstName 	varchar(50) NOT NULL,
    lastName 	varchar(50) NOT NULL,
    email 		varchar(50) NOT NULL,
    contactNumber varchar(50) NOT NULL,
    password 	varchar(500) NOT NULL,
    supervisorID INT NOT NULL,
    PRIMARY KEY (advisorID),
    CONSTRAINT fk_sup FOREIGN KEY (supervisorID) REFERENCES Supervisor(supervisorID)
    );

CREATE TABLE Complaint(
	complaintID int NOT NULL AUTO_INCREMENT,
    studentID int NOT NULL,
    category Varchar(50) NOT NULL,
    details text NOT NULL,
    responseDate DATE,
    responderID int,
    response Text,
    PRIMARY KEY (complaintID),
    FOREIGN KEY (studentID) REFERENCES Students(studentID),
    FOREIGN KEY (responderID) REFERENCES Advisor(advisorID)
    );
    
CREATE TABLE Queries(
	queryID int NOT NULL AUTO_INCREMENT,
    studentID int NOT NULL,
    category Varchar(50) NOT NULL,
    details text NOT NULL,
    responseDate DATE,
    responderID int,
    response Text,
    PRIMARY KEY (queryID),
    FOREIGN KEY (studentID) REFERENCES Students(studentID),
    FOREIGN KEY (responderID) REFERENCES Advisor(advisorID)
    );
    
    CREATE TABLE Auditing(
	loginID int not null auto_increment,
    userName varchar (50) not null,
    loginTime datetime not null,
    logoutTime datetime not null,
    duration time,
    activity varchar(100) not null,
    primary key(loginID)
    );
    
    CREATE TABLE StudentLog (
	studentID int not null,
    loginID int not null,
    foreign key(studentID) references Students(studentID),
    foreign key(loginID) references Login(loginID)
    );
    
	CREATE TABLE SupervisorLog (
	supervisorID int not null,
    loginID int not null,
    foreign key(supervisorID) references Supervisor(supervisorID),
    foreign key(loginID) references Login(loginID)
    );
    
  CREATE TABLE AdvisorLog (
	advisorID int not null,
    loginID int not null,
    foreign key(advisorID) references Advisor(advisorID),
    foreign key(loginID) references Login(loginID)
    );
    
INSERT INTO Students (studentID, firstName, lastName, email, contactNumber, password) VALUES
	(1901709, 'Odane','Walters','odanewalters01@gmail.com','282-0763', SHA2('password123', 256));

INSERT INTO Supervisor (supervisorID, firstName, lastName, email, contactNumber, password) VALUES
	(1901709, 'Julia','Walt','juliawalt01@gmail.com','282-0763', SHA2('password123', 256));
    
INSERT INTO Advisor (advisorID, firstName, lastName, email, contactNumber, password, supervisorID) VALUES
	(1801609, 'Owen','Lewis','owenlewis01@gmail.com','282-0763', SHA2('password123', 256), 1901709);
 
 INSERT INTO Complaint (complaintID, studentID, category, details, responseDate, responderID, response) VALUES
	(1, 1901709, 'Missing grades','My grades are missing for Math.', '2022-01-01', 1801609, 'We are working on it.');
 
 INSERT INTO Queries (queryID,studentID, category,details,responseDate,responderID, response) VALUES
	(1, 1901709, 'How to drop a module?', 'I started a module late and I want to drop it. ', '2022-06-01', 1801609,'Visit our website to do so.');

CREATE VIEW StudentQueriesAndComplaintsnew AS
SELECT
	s.studentID, s.firstName, s.lastName,
	coalesce(q.category,c.category) AS Category,
	coalesce(q.queryID,c.complaintID) AS QueryOrComplaintID,
	coalesce(q.response, c.response) AS Response
FROM Students s
LEFT JOIN Queries q ON s.studentID = q.studentID
LEFT JOIN Complaint c ON s.studentID = c.studentID
LEFT JOIN Advisor advQ ON q.responderID= advQ.advisorID
LEFT JOIN Advisor advC ON c.responderID = advC.advisorID;

CREATE VIEW ComplaintsViews AS
SELECT 
	C.studentID, CONCAT(a.firstName, ' ', a.lastName) AS advisorName, C.category, C.details, C.response, C.responseDATE
FROM Complaint C
INNER JOIN Advisor a ON C.responderID = a.advisorID;

CREATE VIEW QueriesViews AS
SELECT 
	Q.studentID, CONCAT(a.firstName, ' ', a.lastName) AS advisorName, Q.category,Q.details, Q.response, Q.responseDATE
FROM Queries Q
INNER JOIN Advisor a ON Q.responderID = a.advisorID;
