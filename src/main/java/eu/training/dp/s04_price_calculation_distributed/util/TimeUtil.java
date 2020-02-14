package eu.training.dp.s04_price_calculation_distributed.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.round;

public class TimeUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger("");

    public static void sleep(double seconds, String reason) {
        LOGGER.info(reason);
        try {
            Thread.sleep(round(1000 * seconds));
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
