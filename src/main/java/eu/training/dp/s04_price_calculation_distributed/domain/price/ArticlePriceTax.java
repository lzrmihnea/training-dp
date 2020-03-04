package eu.training.dp.s04_price_calculation_distributed.domain.price;

import eu.training.dp.s04_price_calculation_distributed.domain.base.ArticlePriceModification;
import eu.training.dp.s04_price_calculation_distributed.domain.type.Country;
import eu.training.dp.s04_price_calculation_distributed.domain.type.PriceModificationType;

import java.math.BigDecimal;

public class ArticlePriceTax extends ArticlePriceModification {
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ArticlePriceTax(long articleId, BigDecimal amount, PriceModificationType modificationType, String name, int position, Country country) {
        super(articleId, amount, modificationType, name, position);
        this.country = country;
    }

    @Override
    public String toString() {
        return "ArticlePriceTax{" +
                "country=" + country +
                ", articleId=" + articleId +
                ", amount=" + amount +
                ", modificationType=" + modificationType +
                ", name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
