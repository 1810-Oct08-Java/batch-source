-- 2.0 DQL
----2.1 select queries
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE 
  WHERE LASTNAME='King';
SELECT * FROM EMPLOYEE
  WHERE FIRSTNAME='Andrew'
  AND REPORTSTO IS NULL;
  
----2.2 order by 
SELECT * FROM ALBUM ORDER BY TITLE;

SELECT * FROM CUSTOMER ORDER BY CITY ASC;

----2.3 insert rows
INSERT INTO GENRE VALUES 
  (26, 'Post-Rock');
INSERT INTO GENRE VALUES
  (27, 'mATh rOcK');
INSERT INTO EMPLOYEE VALUES
  (16 + 1, 'Bob', 'Builder', 'IT Staff', 2, CURRENT_DATE, CURRENT_DATE, '42 Wallaby Ln','Calgary', 'AB', 'Canada', 'T2P 5G3', null, null, null);
INSERT INTO EMPLOYEE VALUES
  (19, 'Mr.', 'Potato', 'IT Staff', 2, CURRENT_DATE, CURRENT_DATE, '42 Wallaby Ln','Calgary', 'AB', 'Canada', 'T2P 5G3', null, null, null);

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
  SELECT 60, 'Rick', 'Sanchez', null, null, null, null, null, null, null, null, 'rick@ricketyrick.edu', null from dual
  UNION ALL SELECT 61, 'Morty', 'Lastname', null, null, null, null, null, null, null, null, 'idontgotoschool@hardknocks.gov', null from dual;
  
---- 2.4 updates
UPDATE CUSTOMER 
  SET FIRSTNAME='Robert', LASTNAME='Walter'
  WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE ARTIST 
  SET NAME='CCR'
  WHERE NAME='Creedence Clearwater Revival';

---- 2.5 like
SELECT * FROM INVOICE 
  WHERE BILLINGADDRESS LIKE('T%');
  
CREATE OR REPLACE FUNCTION MEDIATYPE_LENGTH2(idx NUMBER)
RETURN NUMBER AS
val NUMBER := 0;
nom varchar2 := '';
BEGIN
 nom := SELECT MEDIATYPE.zzNAME FROM MEDIATYPE WHERE MEDIATYPEID=idx;
 val := LENGTH(nom);
 RETURN VAL;
END;
/

CREATE OR REPLACE FUNCTION MEDIATYPE_LENGTH(name in varchar2)
return number as
val number;
BEGIN
 val := LENGTH(name);
 RETURN val;
END;
/
select id, MEDIATYPE_LENGTH(name) from mediatype;



Select MEDIATYPE_LENGTH(2) from mediatype group by name;

--MEDIATYPE_LENGTH(1);
CREATE OR REPLACE FUNCTION AVG_INVOICES 
RETURN NUMBER IS
average NUMBER := 0;
BEGIN
  SELECT AVG(TOTAL) INTO average FROM INVOICE;
END;
/

--SELECT AVG_INVOICES() FROM INVOICE;
SELECT AVG(TOTAL) FROM INVOICE;
SELECT MAX(UNITPRICE) FROM TRACK;

CREATE OR REPLACE PROCEDURE all_full_names
names SYS_REFCURSOR
AS
BEGIN
OPEN names FOR
  SELECT FIRSTNAME, LASTNAME INTO DBMS_OUTPUT.PUT_LINE FROM EMPLOYEE;
END;
/

CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_INFO(
emp_id in number,
nameLast in varchar2, 
firstName in varchar2, 
title IN varchar2, 
toreport in number, 
birthDay in date, 
dateHired in date, 
address in varchar2, 
city in varchar2, 
city_state in varchar2,
postal in varchar2,
country in varchar2,
phone in varchar2,
fax in varchar2,
email in varchar2
)
as
begin
update employee
set LASTNAME = nameLast,
FIRSTNAME = firstName,
TITLE = title,
REPORTSTO = toreport,
BIRTHDATE = birthDay,
HIREDATE = dateHired,
ADDRESS = address, 
CITY = city, 
STATE = city_state, 
POSTALCODE = postal, 
COUNTRY = country,
PHONE = phone,
FAX = fax,
EMAIL = email
WHERE EMPLOYEEID = emp_id;
end;
/

CREATE OR REPLACE PROCEDURE NEW_CUSTOMER(
C_ID in number,
FNAME in varchar2, 
LNAME in varchar2, 
CO in varchar2, 
ADDR in varchar2, 
CY in varchar2, 
ST in varchar2, 
CTR in varchar2, 
POST in varchar2, 
FX in varchar2, 
PHN in varchar2, 
MAIL in varchar2, 
SUPPTREP_ID in number
)
AS BEGIN
INSERT INTO CUSTOMER VALUES
(C_ID, FNAME, LNAME, CO, ADDR, CY, ST, CTR, POST, FX, PHN, MAIL, SUPPTREP_ID);
END;
/


--CUSTOMERID
--FIRSTNAME
--LASTNAME
--COMPANY
--ADDRESS
--CITY
--STATE
--COUNTRY
--POSTALCODE
--PHONE
--FAX
--EMAIL
--SUPPORTREPID

CREATE OR REPLACE TRIGGER AFTER_EMP_INSERT
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT('trigger fired');
END;
/

SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER 
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
LEFT JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;