public class ExceptionThrower {
    public void throwException() {
        throw new IllegalArgumentException("This is an exception");
    }

    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}