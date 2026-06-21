CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id NUMBER,
    p_percentage NUMBER
) AS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count FROM Employees WHERE EmployeeID = p_employee_id;
    IF v_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee ID ' || p_employee_id || ' not found.');
    END IF;
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for Employee ID: ' || p_employee_id);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

BEGIN
    UpdateSalary(1, 10);
    UpdateSalary(99, 10);
END;
/
-- Output : Salary updated for Employee ID: 1 Error: ORA-20002: Employee ID 99 not found.