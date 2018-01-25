package norestful;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 *
 * @author AAA
 */
public interface ArticleService {

    /**
     * 保存
     * @param article
     * @return
     */
    Long saveArticle(@RequestBody Article article);

    /**
     * 查询
     * @param title
     * @param userId
     * @param offset
     * @param pageSize
     * @return
     */
    List<Article> getArticles(String title, Long userId, int offset, int pageSize);

    /**
     * 查询
     * @param id
     * @return
     */
    Article getById(Long id);

    /**
     * 修改
     * @param article
     */
    void updateArticle(Article article);
}
