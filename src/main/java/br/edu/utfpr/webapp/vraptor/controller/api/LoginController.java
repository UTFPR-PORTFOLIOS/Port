package br.edu.utfpr.webapp.vraptor.controller.api;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.utfpr.webapp.vraptor.dao.PessoaDAO;
import br.edu.utfpr.webapp.vraptor.dao.PessoaDAO;
import br.edu.utfpr.webapp.vraptor.interceptor.Public;
import br.edu.utfpr.webapp.vraptor.model.Pessoa;
import br.edu.utfpr.webapp.vraptor.security.JWTUtil;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@Controller
@Path("/api/auth")
public class LoginController {

    @Inject
    private PessoaDAO pessoaDAO;

    @Inject
    private Result result;
    @Public
    @Consumes(value = "application/json")
    @Post(value = {"/", ""})
    public void login(String login, String password) {
        System.out.println("LOGIN: " + login);
        Pessoa p = pessoaDAO.find(login, password);
        if (p == null) {
            result.use(Results.status()).notAcceptable();
        } else {
            String token = JWTUtil.createToken(p.getId());
            result.use(Results.json())
                    .withoutRoot()
                    .from(token)
                    .serialize();
        }
    }

}
