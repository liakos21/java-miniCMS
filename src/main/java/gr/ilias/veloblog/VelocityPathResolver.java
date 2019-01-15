package gr.ilias.veloblog;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.view.DefaultPathResolver;

@Specializes
public class VelocityPathResolver extends DefaultPathResolver {

    protected VelocityPathResolver() {
        this(null);
    }

    @Inject
    public VelocityPathResolver(FormatResolver resolver) {
       super(resolver);
    }

    protected String getPrefix() {
        return "/WEB-INF/vm/";
    }

    protected String getExtension() {
        return "vm";
    }
}
