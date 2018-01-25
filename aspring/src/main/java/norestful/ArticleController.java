package norestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author AAA
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/list.json")
    @ResponseBody
    public List<Article> listArticles(String title, Integer pageSize, Integer pageNum) {
        if (pageSize == null) {
            pageSize = 10;
        }
        if (pageNum == null) {
            pageNum = 1;
        }
        int offset = (pageNum - 1) * pageSize;
        return articleService.getArticles(title, 1L, offset, pageSize);
    }
}
