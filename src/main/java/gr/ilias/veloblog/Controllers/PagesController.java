package gr.ilias.veloblog.Controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import gr.ilias.veloblog.Models.Page;
import gr.ilias.veloblog.Services.PageService;

@Controller
public class PagesController {
    @Inject
    private PageService service;

    @Inject
    private Result result;

    @Get("/admin/pages")
    public void pages() {
        result.include("pages", service.findAll());
    }

    @Get("/admin/pages/create")
    public void create() {
        result.include("");
    }

    @Post("/admin/pages/store")
    public void store(Page page) {
        service.persist(page);
        result.redirectTo(this).pages();
    }

    @Get("/admin/pages/edit/{page.id}")
    public void edit(Page page) {
        result.include("page", service.getPage(page.getId()));
    }

    @Put("/admin/pages/update")
    public void update(Page page) {
        service.persist(page);
        result.redirectTo(this).pages();
    }

    @Delete("/admin/pages/delete/{page.id}")
    public void delete(Page page) {
        service.remove(page);
        result.redirectTo(this).pages();
    }
}
