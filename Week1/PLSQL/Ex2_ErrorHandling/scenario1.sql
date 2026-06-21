CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account NUMBER,
    p_to_account NUMBER,
    p_amount NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in account ' || p_from_account);
    END IF;
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer of ' || p_amount || ' successful.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

BEGIN
    SafeTransferFunds(2, 1, 1000);
    SafeTransferFunds(1, 3, 9000);
END;
/
-- Output : Transfer of 1000 successful.Transfer failed: ORA-20001: Insufficient funds in account 1