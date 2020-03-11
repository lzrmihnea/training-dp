package eu.training.dp.s04_price_calculation_distributed.service;

import eu.training.dp.s04_price_calculation_distributed.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;

import static eu.training.dp.s04_price_calculation_distributed.util.TimeUtil.sleep;
import static java.util.Arrays.asList;

@Service
public class ArticlePriceApiService {

    private static final List<Article> ARTICLES = asList(
            new Article(1L, "Stereo"),
            new Article(2L, "Telephone"),
            new Article(3L, "TV"),
            new Article(4L, "Monitor"),
            new Article(5L, "Laptop"),
            new Article(6L, "Radio"),
            new Article(7L, "Car"),
            new Article(8L, "Bike"),
            new Article(9L, "Whisky"),
            new Article(10L, "Steak"));

    public List<Article> getArticlesForGermany() {
        sleep(1, "Getting articles for Germany ");
        return ARTICLES;
    }

    public int getNumberOfArticles() {
        return ARTICLES.size();
    }

}
