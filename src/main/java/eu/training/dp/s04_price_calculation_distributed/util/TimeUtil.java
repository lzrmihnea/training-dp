package eu.training.dp.s04_price_calculation_distributed.util;

import static java.lang.Math.round;

public class TimeUtil {

    public static void sleep(double seconds, String reason) {
        System.out.println(reason);
        try {
            Thread.sleep(round(1000 * seconds));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sleepPrio(double seconds, String reason) {
        System.err.println(reason);
        try {
            Thread.sleep(round(1000 * seconds));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
