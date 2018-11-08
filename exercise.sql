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