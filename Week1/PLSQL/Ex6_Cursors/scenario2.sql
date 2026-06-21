DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance FROM Accounts;
    v_fee NUMBER := 500;
BEGIN
    FOR rec IN ApplyAnnualFee LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee, LastModified = SYSDATE
        WHERE AccountID = rec.AccountID;
        DBMS_OUTPUT.PUT_LINE('Annual fee deducted from Account ID: ' || rec.AccountID || ' | New Balance: ' || (rec.Balance - v_fee));
    END LOOP;
    COMMIT;
END;
/

--Output : Annual fee deducted from Account ID: 1 | New Balance: 4530
--         Annual fee deducted from Account ID: 2 | New Balance: 10500
--         Annual fee deducted from Account ID: 3 | New Balance: 7580