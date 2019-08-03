package restful;

import norestful.Article;
import norestful.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/rest")
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/article", method = POST, produces = "application/json")
	public WebResponse<Map<String, Object>> saveArticle(@RequestBody Article article) {
		article.setUserId(1L);
		articleService.saveArticle(article);
		Map<String, Object> ret = new HashMap<>();
		ret.put("id", article.getId());
		WebResponse<Map<String, Object>> response = WebResponse.getSuccessResponse(ret);
		return response;
	}

	@RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
	public WebResponse<?> deleteArticle(@PathVariable Long id) {
		Article article = articleService.getById(id);
		article.setStatus(-1);
		articleService.updateArticle(article);
		WebResponse<Object> response = WebResponse.getSuccessResponse(null);
		return response;
	}

	@RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
	public WebResponse<Object> updateArticle(@PathVariable Long id, @RequestBody Article article) {
		article.setId(id);
		articleService.updateArticle(article);
		WebResponse<Object> response = WebResponse.getSuccessResponse(null);
		return response;
	}

	@RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
	public WebResponse<Article> getArticle(@PathVariable Long id) {
		Article article = articleService.getById(id);
		WebResponse<Article> response = WebResponse.getSuccessResponse(article);
		return response;
	}
}
