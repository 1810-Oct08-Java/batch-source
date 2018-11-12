--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.

--2.1 SELECT
--Select all records from the Employee table.
    SELECT * FROM EMPLOYEE;
--Select all records from the Employee table where last name is King.
    SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
    SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Select all albums in Album table and sort result set in descending order by title.
    SELECT * FROM ALBUM ORDER BY TITLE DESC;
--Select first name from Customer and sort result set in ascending order by city.
    SELECT FIRSTNAME,CITY FROM CUSTOMER ORDER BY CITY ASC;

--2.3 INSERT INTO
--Insert two new records into Genre table 
    INSERT INTO GENRE VALUES(26,'Instrumental');
    INSERT INTO GENRE VALUES(27,'Workout');
--Insert two new records into Employee table
    INSERT INTO EMPLOYEE VALUES(9,'White','Dan','Marketing Manager',1,'31-JUL-76','04-FEB-02','1788 Lighthouse Drive','Branson','AB','Canada','T2P 5G3','+1 (417) 460-3334', '+1 (212) 987-6543','dan@chinookcorp.com');
    INSERT INTO EMPLOYEE VALUES(10,'Johnson','Jessica','Marketing Staff',1,'18-MAR-88','04-APR-02','2260 Coplin Avenue','Phoenix','AB','Canada','T5K 2N1','+1 (602) 576-2939', '+1 (602) 434-4604','jessica@chinookcorp.com');
--Insert two new records into Customer table 
    INSERT INTO CUSTOMER VALUES(60,'Truman','Baldwin',NULL,'1762 North Avenue','Lincoln','NE','USA','68501','+1 (402) 840-7952','+1 (402) 601-8212','trumanbaldwin@gmail.com',3);
    INSERT INTO CUSTOMER VALUES(61,'Kylah','Hensley',NULL,'3946 Stratford Drive','Waipahu','HI','USA','96797','+1 (808) 265-2712','+1 808) 205-3645','kylahhensley@yahoo.com',2);

--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
    SELECT CUSTOMERID,FIRSTNAME,LASTNAME FROM CUSTOMER WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
    UPDATE CUSTOMER SET FIRSTNAME='Robert',LASTNAME='Walter' WHERE CUSTOMERID='32';
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
    SELECT * FROM ARTIST WHERE NAME='Creedence Clearwater Revival';
    UPDATE ARTIST SET NAME='CCR' WHERE ARTISTID=76;

--2.5 LIKE
--Select all invoices with a billing address like “T%”
    SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

--3.1 System Defined Functions
--Create a function that returns the length of name in MEDIATYPE table
    CREATE OR REPLACE FUNCTION mediaTypeNameLength(
        tableName in NUMBER
    ) RETURN NUMBER AS
    BEGIN
        return length(tableName);
    END;
    /
    
    select mediaTypeNameLength(NAME) FROM MEDIATYPE;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
--Task – Create a function that returns the most expensive track
--
--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--

--7.0 Joins
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

--7.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
    SELECT INVOICE.INVOICEID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME FROM INVOICE INNER JOIN CUSTOMER ON INVOICE.CUSTOMERID=CUSTOMER.CUSTOMERID;

--7.2 OUTER
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.\
    SELECT CUSTOMER.CUSTOMERID,CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID,INVOICE.TOTAL FROM INVOICE FULL OUTER JOIN CUSTOMER ON INVOICE.CUSTOMERID=CUSTOMER.CUSTOMERID;
    
    



COMMIT;