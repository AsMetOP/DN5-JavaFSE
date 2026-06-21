CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount NUMBER,
    p_interest_rate NUMBER,
    p_years NUMBER
) RETURN NUMBER AS
    v_monthly_rate NUMBER;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate / 12 / 100;
    v_months := p_years * 12;
    v_emi := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)
             / (POWER(1 + v_monthly_rate, v_months) - 1);
    RETURN ROUND(v_emi, 2);
END;
/

DECLARE
    v_emi NUMBER;
BEGIN
    v_emi := CalculateMonthlyInstallment(5000, 5, 5);
    DBMS_OUTPUT.PUT_LINE('Monthly Installment for Asmet Ranjan Sahoo Loan: ' || v_emi);
    v_emi := CalculateMonthlyInstallment(8000, 7, 5);
    DBMS_OUTPUT.PUT_LINE('Monthly Installment for Aryan Samantray Loan: ' || v_emi);
END;
/
-- Output : Monthly Installment for Asmet Ranjan Sahoo Loan: 94.36
--          Monthly Installment for Aryan Samantray Loan: 158.32