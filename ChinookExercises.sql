/* Chinook Exercises */

/* Exercise 2.1 */

select * from employee;
select * from employee where lastname = 'King';
select * from employee where firstname = 'Andrew' and REPORTSTO is null;

/* Exercise 2.2 */
select * from album order by title desc;
select firstname from customer order by city;

/* Exercise 2.3 */
insert into genre values (26, 'Drake');
insert into genre values (27, 'Yodeling');

insert into employee values (9, 'James', 'Lebron', 'King', null, '11-NOV-85', '11-NOV-03', '4563 King Street', 'Los Angeles', 'CA', 'U S of A baby', 'T1H 5M5', '1 (315) 383-3987', '1 (315) 383-3987', 'leking@gmail.com');
insert into employee values (10, 'Graham', 'Aubrey', 'Drake', null, '11-NOV-87', '11-NOV-05', '4564 King Street', 'Toronto', 'TO', 'CANADA', 'T1H 5M6', '1 (315) 383-3986', '1 (315) 383-3986', 'drake@gmail.com');

insert into customer values (60, 'Rodney', 'Dangerfield', 'Disney', '412 Birch Street', 'Los Angeles', 'CA', 'USA', '4567', '1 (315) 383 3987', null, 'rodney@dangerfield.com', 3);
insert into customer values (61, 'Judge', 'Judy', 'Court', '413 Birch Street', 'Los Angeles', 'CA', 'USA', '4567', '1 (315) 383 3983', null, 'judge@judy.com', 3);

/* Exercise 2.4 */
select * from artist;
update customer set firstname = 'Robert', lastname = 'Walter' where firstname= 'Aaron' and lastname = 'Mitchell';
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

/* Exercise 2.5 */
select * from invoice where billingaddress like 'T%';

/* Exercise 3.1 */
select count(name) from mediatype;

--not sure what they were asking for
create or replace function mediaTypeLength (nameLength in varchar2) 
return number as myLength number;
begin
    myLength := LENGTH(nameLength);
    return myLength;
end;
/

/* Exercise 3.2 */
select avg(total) from invoice;

select max(unitprice) from track;

/* Exercise 4.1 */
create or replace procedure selectEmployees as
    first_last sys_refcursor;
begin
    open first_last for
    select firstname, lastname from employee;
    dbms_sql.return_result(first_last);
end;
/
exec selectEmployees;

/* Exercise 4.2 */
create or replace procedure updateEmployee
as
begin
    update employee set lastname = 'Jones' where firstname = 'Nancy';
end;
/
exec updateEmployee();

/* Exercise 5.0 */
create or replace procedure insertCustomer
as
begin
    insert into customer values (62, 'Dory', 'Finding', 'The ocean', '42 Wallaby way', 'P. Sherman', 'Sydney', 'Australia', '4567', '1 (315) 383 3983', null, 'judge@judy.com', 3);
    commit;
end;
/
exec insertCustomer();

/* Exercise 6.0 */
create or replace trigger trig
after insert on employee 
begin 
    dbms_output.put_line('Employee has been inserted.');
end;
/

/* Exercise 7.1 */
select firstname, lastname, invoiceid from invoice inner join customer on customer.customerid = invoice.customerid;

/* Exercise 7.2 */
select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total from invoice full join customer on customer.customerid = invoice.customerid;