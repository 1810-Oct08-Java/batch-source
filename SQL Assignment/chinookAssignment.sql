--2.1 --Select all rows from employee table
Select * from Employee;

--Select all rows where last name is king
Select * from Employee where LOWER(LastName) like 'king';

--Select where first name is andrew and reportsto is null
Select * from Employee where LOWER(firstname) like 'andrew' and reportsto is null;


--2.2 --Select all albums from in album table and sort result set in dexcending order by title
Select * from album order by title desc;

--Select firstname from custommer and sort result set by ascending order by city
Select Firstname from customer order by city asc;

--2.3 -- insert two new records into genre table
Select * from genre;
Insert into genre values(26,'Movies');
Insert into genre values(27,'Holidays');

--insert two new records into employee table
Select * from employee;
Insert into employee values(9,'Smith','John','Sales Support Agent',2,'08-DEC-58','08-NOV-18','123 Main ST','Calgary','AB','Canada','T5K 2N1','+1 (708) 445-4444','+1 (708) 445-4444','smith@chinookcorp.com');
Insert into employee values(10,'Jonhson','Joe','Sales Support Agent',2,'08-NOV-59','08-NOV-18','345 Main ST','Calgary','AB','Canada','T5K 2N1','+1 (708) 445-5555','+1 (708) 445-5555','johnson@chinookcorp.com');

--insert two new records into the customer table
Select * from customer;
Insert into customer values(60,'Bruce','Wayne',null,'123 Mansion dr','Gotham',null,'United States','12345','+1 (708)333-4455',null,'bwayne@gotham.com',10);
Insert into customer values(61,'Tony','Stark',null,'234 Mansion dr',null,'New York','United States','12390','+1 (708)333-9908',null,'tstark@gotham.com',9);

--2.4 -- update Aaron Mitchell in customer table to robert walter
Select * from customer where LOWER(Firstname) like 'aaron';
Update customer SET firstname = 'Rober', lastname = 'Walter' where customerid =32 ;

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
Select * from artist where artistid = 76;
Update artist SET name = 'CCR' where artistid = 76;

--2.5 -- Select all invoices with a billing address like “T%”
Select * from invoice where billingaddress like 'T%';

--3.1 --Create a function that returns the length of name in MEDIATYPE table
select mediatypelength(name) as lengthOfName from mediatype;

--function--
CREATE OR REPLACE FUNCTION mediatypelength (nm varchar)
return number IS 
    l number(2) := 0; 
Begin
    Select length(nm) into l from dual;
    return l;
End;
/
--grant create session, create procedure to myuser identified by chinook;
--grant CREATE PROCEDURE to chinook;

--3.2 --  Create a function that returns the average total of all invoices 
Select * from invoice;
Select averageTotal() from dual;

CREATE OR REPLACE FUNCTION averageTotal
return number IS
    a number (4) :=0;
Begin
    Select (SUM(total)/Count(*)) into a from invoice;
    return a;
End;
/


--Create a function that returns the most expensive track
Select * from track;
Select maxprice() from dual;

CREATE OR REPLACE FUNCTION maxprice
return number IS
    m number(4) :=0;
Begin
    Select MAX(UnitPrice) into m from track;
    return m;
End;
/

--4.1 -- Create a stored procedure that selects the first and last names of all the employees.
Select firstname||' '||lastname from employee;
exec firstlast;
Select * from tmp;

Drop table tmp;

create global temporary table tmp(x varchar2(100))
on commit delete rows;

CREATE OR REPLACE Procedure firstLast 
AS 

BEGIN
    INSERT INTO tmp
    Select firstname ||' '||lastname from employee;
END;
/

--4.2 -- Create a stored procedure that updates the personal information of an employee.
Select * from Employee;
exec update_employee(2,'Edwardss','Nancy','Sales Manager','08-DEC-58', '01-MAY-02','825 8 AVE SW', 'Calgary', 'AB', 'CANADA', 'T2P 2T3','+1 (403) 262-3443', '+1 (708) 428-3457','nancy@chinookcorp.com');
CREATE OR REPLACE Procedure update_employee(id number , fname varchar2, lname varchar2, t varchar2, bd varchar2, hd varchar2, addr varchar, c varchar2, s varchar2, co varchar2, pc varchar2, p varchar2, f varchar2, eml varchar2)
AS
BEGIN
    UPDATE employee
        SET lastname = lname,
            firstname = fname,
            Title =  t,
            birthdate = bd, 
            hiredate = hd,
            address = addr,
            city = c, 
            state = s,
            country = co,
            phone = pc,
            fax = f,
            email = eml   
        Where employeeid = id;
END;
/

--5.0 - Create a transaction nested within a stored procedure that inserts a new record in the Customer table.
Select * from customer;
CREATE OR REPLACE Procedure create_employee(id number , fname varchar2, lname varchar2, comp varchar2, addr varchar, c varchar2, s varchar2, co varchar2, pc varchar2, p varchar2, f varchar2, eml varchar2, srid number)
AS 
BEGIN
    INSERT INTO customer VALUES (id, fname, lname,comp, addr, c, s, co, pc, p, f, eml, srid);
    commit;
END;
/

--6.1 -- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Select * from employee;

CREATE OR REPLACE TRIGGER employee_a_INSERT
AFTER INSERT
ON employee
BEGIN
  DBMS_OUTPUT.PUT('NEW RECORD INSERTED');
END;
/


--7.1 -- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
Select * from customer;
Select * from invoice;

Select c.firstname, c.lastname, i.invoiceid from customer c inner Join invoice i on c.customerid = i.customerid;

--7.2 -- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
Select * from customer;
Select * from invoice;

Select c.customerid, c.firstname, c.lastname, i.invoiceid, SUM(i.total) from Customer c left outer join invoice i on c.customerid = i.customerid group by c.customerid, c.firstname, c.lastname, i.invoiceid;

