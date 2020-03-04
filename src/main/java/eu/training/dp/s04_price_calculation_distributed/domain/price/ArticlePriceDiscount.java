package eu.training.dp.s04_price_calculation_distributed.domain.price;

import eu.training.dp.s04_price_calculation_distributed.domain.base.ArticlePriceModification;
import eu.training.dp.s04_price_calculation_distributed.domain.type.PriceModificationType;

import java.math.BigDecimal;

public class ArticlePriceDiscount extends ArticlePriceModification {
    private long storeId;

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }


    public ArticlePriceDiscount(long articleId, BigDecimal amount, PriceModificationType modificationType, String name, int position, long storeId) {
        super(articleId, amount, modificationType, name, position);
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "ArticlePriceDiscount{" +
                "storeId=" + storeId +
                ", articleId=" + articleId +
                ", amount=" + amount +
                ", modificationType=" + modificationType +
                ", name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
