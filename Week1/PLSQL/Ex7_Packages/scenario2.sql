CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2);
    PROCEDURE UpdateEmployee(p_id NUMBER, p_position VARCHAR2, p_salary NUMBER);
    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2) AS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_id, p_name, p_position, p_salary, p_dept, SYSDATE);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
    END;

    PROCEDURE UpdateEmployee(p_id NUMBER, p_position VARCHAR2, p_salary NUMBER) AS
    BEGIN
        UPDATE Employees SET Position = p_position, Salary = p_salary WHERE EmployeeID = p_id;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee updated: ID ' || p_id);
    END;

    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER AS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END;
END EmployeeManagement;
/

DECLARE
    v_annual NUMBER;
BEGIN
    EmployeeManagement.HireEmployee(3, 'Shreya Patro', 'Analyst', 55000, 'Finance');
    EmployeeManagement.UpdateEmployee(2, 'Senior Developer', 75000);
    v_annual := EmployeeManagement.CalculateAnnualSalary(1);
    DBMS_OUTPUT.PUT_LINE('Asmet Ranjan Sahoo Annual Salary: ' || v_annual);
END;
/

-- Output : Employee hired: Shreya Patro
--          Employee updated: ID 2
--          Asmet Ranjan Sahoo Annual Salary: 924000

