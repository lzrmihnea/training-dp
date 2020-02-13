package eu.training.dp.s04_price_calculation_distributed.service;

import eu.training.dp.s04_price_calculation_distributed.repository.ArticlePriceRepository;
import org.junit.Before;
import org.junit.Test;

public class ArticleMediationServiceTest {

    private ArticleEndPriceCalculationService articleEndPriceCalculationService;
    private ArticlePriceApiService articlePriceApiService;
    private ArticleMediationService articleMediationService;
    private ArticlePriceRepository articlePriceRepository;

    @Before
    public void setup() {
        articleEndPriceCalculationService = new ArticleEndPriceCalculationService();
        articlePriceApiService = new ArticlePriceApiService();
        articlePriceRepository = new ArticlePriceRepository();
        articleMediationService = new ArticleMediationService(articlePriceApiService, articleEndPriceCalculationService, articlePriceRepository);
    }

    @Test
    public void testPriceCalculation() {
        this.articleMediationService.triggerPriceCalculation();
    }

}
