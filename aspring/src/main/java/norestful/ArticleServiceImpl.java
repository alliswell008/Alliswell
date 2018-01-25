package norestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

/**
 * @author AAA
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Long saveArticle(@RequestBody Article article) {
        return articleMapper.insertArticle(article);
    }

    @Override
    public List<Article> getArticles(String title, Long userId, int offset, int pageSize) {
        Article article = new Article();
        article.setTitle(title);
        article.setUserId(userId);
        return articleMapper.queryArticlesByPage(article,offset,pageSize);
    }

    @Override
    public Article getById(Long id) {
        return articleMapper.queryById(id);
    }

    @Override
    public void updateArticle(Article article) {
        article.setUpdateTime(new Date());
        articleMapper.updateArticleById(article);
    }
}
