-- we can create a comment like this
/*
this is a multiline comment
we can comment on this line too
*/

-------------------------------------
-- USING DDL TO CREATE OUR TABLES
-------------------------------------
CREATE TABLE DEPARTMENT(
    DEPT_ID NUMBER(5) CONSTRAINT PK_DEPT PRIMARY KEY,
    DEPT_NAME VARCHAR2(50),
    MONTHLY_BUDGET NUMBER(7,2)
);

CREATE TABLE EMPLOYEE (
    EMP_ID NUMBER(5) CONSTRAINT PK_EMP PRIMARY KEY,
    EMP_NAME VARCHAR2(50),
    BIRTHDAY DATE,
    MONTHLY_SALARY NUMBER(7,2) NOT NULL,
    HIRE_DATE DATE,
    POSITION VARCHAR2(20),
    MANAGER_ID NUMBER(5),
    DEPT_ID NUMBER(5) CONSTRAINT FK_EMP_DPT REFERENCES DEPARTMENT ON DELETE CASCADE
);

-- INSERTING RECORDS INTO OUR DEPARTMENT TABLE
INSERT INTO DEPARTMENT VALUES (1, 'MARKETING', 5000);
INSERT INTO DEPARTMENT VALUES (2, 'ACCOUNTING', 4000);
INSERT INTO DEPARTMENT VALUES (3, 'INFORMATION TECHNOLOGY', 4500);
INSERT INTO DEPARTMENT VALUES (4, 'HUMAN RESOURCES', 3500);
INSERT INTO DEPARTMENT VALUES (5, 'LEGAL', 2000);
INSERT INTO DEPARTMENT VALUES (6, 'CUSTOMER SERVICE', 3000);


-- INSERT SOME EMPLOYEES INTO OUR EMPLOYEE TABLE (DML)
INSERT INTO EMPLOYEE VALUES (1, 'JOHN SMITH', DATE '1989-01-05', 2000, DATE '2015-03-08', 'MK_REP',NULL,1);
INSERT INTO EMPLOYEE VALUES (2, 'JAMES BOSH', DATE '1990-08-13', 3200, DATE '2013-02-20', 'AC_ACCOUNT',NULL,2);
INSERT INTO EMPLOYEE VALUES (3, 'LISA JACKSON', DATE '1988-10-15', 3800, DATE '2012-03-08', 'IT_PROF',NULL,3);
INSERT INTO EMPLOYEE VALUES (4, 'ANGELA DEAN', DATE '1982-12-07', 2000, DATE '2017-04-12', 'IT_PROF',3,3);
INSERT INTO EMPLOYEE VALUES (5, 'NIGEL OAKS', DATE '1990-07-28', 2200, DATE '2018-07-20', 'MK_REP',1,1);
INSERT INTO EMPLOYEE VALUES (6, 'JAMES BOND', DATE '1992-11-13', 2800, DATE '2017-10-03', 'MK_REP',1,1);


------------------------------------
-- QUERYING THE DATABASE
------------------------------------

SELECT * 
FROM EMPLOYEE 
WHERE MANAGER_ID=1;

SELECT EMP_NAME, MONTHLY_SALARY, HIRE_DATE
FROM EMPLOYEE 
WHERE MANAGER_ID=1;

SELECT *
FROM EMPLOYEE 
WHERE EMP_NAME LIKE 'JAMES%'
ORDER BY MONTHLY_SALARY DESC;

SELECT COUNT(*) AS TOTAL_EMPLOYEES
FROM EMPLOYEE;

-- SHOW THE AVERAGE SALARY BY DEPARTMENT
SELECT DEPT_ID DEPT, ROUND(AVG(MONTHLY_SALARY)) AVG_SALARY
FROM EMPLOYEE
GROUP BY DEPT_ID
HAVING DEPT_ID<3;

SELECT *
FROM EMPLOYEE 
WHERE DEPT_ID=1 OR DEPT_ID=3 OR DEPT_ID=6;

SELECT *
FROM EMPLOYEE
WHERE DEPT_ID IN (1,3,6);

-- USING SUBQUERIES
SELECT *
FROM EMPLOYEE
WHERE MONTHLY_SALARY =
    (SELECT MAX(MONTHLY_SALARY)
    FROM EMPLOYEE);
    
-- ADDING ANOTHER TABLE FOR EMPLOYEE LOCATIONS
CREATE TABLE LOCATIONS(
    LOCATION_ID NUMBER(5),
    STREET VARCHAR2(25),
    CITY VARCHAR2(25),
    STATE VARCHAR2(2),
    ZIPCODE NUMBER(5)
);
-- INCLUDE PK
ALTER TABLE LOCATIONS
ADD CONSTRAINT PK_LOCATIONS PRIMARY KEY (LOCATION_ID);

-- ADD EMPLOYEE LOCATION IN EMPLOYEE TABLE
ALTER TABLE EMPLOYEE
ADD LOCATION_ID NUMBER(5);

-- ADD RELATIONSHIP BETWEEN EMPLOYEE AND LOCATION
ALTER TABLE EMPLOYEE 
ADD CONSTRAINT FK_EMP_LOCATION
FOREIGN KEY (LOCATION_ID) REFERENCES LOCATIONS;

-- INSERT LOCATIONS INTO OUR LOCATION TABLE
INSERT INTO LOCATIONS VALUES (1, '14 MAIN STREET', 'RESTON', 'VA', 20190);
INSERT INTO LOCATIONS VALUES (2, '960 TCHOUPITOULAS ST', 'NEW ORLEANS', 'LA', 70118);
INSERT INTO LOCATIONS VALUES (3, '200 LOMBARD ST', 'SAN FRANCISCO', 'CA', 94109);
COMMIT;

