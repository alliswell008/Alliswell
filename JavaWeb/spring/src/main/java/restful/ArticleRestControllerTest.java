package restful;

import com.google.gson.Gson;
import javafx.application.Application;
import norestful.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ArticleRestControllerTest {

    @Autowired
    private ArticleRestController restController;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(restController).build();
    }

    @Test
    public void testAddArticle() throws Exception {
        Article article = new Article();
        article.setTitle("测试文章000000");
        article.setType(1);
        article.setStatus(2);
        article.setSummary("这是一篇测试文章");
        Gson gosn = new Gson();
        RequestBuilder builder = MockMvcRequestBuilders
                .post("/rest/article")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gosn.toJson(article));

        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testUpdateArticle() throws Exception {
        Article article = new Article();
        article.setTitle("更新测试文章");
        article.setType(1);
        article.setStatus(2);
        article.setSummary("这是一篇更新测试文章");
        Gson gosn = new Gson();
        RequestBuilder builder = MockMvcRequestBuilders
                .put("/rest/article/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gosn.toJson(article));
        MvcResult result = mvc.perform(builder).andReturn();
    }

    @Test
    public void testQueryArticle() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/rest/article/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testDeleteArticle() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .delete("/rest/article/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mvc.perform(builder).andReturn();
    }
}