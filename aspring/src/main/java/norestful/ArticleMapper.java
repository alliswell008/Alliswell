package norestful;

import java.util.List;

/**
 * @author AAA
 */
public interface ArticleMapper {

    Long insertArticle(Article article);

    List<Article> queryArticlesByPage(Article article, int offset, int pageSize);

    Article queryById(Long id);

    void updateArticleById(Article article);
}
