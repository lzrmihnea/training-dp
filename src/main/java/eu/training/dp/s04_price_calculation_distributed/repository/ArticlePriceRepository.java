package eu.training.dp.s04_price_calculation_distributed.repository;

import eu.training.dp.s04_price_calculation_distributed.domain.price.ArticlePrice;
import eu.training.dp.s04_price_calculation_distributed.domain.price.ArticlePriceDiscount;
import eu.training.dp.s04_price_calculation_distributed.domain.price.ArticlePriceTax;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import static eu.training.dp.s04_price_calculation_distributed.util.RandomPriceUtil.getValueWithRandom;
import static eu.training.dp.s04_price_calculation_distributed.util.TimeUtil.sleep;
import static eu.training.dp.s04_price_calculation_distributed.domain.type.Country.DE;
import static eu.training.dp.s04_price_calculation_distributed.domain.type.Currency.EUR;
import static eu.training.dp.s04_price_calculation_distributed.domain.type.PriceModificationType.ABS;
import static eu.training.dp.s04_price_calculation_distributed.domain.type.PriceModificationType.PERC;
import static java.lang.Math.random;
import static java.math.BigDecimal.*;
import static java.util.Arrays.asList;

@Repository
public class ArticlePriceRepository {

    public ArticlePrice getArticleProductionPrice(long articleId) {
        sleep(0.5, "Getting production price for [" + articleId + "]");
        return new ArticlePrice(DE, articleId, EUR, valueOf(random() * 1000));
    }

    public List<ArticlePriceDiscount> getDiscountsFor(long articleId) {
        sleep(1, "Getting discounts for [" + articleId + "]");
        return asList(
                new ArticlePriceDiscount(articleId, getValueWithRandom(TEN, 10), PERC, "Summer discount", 0, 0),
                new ArticlePriceDiscount(articleId, getValueWithRandom(ONE, 25), ABS, "Monthly discount", 1, 0));
    }

    public List<ArticlePriceTax> getTaxesFor(long articleId) {
        sleep(1, "Getting taxes for [" + articleId + "]");
        return asList(
                new ArticlePriceTax(articleId, getValueWithRandom(BigDecimal.valueOf(20), 5), PERC, "VAT", 0, DE),
                new ArticlePriceTax(articleId, getValueWithRandom(ONE, 2), ABS, "Regional tax", 1, DE),
                new ArticlePriceTax(articleId, getValueWithRandom(ONE, 2), ABS, "Transport tax", 2, DE),
                new ArticlePriceTax(articleId, getValueWithRandom(TEN, 2), PERC, "Profit tax", 3, DE));
    }
}
