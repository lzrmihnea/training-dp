package eu.training.dp.s04_price_calculation_distributed.util;

import java.math.BigDecimal;

public class RandomPriceUtil {
    public static BigDecimal getValueWithRandom(BigDecimal base, int maxRandomnessVariation) {
        return base.add(BigDecimal.valueOf(Math.random() * maxRandomnessVariation));
    }
}
