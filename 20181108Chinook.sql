--2.1

Select * from Employee;

Select * from Employee where lastname='King';
--Got Robert King, IT Staff

Select * from Employee where (firstname='Andrew' and reportsTo is null);
--Andrew Adams, General Manager

--2.2
Select * from Album order by title;
-- ...And Justice for All

Select firstname from Customer order by city asc;
-- Johannes

--2.3
Insert into Genre values (26, 'Folk');
Insert into Genre values (27, 'Punk');

Insert into Employee (EmployeeID, FirstName, LastName) values (10, 'Jim', 'Kirk');
Insert into Employee (EmployeeID, FirstName, LastName) VALUES (11, 'Stephen', 'King');
-- used null values to save time

Insert into Customer (CustomerID, FirstName, LastName, Email) VALUES (65, 'Lars', 'Martian', 'lars@gmail.com');
Insert into Customer (CustomerID, FirstName, LastName, Email) VALUES (66, 'Alpha', 'Beto', 'abc@123.com');
-- used null values to save time

--2.4
UPDATE Customer SET firstName='Robert', lastName='Walter'
WHERE (firstName='Aaron' and lastName='Mitchell');
--his ID was 32

UPDATE Artist SET name='CCR' WHERE name='Creedence Clearwater Revival';
--ID was 76

--2.5
Select * from Invoice Where billingAddress LIKE 'T%';
--Theodor


--3.1
Select length(name) from MediaType;

--3.2
Select AVG(total) from Invoice;
Select MAX(total) from Invoice;

--4.0

CREATE PROCEDURE empNames
BEGIN
Select firstname, lastname from Employee;
END;



--4.2
Update Employee
Set reportsto=''
Where title='manager';



--5.0

CREATE OR REPLACE PROCEDURE
(fn VARCHAR2
ln VARCHAR2,
em VARCHAR2)
AS regCustomer
Insert into Customer (CustomerID, firstName, lastName, email) values(
IDENTITY(10), fn, ln, em
);
GO;



--6.1


TRIGGER after_insert
  insert into Employee
  [  ]
BEGIN
  Select * from Employee;
END;



--7.1

SELECT firstname
FROM Customer
INNER JOIN Invoice ON Customer.firstName = Invoice.InvoiceID;



--7.2

Select CustomerID, firstname, lastname from Customer
OUTER JOIN
Select InvoiceID, Total from Invoice;


