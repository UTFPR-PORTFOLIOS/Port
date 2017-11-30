package br.edu.utfpr.webapp.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.webapp.vraptor.dao.PessoaDAO;
import br.edu.utfpr.webapp.vraptor.interceptor.Public;
import br.edu.utfpr.webapp.vraptor.interceptor.UserInfo;
import br.edu.utfpr.webapp.vraptor.model.Person;
import br.edu.utfpr.webapp.vraptor.validation.LoginAvailable;
import javax.validation.Valid;

@Controller
public class UsuarioController {

    private final Result result;
    private final Validator validator;
    private final UserInfo userInfo;
    private final PessoaDAO pessoaDAO;

    /**
     * @deprecated CDI eyes only
     */
    protected UsuarioController() {
        this(null, null, null, null);
    }

    /**
     * You can receive any dependency on constructor. If VRaptor knows all
     * dependencies, this class will be created with no problem. You can use as
     * dependencies: - all VRaptor components, e.g {@link Result} and
     * {@link Validator} - all of your CDI classes, e.g {@link DefaultUserDao}
     */
    @Inject
    public UsuarioController(PessoaDAO pessoaDAO, UserInfo userInfo, Result result, Validator validator) {
        this.pessoaDAO = pessoaDAO;
        this.result = result;
        this.validator = validator;
        this.userInfo = userInfo;
    }

    /**
     * Accepts HTTP POST requests.
     *
     * URL:	/users View: /WEB-INF/jsp/user/add.jsp
     *
     * The "user" parameter will be populated with the request parameters, for
     * example:
     *
     * POST	/user user.name=Nico user.login=555555
     *
     * automatically populates the name and login parameters on the user object
     * with values Nico and 555555.
     *
     * Adds new users to the database.
     *
     * @param person
     */
    @Path("/usuario")
    @Post
    @Public
    public void add(@Valid @LoginAvailable Person person) {
        validator.onErrorUsePageOf(HomeController.class).login();

        pessoaDAO.save(person);

        // you can add objects to result even in redirects. Added objects will
        // survive one more request when redirecting.
        result.include("notice", "Person " + person.getLogin() + " successfully added");
        result.redirectTo(HomeController.class).login();
    }
}
