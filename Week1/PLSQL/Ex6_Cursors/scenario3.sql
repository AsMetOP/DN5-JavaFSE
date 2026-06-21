DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, LoanAmount, InterestRate FROM Loans;
    v_new_rate NUMBER;
BEGIN
    FOR rec IN UpdateLoanInterestRates LOOP
        IF rec.LoanAmount > 5000 THEN
            v_new_rate := rec.InterestRate + 0.5;
        ELSE
            v_new_rate := rec.InterestRate - 0.5;
        END IF;
        UPDATE Loans SET InterestRate = v_new_rate WHERE LoanID = rec.LoanID;
        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || rec.LoanID || ' | New Rate: ' || v_new_rate || '%');
    END LOOP;
    COMMIT;
END;
/

-- Output : Loan ID: 1 | New Rate: 4.5%
--          Loan ID: 2 | New Rate: 6.5%