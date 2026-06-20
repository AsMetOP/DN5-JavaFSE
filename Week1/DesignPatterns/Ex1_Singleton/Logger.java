public class Logger {
    private static Logger instance;
    private int logCount;

    private Logger() {
        logCount = 0;
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String msg) {
        logCount++;
        System.out.println("[LOG " + logCount + "] " + msg);
    }
}