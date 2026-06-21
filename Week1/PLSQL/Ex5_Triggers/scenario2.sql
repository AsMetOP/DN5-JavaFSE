CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (LogID, TransactionID, AccountID, Amount, TransactionType, LogDate)
    VALUES (auditlog_seq.NEXTVAL, :NEW.TransactionID, :NEW.AccountID, :NEW.Amount, :NEW.TransactionType, SYSDATE);
END;
/

INSERT INTO Transactions VALUES (3, 1, SYSDATE, 500, 'Deposit');
SELECT * FROM AuditLog;