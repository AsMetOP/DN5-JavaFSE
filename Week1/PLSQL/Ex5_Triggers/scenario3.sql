CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;
        IF v_balance < :NEW.Amount THEN
            RAISE_APPLICATION_ERROR(-20003, 'Withdrawal exceeds account balance.');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20004, 'Deposit amount must be positive.');
        END IF;
    END IF;
END;
/

BEGIN
    INSERT INTO Transactions VALUES (4, 1, SYSDATE, 300, 'Deposit');
    DBMS_OUTPUT.PUT_LINE('Valid deposit inserted.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Blocked: ' || SQLERRM);
END;
/

BEGIN
    INSERT INTO Transactions VALUES (5, 1, SYSDATE, 99999, 'Withdrawal');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Blocked: ' || SQLERRM);
END;
/