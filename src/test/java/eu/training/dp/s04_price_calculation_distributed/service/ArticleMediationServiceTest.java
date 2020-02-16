package eu.training.dp.s04_price_calculation_distributed.service;

import eu.training.dp.s04_price_calculation_distributed.repository.ArticlePriceRepository;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArticleMediationServiceTest {

    private static long ELAPSED_TIME;

    @BeforeClass
    public static void setupOnce() {
        ArticleEndPriceCalculationService articleEndPriceCalculationService = new ArticleEndPriceCalculationService();
        ArticlePriceApiService articlePriceApiService = new ArticlePriceApiService();
        ArticlePriceRepository articlePriceRepository = new ArticlePriceRepository();
        ArticleMediationService articleMediationService = new ArticleMediationService(articlePriceApiService, articleEndPriceCalculationService, articlePriceRepository);

        long currentTimeMillis = System.currentTimeMillis();
        articleMediationService.triggerPriceCalculation();
        long currentTimeMillis2 = System.currentTimeMillis();
        ELAPSED_TIME = Math.round((currentTimeMillis2 - currentTimeMillis) / 1000);
        System.out.println("Elapsed time for calculation: " + ELAPSED_TIME + " seconds.");
    }

    @Test
    public void testPriceCalculation_expectedCalculationDoneInUnder60sec() {
        assertTrue(ELAPSED_TIME < 60);
    }

    @Test
    public void testPriceCalculation_expectedCalculationDoneInUnder45sec() {
        assertTrue(ELAPSED_TIME < 45);
    }

    @Test
    public void testPriceCalculation_expectedCalculationDoneInUnder30sec() {
        assertTrue(ELAPSED_TIME < 30);
    }

    @Test
    public void testPriceCalculation_expectedCalculationDoneInUnder15sec() {
        assertTrue(ELAPSED_TIME < 15);
    }

}
