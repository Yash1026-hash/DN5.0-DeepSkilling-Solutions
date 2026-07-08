-- ==========================================
-- PL/SQL BASICS
-- Variables
-- IF-THEN-ELSE
-- CASE
-- FOR LOOP
-- WHILE LOOP
-- LOOP...EXIT WHEN
-- ==========================================

SET SERVEROUTPUT ON;

--------------------------------------------------
-- Anonymous Block with Variables
--------------------------------------------------
DECLARE
emp_name    VARCHAR2(50) := 'John';
    salary      NUMBER := 60000;
    joiningDate DATE := SYSDATE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee : ' || emp_name);
    DBMS_OUTPUT.PUT_LINE('Salary   : ' || salary);
    DBMS_OUTPUT.PUT_LINE('Joining  : ' || joiningDate);
END;
/

--------------------------------------------------
-- IF THEN ELSE
--------------------------------------------------
DECLARE
salary NUMBER := 60000;
BEGIN
    IF salary > 50000 THEN
        DBMS_OUTPUT.PUT_LINE('High Salary');
ELSE
        DBMS_OUTPUT.PUT_LINE('Normal Salary');
END IF;
END;
/

--------------------------------------------------
-- CASE Statement
--------------------------------------------------
DECLARE
marks NUMBER := 82;
    grade CHAR(1);
BEGIN
    grade :=
        CASE
            WHEN marks >= 90 THEN 'A'
            WHEN marks >= 75 THEN 'B'
            WHEN marks >= 60 THEN 'C'
            ELSE 'F'
END;

    DBMS_OUTPUT.PUT_LINE('Grade = ' || grade);
END;
/

--------------------------------------------------
-- FOR LOOP
--------------------------------------------------
BEGIN
FOR i IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE(i);
END LOOP;
END;
/

--------------------------------------------------
-- WHILE LOOP
--------------------------------------------------
DECLARE
n NUMBER := 5;
    fact NUMBER := 1;
BEGIN
    WHILE n > 0 LOOP
        fact := fact * n;
        n := n - 1;
END LOOP;

    DBMS_OUTPUT.PUT_LINE('Factorial = ' || fact);
END;
/

--------------------------------------------------
-- LOOP EXIT WHEN
--------------------------------------------------
DECLARE
counter NUMBER := 1;
BEGIN
    LOOP
DBMS_OUTPUT.PUT_LINE(counter);
        counter := counter + 1;

        EXIT WHEN counter > 10;
END LOOP;
END;
/