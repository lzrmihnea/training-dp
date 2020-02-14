package eu.training.dp.s04_price_calculation_distributed.service;

import eu.training.dp.s04_price_calculation_distributed.domain.price.ArticlePrice;
import eu.training.dp.s04_price_calculation_distributed.domain.price.ArticlePriceDiscount;
import eu.training.dp.s04_price_calculation_distributed.domain.price.ArticlePriceTax;
import org.springframework.stereotype.Service;

import java.util.List;

import static eu.training.dp.s04_price_calculation_distributed.util.TimeUtil.sleep;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

@Service
public class ArticleEndPriceCalculationService {

    public ArticlePrice getEndPriceFor(ArticlePrice aPrice, List<ArticlePriceTax> taxes, List<ArticlePriceDiscount> discounts) {
        ArticlePrice finalPrice = new ArticlePrice(aPrice.getCountry(), aPrice.getArticleId(), aPrice.getCurrency(), aPrice.getPrice());

        sleep(1, "Computing taxes for [" + aPrice.getArticleId() + "] ");
        taxes
                .stream()
                .sorted(comparingInt(ArticlePriceTax::getPosition))
                .peek(finalPrice::addTax)
                .collect(toList());

        sleep(1, "Computing discounts for [" + aPrice.getArticleId() + "] ");
        discounts
                .stream()
                .sorted(comparingInt(ArticlePriceDiscount::getPosition))
                .peek(finalPrice::addDiscount)
                .collect(toList());

        sleep(0.5, "End price for " + aPrice.getArticleId() + " was computed as " + finalPrice.getPrice().toPlainString() + " " + finalPrice.getCurrency());
        return finalPrice;
    }
}
