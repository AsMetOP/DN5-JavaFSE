import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String user = "Asmet Ranjan Sahoo";
        int age = 21;
        double balance = 15000.50;

        logger.info("User: {}", user);
        logger.info("User: {} is {} years old", user, age);
        logger.debug("Account balance for {}: {}", user, balance);
        logger.warn("Low balance warning for user: {}", user);
        logger.error("Transaction failed for user: {} with balance: {}", user, balance);
    }
}