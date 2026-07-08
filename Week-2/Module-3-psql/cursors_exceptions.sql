SET SERVEROUTPUT ON;

--------------------------------------------------
-- Explicit Cursor Example
--------------------------------------------------

DECLARE

CURSOR emp_cursor IS
SELECT employee_id, first_name, salary
FROM employees;

v_emp_id employees.employee_id%TYPE;
    v_name employees.first_name%TYPE;
    v_salary employees.salary%TYPE;

BEGIN

OPEN emp_cursor;

LOOP

FETCH emp_cursor
        INTO v_emp_id, v_name, v_salary;

        EXIT WHEN emp_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            v_emp_id || ' | ' ||
            v_name || ' | ' ||
            v_salary
        );

END LOOP;

CLOSE emp_cursor;

END;
/

--------------------------------------------------
-- User Defined Exception
--------------------------------------------------

DECLARE

salary NUMBER := 25000;

    low_salary EXCEPTION;

BEGIN

    IF salary < 30000 THEN
        RAISE low_salary;
END IF;

    DBMS_OUTPUT.PUT_LINE('Salary is acceptable.');

EXCEPTION

    WHEN low_salary THEN
        DBMS_OUTPUT.PUT_LINE('Salary is below minimum requirement.');

END;
/