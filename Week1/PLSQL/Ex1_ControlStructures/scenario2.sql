BEGIN
    FOR rec IN (SELECT CustomerID, Name, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
            DBMS_OUTPUT.PUT_LINE(rec.Name || ' marked as VIP | Balance: ' || rec.Balance);
        END IF;
    END LOOP;
    COMMIT;
END;
/
-- Output : Keshi Jain marked as VIP | Balance: 15000