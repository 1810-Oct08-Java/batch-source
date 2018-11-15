/************************
    Chinook Exercises
    
    Benjamin Deng
*************************/

/************************
    2.0 SELECT QUERIES
*************************/

/* 2.1 */

select * from Employee;
select * from Employee where lastname='King';
select * from Employee where firstname='Andrew' and reportsto is null;

/* 2.2 */
select * from Album order by title desc;
select firstname from Customer order by city asc;

/* 2.3 */
insert into genre values(26, 'Artcore');
insert into genre values(27, 'Trance');
select * from genre;

insert into Employee values(9, 'Deng', 'Benjamin', 'Big Boss', null, '26-JUL-93', '08-NOV-18', '9999 Somewhere Street', 'Somewhere', 'VA', 'USA', '99999', null, null, null);
insert into Employee values(10, 'Gend', 'Nimbanej', 'Floor Wiper', null, '26-JAN-93', '08-NOV-18', '9998 Somewhere Street', 'Somewhere', 'VA', 'USA', '99999', null, null, null);
select * from Employee;

insert into Customer values(60, 'Benjamin', 'Deng', 'Deng co.', null, null, null, null, null, null, null, 'something@somewhere.com', null);
insert into Customer values(61, 'Nimbanej', 'Gend', 'Deng co.', null, null, null, null, null, null, null, 'someotherthing@somewhere.com', null);
select * from Customer;

/* 2.4 */

update Customer 
set firstname='Robert', lastname='Walter' where firstname='Aaron' and lastname='Mitchell';

update Artist
set "NAME"='CCR' where "NAME"='Creedence Clearwater Revival';

/* 2.5 */
select * from Invoice where BILLINGADDRESS like 'T%';

/************************
    3.0 SQL Functions
*************************/

/* 3.1 */
select count("NAME") from mediatype;
--select * from mediatype;
--
--CREATE OR REPLACE FUNCTION MEDIATYPE_LENGTH(idx IN varchar2)
--RETURN number
--AS val number:= 0;
--BEGIN
--    select LENGTH("NAME") into val from mediatype where mediatypeid=idx;
--    return val;
--END;
--/

select mediatypeid, "NAME", MEDIATYPE_LENGTH(mediatypeid) from mediatype;

/* 3.2 */

--CREATE OR REPLACE FUNCTION INVOICE_TOTAL_AVG
--RETURN number
--AS avrg number:= 0;
--BEGIN
--    select AVG(total) into avrg from invoice;
--    return avrg;
--END;
--/

select AVG(total) from invoice;

select max(unitprice) from track;










