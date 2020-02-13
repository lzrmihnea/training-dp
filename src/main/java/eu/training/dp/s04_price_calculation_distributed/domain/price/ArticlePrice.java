package eu.training.dp.s04_price_calculation_distributed.domain.price;

import eu.training.dp.s04_price_calculation_distributed.domain.type.Country;
import eu.training.dp.s04_price_calculation_distributed.domain.type.Currency;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class ArticlePrice {
    private Country country;
    private long articleId;
    private Currency currency;
    private BigDecimal price;

    public ArticlePrice(Country country, long articleId, Currency currency, BigDecimal price) {
        this.country = country;
        this.articleId = articleId;
        this.currency = currency;
        this.price = price;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void addTax(ArticlePriceTax tax) {
        switch (tax.getModificationType()) {
            case ABS:
                this.price = this.price.add(tax.getAmount());
                return;
            case PERC:
                this.price = this.price.add(getPercentagePartOf(tax.getAmount()));
                return;
        }
    }

    public void addDiscount(ArticlePriceDiscount discount) {
        switch (discount.getModificationType()) {
            case ABS:
                this.price = this.price.min(discount.getAmount());
                return;
            case PERC:
                this.price = this.price.min(getPercentagePartOf(discount.getAmount()));
                return;
        }
    }

    private BigDecimal getPercentagePartOf(BigDecimal amount) {
        return this.price.multiply(amount.divide(valueOf(100)));
    }

    @Override
    public String toString() {
        return "ArticlePrice{" +
                "country=" + country +
                ", articleId=" + articleId +
                ", currency=" + currency +
                ", price=" + price +
                '}';
    }
}
