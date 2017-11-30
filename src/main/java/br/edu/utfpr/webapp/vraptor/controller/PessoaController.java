package br.edu.utfpr.webapp.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.webapp.vraptor.dao.PessoaDAO;
import br.edu.utfpr.webapp.vraptor.model.Person;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class PessoaController {

    private final Result result;
    private final Validator validator;
    private final PessoaDAO pessoaDAO;

    /**
     * @deprecated CDI eyes only
     */
    protected PessoaController() {
        this(null, null, null);
    }

    @Inject
    public PessoaController(PessoaDAO pessoaDAO, Result result, Validator validator) {
        this.pessoaDAO = pessoaDAO;
        this.result = result;
        this.validator = validator;
    }

    @Get
    public List<Person> list() {
        return pessoaDAO.findAll();
    }

    @Get
    public Person form(int id) {
        return pessoaDAO.getById(id);
    }

    @Post
    public Person form(Person person) {
        return person;
    }

    @IncludeParameters
    public void save(@NotNull @Valid Person person) {
        //if(person.getNome() == null || person.getNome().trim().equals(""))
        //validator.add(new SimpleMessage("nome", "O nome deve ser preenchido"));
        validator.onErrorForwardTo(this).form(person);

        if (person.getId() > 0) {
            pessoaDAO.update(person);
        } else {
            pessoaDAO.save(person);
        }

        // Redireciona para a página de listagem
        result.redirectTo(PessoaController.class).list();
    }

    public void delete(int id) {
        result.forwardTo(PessoaController.class).list();
    }
}
