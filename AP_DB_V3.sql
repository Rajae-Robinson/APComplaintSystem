CREATE DATABASE student_services;

use student_services;

CREATE TABLE Students (
	studentID INT NOT NULL,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    contactNumber varchar(50) NOT NULL,
    PRIMARY KEY (studentID)
    );    
    
CREATE TABLE Supervisor (
	supervisorID 	INT NOT NULL,
    firstName 	varchar(50) NOT NULL,
    lastName 	varchar(50) NOT NULL,
    email 		varchar(50) NOT NULL,
    contactNumber varchar(50) NOT NULL,
    PRIMARY KEY (supervisorID)
    );
    
CREATE TABLE Advisor (
	advisorID 	INT NOT NULL,
    firstName 	varchar(50) NOT NULL,
    lastName 	varchar(50) NOT NULL,
    email 		varchar(50) NOT NULL,
    contactNumber varchar(50) NOT NULL,
    supervisorID INT NOT NULL,
    PRIMARY KEY (advisorID),
    CONSTRAINT fk_sup FOREIGN KEY (supervisorID) REFERENCES Supervisor(supervisorID)
);

CREATE TABLE Complaint (
	complaintID int NOT NULL AUTO_INCREMENT,
    studentID int NOT NULL,
    category Varchar(50) NOT NULL,
    details text NOT NULL,
    responseDate DATE,
    responderID int,
    response Text,
    PRIMARY KEY (complaintID),
    CONSTRAINT fk_sid FOREIGN KEY (studentID) REFERENCES Students(studentID),
    CONSTRAINT fk_advid FOREIGN KEY (responderID) REFERENCES Advisor(advisorID)
);
    
CREATE TABLE Query (
	queryID int NOT NULL AUTO_INCREMENT,
    studentID int NOT NULL,
    category Varchar(50) NOT NULL,
    details text NOT NULL,
    responseDate DATE,
    responderID int,
    response Text,
    PRIMARY KEY (queryID),
    CONSTRAINT fk_stuid2 FOREIGN KEY (studentID) REFERENCES Students(studentID),
    CONSTRAINT fk_advid2 FOREIGN KEY (responderID) REFERENCES Advisor(advisorID)
);
    
CREATE TABLE Login (
    id int NOT NULL,
    password varchar(500) NOT NULL,
    PRIMARY KEY (id)
);
    
/*input id, input password... check if input id matches an ID in the database, then 
check if password at same record matches input password*/

CREATE TABLE Auditing(
loginID int not null auto_increment,
userName varchar (50) not null,
loginTime datetime not null,
logoutTime datetime not null,
duration time,
activity varchar(100) not null,
PRIMARY KEY (loginID)
);

INSERT INTO Students (studentID, firstName, lastName, email, contactNumber) VALUES
	(1901709, 'Odane','Walters','odanewalters01@gmail.com','282-0763');

INSERT INTO Supervisor (supervisorID, firstName, lastName, email, contactNumber) VALUES
	(1991709, 'Julia','Walt','juliawalt01@gmail.com','282-0763');
    
INSERT INTO Advisor (advisorID, firstName, lastName, email, contactNumber, supervisorID) VALUES
	(1801609, 'Owen','Lewis','owenlewis01@gmail.com','282-0763', 1991709);
    
INSERT INTO Login (id, password) VALUES
		(1901709, 'password123'),
        (1991709, 'password123'),
        (1801609, 'password123');
 
INSERT INTO Complaint (complaintID, studentID, category, details, responseDate, responderID, response) VALUES
(1, 1901709, 'Missing grades','My grades are missing for Math.', '2022-01-01', 1801609, 'We are working on it.');

INSERT INTO Query (queryID, studentID, category, details, responseDate, responderID, response) VALUES
(1, 1901709, 'How to drop a module?', 'I started a module late and I want to drop it. ', '2022-06-01', 1801609,'Visit our website to do so.');

/*CREATE VIEW StudentQueriesAndComplaintsnew AS
SELECT
	s.studentID, s.firstName, s.lastName,
	coalesce(q.category,c.category) AS Category,
	coalesce(q.queryID,c.complaintID) AS QueryOrComplaintID,
	coalesce(q.response, c.response) AS Response
FROM Students s
LEFT JOIN Queries q ON s.studentID = q.studentID
LEFT JOIN Complaint c ON s.studentID = c.studentID
LEFT JOIN Advisor advQ ON q.responderID= advQ.advisorID
LEFT JOIN Advisor advC ON c.responderID = advC.advisorID;*/

CREATE VIEW ComplaintsViews AS
SELECT 
	C.studentID, CONCAT(a.firstName, ' ', a.lastName) AS advisorName, C.category, C.details, C.response, C.responseDATE
FROM Complaint C
INNER JOIN Advisor a ON C.responderID = a.advisorID;

CREATE VIEW QueriesViews AS
SELECT 
	Q.studentID, CONCAT(a.firstName, ' ', a.lastName) AS advisorName, Q.category,Q.details, Q.response, Q.responseDATE
FROM Query Q
INNER JOIN Advisor a ON Q.responderID = a.advisorID;

Select * from Students;
Select * from Login;
Select * from Advisor;
Select * from Supervisor;
Select * from Complaint;
Select * from Query;
Select * from ComplaintsViews;
Select * from QueriesViews;
