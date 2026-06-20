public class LoggerTest {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        log1.log("App started");

        Logger log2 = Logger.getInstance();
        log2.log("Fetching data from db");

        if (log1 == log2) {
            System.out.println("log1 and log2 are the same instance");
        } else {
            System.out.println("log1 and log2 are different instances");
        }
    }
}
