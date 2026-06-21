CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER AS
BEGIN
    RETURN TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
END;
/

DECLARE
    v_age NUMBER;
BEGIN
    v_age := CalculateAge(TO_DATE('2004-08-15', 'YYYY-MM-DD'));
    DBMS_OUTPUT.PUT_LINE('Asmet Ranjan Sahoo Age: ' || v_age);
    v_age := CalculateAge(TO_DATE('1955-03-10', 'YYYY-MM-DD'));
    DBMS_OUTPUT.PUT_LINE('Aryan Samantray Age: ' || v_age);
END;
/
-- Output : Asmet Ranjan Sahoo Age: 21
--             Aryan Samantray Age: 71