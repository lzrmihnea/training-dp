package eu.training.dp.s04_price_calculation_distributed.domain.base;

import eu.training.dp.s04_price_calculation_distributed.domain.type.PriceModificationType;

import java.math.BigDecimal;

public abstract class ArticlePriceModification {

    protected long articleId;
    protected BigDecimal amount;
    protected PriceModificationType modificationType;
    protected String name;
    protected int position;

    public ArticlePriceModification(long articleId, BigDecimal amount, PriceModificationType modificationType, String name, int position) {
        this.articleId = articleId;
        this.amount = amount;
        this.modificationType = modificationType;
        this.name = name;
        this.position = position;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PriceModificationType getModificationType() {
        return modificationType;
    }

    public void setModificationType(PriceModificationType modificationType) {
        this.modificationType = modificationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
