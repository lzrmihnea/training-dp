package eu.training.dp.s04_price_calculation_distributed.service;

import eu.training.dp.s04_price_calculation_distributed.domain.Article;
import eu.training.dp.s04_price_calculation_distributed.domain.price.ArticlePrice;
import eu.training.dp.s04_price_calculation_distributed.domain.price.ArticlePriceDiscount;
import eu.training.dp.s04_price_calculation_distributed.domain.price.ArticlePriceTax;
import eu.training.dp.s04_price_calculation_distributed.repository.ArticlePriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static eu.training.dp.s04_price_calculation_distributed.util.TimeUtil.sleep;

@Service
public class ArticleMediationService {

    private final ArticlePriceApiService articlePriceApiService;
    private final ArticleEndPriceCalculationService articleEndPriceCalculationService;
    private final ArticlePriceRepository articlePriceRepository;


    public ArticleMediationService(ArticlePriceApiService articlePriceApiService, ArticleEndPriceCalculationService articleEndPriceCalculationService, ArticlePriceRepository articlePriceRepository) {
        this.articlePriceApiService = articlePriceApiService;
        this.articleEndPriceCalculationService = articleEndPriceCalculationService;
        this.articlePriceRepository = articlePriceRepository;
    }

    public void triggerPriceCalculation() {
        List<Article> articlesForGermany = this.articlePriceApiService.getArticlesForGermany();

        articlesForGermany
                .stream()
                .forEach(article -> {
                    long articleId = article.getArticleId();
                    sleep(0.1, "Starting calculation for [" + articleId + "]: " + article.getArticleName());

                    ArticlePrice articleProductionPrice = this.articlePriceRepository.getArticleProductionPrice(articleId);
                    List<ArticlePriceTax> taxesFor = this.articlePriceRepository.getTaxesFor(articleId);
                    List<ArticlePriceDiscount> discountsFor = this.articlePriceRepository.getDiscountsFor(articleId);
                    ArticlePrice endPriceFor = this.articleEndPriceCalculationService.getEndPriceFor(articleProductionPrice, taxesFor, discountsFor);

                    sleep(0.1, "End price received: " + endPriceFor);
                });
    }
}
