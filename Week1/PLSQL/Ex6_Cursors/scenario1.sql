DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.Name, t.TransactionID, t.Amount, t.TransactionType, t.TransactionDate
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
BEGIN
    FOR rec IN GenerateMonthlyStatements LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' | TxnID: ' || rec.TransactionID || ' | Type: ' || rec.TransactionType || ' | Amount: ' || rec.Amount || ' | Date: ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/

-- Output : Customer: Asmet Ranjan Sahoo | TxnID: 4 | Type: Deposit | Amount: 300 | Date: 21-JUN-2026
--          Customer: Asmet Ranjan Sahoo | TxnID: 1 | Type: Deposit | Amount: 200 | Date: 20-JUN-2026
--          Customer: Asmet Ranjan Sahoo | TxnID: 3 | Type: Deposit | Amount: 500 | Date: 21-JUN-2026
--          Customer: Keshi Jain | TxnID: 2 | Type: Withdrawal | Amount: 300 | Date: 20-JUN-2026