-- INSERT MORE DATA INTO OUR EMPLOYEE TABLE
INSERT INTO EMPLOYEE VALUES (7, 'JILLIAN KYND', DATE '1980-10-15', 2840.00, DATE '2015-05-11', 'AC_ACCOUNT', 2, 2, 1);
INSERT INTO EMPLOYEE VALUES (8, 'TIM KIBBEL', DATE '1980-05-20', 2240.00, DATE '2014-07-28', 'MK_REP', 1, 1, 1);
INSERT INTO EMPLOYEE VALUES (9, 'ETHELIN COMINI', DATE '1982-06-16', 3380.00, DATE '2017-10-02', 'IT_DEV', 3, 3, 1);
INSERT INTO EMPLOYEE VALUES (10, 'JASE HANDLEY', DATE '1975-10-08', 1870.00, DATE '2017-08-17', 'LG_LAW',11, 5, 1);
INSERT INTO EMPLOYEE VALUES (11, 'ARIEL PAVIS', DATE '1981-09-23', 4500.00, DATE '2015-07-12', 'LG_LAW', NULL, 5, 2);
INSERT INTO EMPLOYEE VALUES (12, 'MELISSA ITZKOVSKY', DATE '1983-03-03', 3870.00, DATE '2014-09-15', 'LG_LAW',11, 5, 2);
INSERT INTO EMPLOYEE VALUES (13, 'MALIA FILISOV', DATE '1976-07-11', 4620.00, DATE '2014-11-09', 'CS_REP', NULL, 6, 2);
INSERT INTO EMPLOYEE VALUES (14, 'BRENDAN LOUISET', DATE '1979-01-21', 3760.00, DATE '2018-03-28', 'CS_REP',13, 6, 2);
INSERT INTO EMPLOYEE VALUES (15, 'MILT KLIEMANN', DATE '1983-02-25', 3820.00, DATE '2016-05-01', 'AC_ACCOUNT', 2, 2, 2);
INSERT INTO EMPLOYEE VALUES (16, 'LUCILLE HUNE', DATE '1994-01-04', 2300.00, DATE '2016-04-17', 'MK_REP',1, 1, 2);
INSERT INTO EMPLOYEE VALUES (17, 'PETA POLTZOLD', DATE '1990-09-24', 2500.00, DATE '2015-07-10', 'IT_DEV',3, 3, 3);
INSERT INTO EMPLOYEE VALUES (18, 'LYDIA POVER', DATE '1991-10-01', 2800.00, DATE '2016-08-03', 'IT_DEV', 17, 3, 3);
INSERT INTO EMPLOYEE VALUES (19, 'RON WINTERTON', DATE '1977-09-27', 2500.00, DATE '2018-02-23', 'LG_LAW', 11, 5, 3);
INSERT INTO EMPLOYEE VALUES (20, 'NITIN CHESTNUT', DATE '1995-01-18', 2800.00, DATE '2014-10-25', 'CS_REP', 13, 6, 3);
COMMIT;

-------------------------------------------------
-- WORKING WITH JOINS
-------------------------------------------------

-- INNER JOIN
SELECT 
    E.EMP_NAME AS NAME,
    D.DEPT_NAME AS DEPARTMENT
FROM EMPLOYEE E
JOIN DEPARTMENT D -- THIS LINE IS THE SAME AS "INNER JOIN DEPARTMENT D"
ON E.DEPT_ID = D.DEPT_ID;

-- IMPLICIT INNER JOIN
SELECT 
    E.EMP_NAME AS NAME,
    D.DEPT_NAME AS DEPARTMENT
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID = D.DEPT_ID;


-- NATURAL JOIN APPEARS THE SAME BECAUSE WE SELECTED COLUMNS
-- IF WE HAD NOT SPECIFIED, INNER JOIN WOULD HAVE REPEATED COMMON COLUMNS
-- NATURAL WOULD NOT HAVE HAD REPEATED COLUMNS
SELECT 
    E.EMP_NAME AS NAME,
    D.DEPT_NAME AS DEPARTMENT
FROM EMPLOYEE E
NATURAL JOIN DEPARTMENT D;

-- ALSO COULD USE FULL OUTER JOIN
SELECT 
    E.EMP_NAME AS NAME,
    D.DEPT_NAME AS DEPARTMENT
FROM EMPLOYEE E
FULL JOIN DEPARTMENT D 
ON E.DEPT_ID = D.DEPT_ID;

-- LEFT OUTER JOIN
SELECT 
    E.EMP_NAME AS NAME,
    D.DEPT_NAME AS DEPARTMENT
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D 
ON E.DEPT_ID = D.DEPT_ID;

-- RIGHT OUTER JOIN
SELECT 
    E.EMP_NAME AS NAME,
    D.DEPT_NAME AS DEPARTMENT
FROM EMPLOYEE E
RIGHT JOIN DEPARTMENT D 
ON E.DEPT_ID = D.DEPT_ID;

-- CROSS JOIN
SELECT E.EMP_NAME, D.DEPT_NAME
FROM EMPLOYEE E
CROSS JOIN DEPARTMENT D;

-- SELF JOIN
SELECT EMPLOYEEA.EMP_NAME AS EMPLOYEE, EMPLOYEEB.EMP_NAME AS MANAGER
    FROM EMPLOYEE EMPLOYEEA, EMPLOYEE EMPLOYEEB
    WHERE EMPLOYEEA.MANAGER_ID  = EMPLOYEEB.EMP_ID
    ORDER BY MANAGER;