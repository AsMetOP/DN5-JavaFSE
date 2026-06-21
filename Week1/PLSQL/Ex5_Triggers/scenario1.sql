CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

UPDATE Customers SET Balance = 1200 WHERE CustomerID = 1;
SELECT Name, Balance, LastModified FROM Customers WHERE CustomerID = 1;