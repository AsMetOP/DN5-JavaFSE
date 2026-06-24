import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLogging {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLogging.class);

    public static void main(String[] args) {
        logger.debug("Debug message from Asmet Ranjan Sahoo");
        logger.info("Info message - application started");
        logger.warn("Warning - Keshi Jain account balance low");
        logger.error("Error - transaction failed for Aryan Samantray");
    }
}