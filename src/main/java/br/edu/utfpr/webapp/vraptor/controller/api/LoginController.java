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
import br.edu.utfpr.webapp.vraptor.model.Pessoa;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@Controller
@Path("/api/auth")
public class LoginController {

    @Inject
    private PessoaDAO pessoaDAO;
    //private PessoaDAO pessoaDAO;

    @Inject
    private Result result;

    @Consumes(value = "application/json")
    @Post(value = {"/", ""})
    public void login(String login, String password) {
        try {
            Pessoa p = pessoaDAO.find(login, password);

            result.nothing();
            result.use(Results.json())
                    .withoutRoot()
                    .from(p)
                    .exclude("password")
                    .serialize();
            //devolver token com o jwt
        } catch (Exception e) {
            e.printStackTrace();
            result.notFound();
        }
    }


}
