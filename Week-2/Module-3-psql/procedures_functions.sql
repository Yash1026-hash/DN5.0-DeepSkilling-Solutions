SET SERVEROUTPUT ON;

--------------------------------------------------
-- Stored Procedure
--------------------------------------------------

CREATE OR REPLACE PROCEDURE update_salary(
    p_emp_id IN NUMBER,
    p_increment IN NUMBER
)
AS
BEGIN
UPDATE employees
SET salary = salary + p_increment
WHERE employee_id = p_emp_id;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
END;
/

--------------------------------------------------
-- Execute Procedure
--------------------------------------------------

BEGIN
    update_salary(101, 5000);
END;
/

--------------------------------------------------
-- Stored Function
--------------------------------------------------

CREATE OR REPLACE FUNCTION get_annual_salary(
    p_emp_id IN NUMBER
)
RETURN NUMBER
AS
    v_salary NUMBER;
BEGIN
SELECT salary
INTO v_salary
FROM employees
WHERE employee_id = p_emp_id;

RETURN v_salary * 12;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;
/

--------------------------------------------------
-- Execute Function
--------------------------------------------------

DECLARE
annual_salary NUMBER;
BEGIN
    annual_salary := get_annual_salary(101);

    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || annual_salary);
END;
/