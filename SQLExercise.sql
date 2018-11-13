--2.1--
select * from record;
select * from employee where lastname ='King';
select * from employee where firstname='Andrew' and reportsto is null;

--2.2--
select  * from album sort by title desc;
select firstname from customer sort by city asc;

--2.3--
insert into genre values (25,'folk-punk');
insert into genre values (26, 'folk-rock');

insert into employee values (9, 'John', 'Smith', null, null, null, null, null, null, null, null, null, null, null, null);
insert into employee values (10, 'John', 'Doe', null, null, null, null, null, null, null, null, null, null, null, null);

insert into customer values ( 66, 'Jane', 'Doe', null, null, null, null, null, null, null, null, 'something@something.something', null);
insert into customer values ( 67, 'Jane', 'Smith', null, null, null, null, null, null, null, null, 'something@something.something', null);

--2.4--
select * from invoice where billingaddress like 'T%';

--3.1--
CREATE OR REPLACE FUNCTION LENGTH_OF_MEDIATYPE RETURN NUMBER 
IS temp NUMBER;
BEGIN
  select count(name) into temp from mediatype;
  return temp;
END LENGTH_OF_MEDIATYPE;


--3.2--
CREATE OR REPLACE FUNCTION AVG_OF_INVOICE RETURN NUMBER 
IS temp NUMBER;
BEGIN
  select avg(total) into temp from invoice;
  return temp;
END AVG_OF_INVOICE;

CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK RETURN NUMBER 
IS temp NUMBER;
BEGIN
    select unitprice into temp from track where rownum = 1;
    return temp;
END MOST_EXPENSIVE_TRACK;

--4.1--
create or replace procedure basicinfo(
u_firstname out varchar2, 
u_lastname out varchar2
)as 
begin
    select firstname ,lastname into u_firstname,u_lastname from employee;
end basicinfo;

--4.2--
create or replace procedure updateaddress (
e_id in number,
e_address in varchar2,
e_city in varchar2,
e_state in varchar2,
e_country in varchar2,
e_postalcode in number
)as
begin
    update employee
    set 
        address = e_address,
        city = e_city,
        state = e_state,
        country = e_country,
        postalcode = e_postalcode
    where 
        employeeid = e_id;
end updateaddress;


--5.0--
create or replace procedure new_customer (
c_id in number,
c_firstname in varchar2,
c_lastname in varchar2
) as
begin
    insert into customer values(c_id, c_firstname, c_lastname, null,  null, null, null, null, null, null, null, null, null);
end new_customer;

--6.1--
CREATE OR REPLACE TRIGGER AFTER_INSERTION 
AFTER INSERT ON EMPLOYEE 
BEGIN
  dbms_output.put('hello world');
END;

--7.1--
select c.firstname, c.lastname, i.invoiceid
from customer c
inner join invoice i on c.customerid = i.customerid;

--7.2--
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c
full outer join invoice i on c.customerid = i.customerid;
