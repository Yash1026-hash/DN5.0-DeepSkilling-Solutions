SET SERVEROUTPUT ON;

--------------------------------------------------
-- Package Specification
--------------------------------------------------

CREATE OR REPLACE PACKAGE employee_package AS

    PROCEDURE add_employee(
        p_emp_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    );

    PROCEDURE delete_employee(
        p_emp_id NUMBER
    );

END employee_package;
/

--------------------------------------------------
-- Package Body
--------------------------------------------------

CREATE OR REPLACE PACKAGE BODY employee_package AS

    PROCEDURE add_employee(
        p_emp_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    )
    AS
BEGIN
INSERT INTO employees(employee_id, first_name, salary)
VALUES(p_emp_id, p_name, p_salary);

COMMIT;

DBMS_OUTPUT.PUT_LINE('Employee Added Successfully.');

EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;

    PROCEDURE delete_employee(
        p_emp_id NUMBER
    )
AS
BEGIN
DELETE FROM employees
WHERE employee_id = p_emp_id;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Employee Deleted Successfully.');

EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;

END employee_package;
/

--------------------------------------------------
-- Execute Package Procedures
--------------------------------------------------

BEGIN
    employee_package.add_employee(500, 'Alex', 45000);
    employee_package.delete_employee(500);
END;
/

--------------------------------------------------
-- BEFORE INSERT Trigger
--------------------------------------------------

CREATE OR REPLACE TRIGGER trg_before_insert_employee

BEFORE INSERT
ON employees

FOR EACH ROW

BEGIN

    DBMS_OUTPUT.PUT_LINE(
        'A new employee record is being inserted.'
    );

END;
/