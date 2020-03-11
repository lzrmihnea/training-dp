package eu.training.dp.s04_price_calculation_distributed.service;

import eu.training.dp.s04_price_calculation_distributed.repository.ArticlePriceRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleMediationServiceTest {

    private final ArticleEndPriceCalculationService articleEndPriceCalculationService = new ArticleEndPriceCalculationService();
    private final ArticlePriceApiService articlePriceApiService = new ArticlePriceApiService();
    private final ArticlePriceRepository articlePriceRepository = new ArticlePriceRepository();
    private final ArticleMediationService articleMediationService = new ArticleMediationService(articlePriceApiService, articleEndPriceCalculationService, articlePriceRepository);
    private final Runnable articlePriceCalculationThread = new TestArticlePriceCalculationThread();

    @Test(timeout = 60_000)
    public void testPriceCalculation_expectedCalculationDoneInUnder60sec() {
        articlePriceCalculationThread.run();

        assertEquals(articlePriceApiService.getNumberOfArticles(), this.articlePriceRepository.getEndPrices().size());
    }

    @Test(timeout = 45_000)
    public void testPriceCalculation_expectedCalculationDoneInUnder45sec() {
        articlePriceCalculationThread.run();

        assertEquals(articlePriceApiService.getNumberOfArticles(), this.articlePriceRepository.getEndPrices().size());
    }

    @Test(timeout = 30_000)
    public void testPriceCalculation_expectedCalculationDoneInUnder30sec() {
        articlePriceCalculationThread.run();

        assertEquals(articlePriceApiService.getNumberOfArticles(), this.articlePriceRepository.getEndPrices().size());
    }

    @Test(timeout = 15_000)
    public void testPriceCalculation_expectedCalculationDoneInUnder15sec() {
        articlePriceCalculationThread.run();

        assertEquals(articlePriceApiService.getNumberOfArticles(), this.articlePriceRepository.getEndPrices().size());
    }

    class TestArticlePriceCalculationThread implements Runnable {
        @Override
        public void run() {
            articleMediationService.triggerPriceCalculation();
        }
    }

}
