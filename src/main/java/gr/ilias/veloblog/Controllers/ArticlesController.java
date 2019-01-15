package gr.ilias.veloblog.Controllers;

import java.io.Serializable;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import gr.ilias.veloblog.Models.Article;
import gr.ilias.veloblog.Services.ArticleService;

@Controller
public class ArticlesController implements Serializable {
    @Inject
    private ArticleService service;

    @Inject
    private Result result;

    @Get("/admin/articles")
    public void articles() {
        result.include("articles", service.findAll());
    }

    @Get("/admin/articles/create")
    public void create() {
        result.include("");
    }

    @Post("/admin/articles/store")
    public void store(Article article) {
        service.persist(article);
        result.redirectTo(this).articles();
    }

    @Get("/admin/articles/edit/{article.id}")
    public void edit(Article article) {
        result.include("article", service.getArticle(article.getId()));
    }

    @Put("/admin/articles/update")
    public void update(Article article) {
        service.persist(article);
        result.redirectTo(this).articles();
    }

    @Delete("/admin/articles/delete/{article.id}")
    public void delete(Article article) {
        service.remove(article);
        result.redirectTo(this).articles();
    }
}
