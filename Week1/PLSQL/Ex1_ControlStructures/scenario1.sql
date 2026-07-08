DECLARE
    CURSOR c_loans IS
        SELECT c.CustomerID, c.Name, c.DOB, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;
    v_age NUMBER;
BEGIN
    FOR rec IN c_loans LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
            DBMS_OUTPUT.PUT_LINE('Discount applied for: ' || rec.Name || ' | New Rate: ' || (rec.InterestRate - 1) || '%');
        END IF;
    END LOOP;
    COMMIT;
END;
/
-- Output : Discount applied for: Aryan Samantray | New Rate: 6%