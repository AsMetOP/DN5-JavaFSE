CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE,
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

CREATE TABLE AuditLog (
    LogID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    LogDate DATE
);

CREATE SEQUENCE auditlog_seq START WITH 1 INCREMENT BY 1;

-- Sample Data
INSERT INTO Customers VALUES (1, 'Asmet Ranjan Sahoo', TO_DATE('2004-08-15', 'YYYY-MM-DD'), 1000, SYSDATE, 'FALSE');
INSERT INTO Customers VALUES (2, 'Keshi Jain', TO_DATE('2003-11-22', 'YYYY-MM-DD'), 15000, SYSDATE, 'FALSE');
INSERT INTO Customers VALUES (3, 'Aryan Samantray', TO_DATE('1955-03-10', 'YYYY-MM-DD'), 8000, SYSDATE, 'FALSE');

INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 15000, SYSDATE);
INSERT INTO Accounts VALUES (3, 3, 'Savings', 8000, SYSDATE);

INSERT INTO Transactions VALUES (1, 1, SYSDATE, 200, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));
INSERT INTO Loans VALUES (2, 3, 8000, 7, SYSDATE, SYSDATE + 15);

INSERT INTO Employees VALUES (1, 'Asmet Ranjan Sahoo', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Keshi Jain', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

COMMIT;