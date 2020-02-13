package eu.training.dp.s04_price_calculation_distributed.domain;

public class Article {
    private long articleId;
    private String articleName;

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Article(long articleId, String articleName) {
        this.articleId = articleId;
        this.articleName = articleName;
    }
}
