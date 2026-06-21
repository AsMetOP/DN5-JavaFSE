CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_account_id NUMBER, p_customer_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_account_id NUMBER);
    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_account_id NUMBER, p_customer_id NUMBER, p_type VARCHAR2, p_balance NUMBER) AS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_type, p_balance, SYSDATE);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Account ' || p_account_id || ' opened for Customer ID: ' || p_customer_id);
    END;

    PROCEDURE CloseAccount(p_account_id NUMBER) AS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_account_id;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Account ' || p_account_id || ' closed.');
    END;

    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER AS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_customer_id;
        RETURN NVL(v_total, 0);
    END;
END AccountOperations;
/

DECLARE
    v_total NUMBER;
BEGIN
    AccountOperations.OpenAccount(4, 2, 'Savings', 3000);
    v_total := AccountOperations.GetTotalBalance(2);
    DBMS_OUTPUT.PUT_LINE('Keshi Jain Total Balance across all accounts: ' || v_total);
    AccountOperations.CloseAccount(4);
END;
/

-- Output : Account 4 opened for Customer ID: 2
--          Keshi Jain Total Balance across all accounts: 13500
--          Account 4 closed.
