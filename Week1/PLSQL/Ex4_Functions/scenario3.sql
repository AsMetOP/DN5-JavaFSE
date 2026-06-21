CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id NUMBER,
    p_amount NUMBER
) RETURN BOOLEAN AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/

BEGIN
    IF HasSufficientBalance(2, 5000) THEN
        DBMS_OUTPUT.PUT_LINE('Keshi Jain has sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Keshi Jain does not have sufficient balance.');
    END IF;

    IF HasSufficientBalance(1, 5000) THEN
        DBMS_OUTPUT.PUT_LINE('Asmet Ranjan Sahoo has sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Asmet Ranjan Sahoo does not have sufficient balance.');
    END IF;
END;
/

-- Output : Keshi Jain has sufficient balance.
--          Asmet Ranjan Sahoo does not have sufficient balance.