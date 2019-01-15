package gr.ilias.veloblog.Controllers;

import java.io.Serializable;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class AdminController implements Serializable {
    @Inject
    private Result result;

    @Get("/admin")
    public void index() {
        result.include("test", "test");
    }
}
