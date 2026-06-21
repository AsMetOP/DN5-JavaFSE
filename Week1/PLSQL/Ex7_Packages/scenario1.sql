CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) AS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_id || ' already exists.');
    END;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER) AS
    BEGIN
        UPDATE Customers SET Name = p_name, Balance = p_balance, LastModified = SYSDATE
        WHERE CustomerID = p_id;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_name);
    END;

    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER AS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END;
END CustomerManagement;
/

DECLARE
    v_balance NUMBER;
BEGIN
    CustomerManagement.AddCustomer(5, 'Utsah Sinha', TO_DATE('2003-07-15', 'YYYY-MM-DD'), 7000);
    CustomerManagement.UpdateCustomer(1, 'Asmet Ranjan Sahoo', 2000);
    v_balance := CustomerManagement.GetCustomerBalance(2);
    DBMS_OUTPUT.PUT_LINE('Keshi Jain Balance: ' || v_balance);
END;
/


-- Output : Customer added: Utsah Sinha
--          Customer updated: Asmet Ranjan Sahoo
--          Keshi Jain Balance: 15000

