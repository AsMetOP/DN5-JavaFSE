BEGIN
    FOR rec IN (
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name || ', your loan (ID: ' || rec.LoanID || ') is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY') || '. Please arrange payment.');
    END LOOP;
END;
/