--2.1 SELECT
SELECT * FROM employee; 
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

--2.2 ORDER BY
SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city;

--2.3 INSERT INTO
INSERT INTO genre VALUES (26,'Soft Rock');
INSERT INTO genre VALUES (27,'Family');
INSERT INTO employee VALUES (12, 'Ellidy', 'Nicole', 'IT Manager', 1, '24-NOV-02', '12-NOV-18', 
    '248 Bic Street E', 'Knothole', 'GH', 'Acorn', 'M0B 1U5', '+1 (234) 567-8901', '+1 (234) 109-8765', 'nicole@chinookcorp.com');
INSERT INTO employee VALUES (14, 'Shard', 'Gemerl', 'IT Staff', 12, '25-MAR-02', '27-NOV-18', 
    '245 Bic Street E', 'Knothole', 'GH', 'Acorn', 'M0B 1U5', '+1 (234) 765-1098', '+1 (234) 901-5678', 'gemerl@chinookcorp.com');
INSERT INTO customer VALUES (60, 'Po', 'Panda', 'Furious Six', '102 Duck Road E', 'Village', null, 'China', null, '+23 34 456 678', null, 'kfp@dojo.org', 3);
INSERT INTO customer VALUES (61, 'Do', 'Duck', 'Noodle Rest', '102 Panda Way SE', 'Village', null, 'China', null, '+23 34 541 786', null, 'do@noodle.com', 3);

--2.4 UPDATE
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--3.1 System Defined Functions
SELECT LENGTH(name) FROM mediatype;
-- or this?
--CREATE OR REPLACE FUNCTION find_length
--RETURN INTEGER
--IS strlength INTEGER;
--BEGIN 
--   
--END;
--/

--3.2 System Defined Aggregate Functions
SELECT AVG(total) FROM invoice;
SELECT MAX(unitprice) FROM  track;

--4.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE full_names AS
BEGIN
	SELECT firstname, lastname FROM employee; --expects INTO
END;
/

--4.2 Stored Procedure Input Parameters
CREATE OR REPLACE PROCEDURE update_emp(infoCol IN REF, newVal IN VARCHAR2) AS -- 'in' marks parameters to be passed in
-- 'out' marks those to be returned
BEGIN
	UPDATE employee SET infoCol = newVal;
END;
/