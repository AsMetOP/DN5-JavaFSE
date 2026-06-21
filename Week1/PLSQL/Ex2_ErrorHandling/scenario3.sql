CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_id NUMBER,
    p_name VARCHAR2,
    p_dob DATE,
    p_balance NUMBER
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer ' || p_name || ' added successfully.');
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_id || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

BEGIN
    AddNewCustomer(4, 'Krish Agrawal', TO_DATE('2002-05-10', 'YYYY-MM-DD'), 5000);
    AddNewCustomer(1, 'Duplicate Test', SYSDATE, 1000);
END;
/
-- Output : Customer Krish Agrawal added successfully.
-- Error: Customer with ID 1 already exists.