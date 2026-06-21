CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all savings accounts.');
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/
--Output : Monthly interest of 1% applied to all savings accounts.