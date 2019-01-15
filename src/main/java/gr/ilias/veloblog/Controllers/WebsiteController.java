package gr.ilias.veloblog.Controllers;

import java.io.Serializable;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import gr.ilias.veloblog.Services.ArticleService;
import gr.ilias.veloblog.Services.PageService;

@Controller
public class WebsiteController implements Serializable {
    @Inject
    private PageService pageService;

    @Inject
    private ArticleService articleService;

    @Inject
    private Result result;

    @Get("/")
    public void index() {
        result.include("menuPages", pageService.findAll());
        result.include("articles", articleService.findAll());
    }

    @Get
    @Path("/pages/{slug}")
    public void page(String slug) {
        System.out.println(slug);
        result.include("page", pageService.getPageBySlug(slug));
        result.include("menuPages", pageService.findAll());
    }

    @Get
    @Path("/articles/{slug}")
    public void article(String slug) {
        result.include("article", articleService.getArticleBySlug(slug));
        result.include("menuPages", pageService.findAll());
    }
}
