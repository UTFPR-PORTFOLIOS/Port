package br.edu.utfpr.webapp.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.edu.utfpr.webapp.vraptor.dao.DepartamentoDAO;
import br.edu.utfpr.webapp.vraptor.dao.PessoaDAO;
import br.edu.utfpr.webapp.vraptor.model.Departamento;
import br.edu.utfpr.webapp.vraptor.model.Pessoa;
//import br.edu.utfpr.webapp.vraptor.interceptor.Public;

import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@Path("/person") // NEW
public class PersonController {

    private final Result result;
    private final Validator validator;
    private final PessoaDAO pessoaDAO;

    private DepartamentoDAO departamentoDAO;

    /**
     * @deprecated CDI eyes only
     */
    protected PersonController() {
        this(null, null, null, null);
    }

    @Inject
    public PersonController(PessoaDAO pessoaDAO, Result result, Validator validator, DepartamentoDAO departamentoDAO) {
        this.pessoaDAO = pessoaDAO;
        this.result = result;
        this.validator = validator;
        this.departamentoDAO = departamentoDAO;
    }

    @Get(value = {"", "/"})
    public List<Pessoa> list() {
        return pessoaDAO.findAll();
    }

//    @Public
    @Get(value = {"{id}", "new"})
    public Pessoa form(int id) {
        result.include("departamento", departamentoDAO.findAll());
        return pessoaDAO.getById(id);
    }

    public Pessoa form(Pessoa pessoa) {
        result.include("departamento",departamentoDAO.findAll());
        return pessoa;
    }

    @Post(value = {"/", ""})
    public void save(@NotNull @Valid Pessoa pessoa) {
        validator.onErrorForwardTo(this).form(pessoa);
        pessoaDAO.save(pessoa);
        result.include("notice", "Person " + pessoa.getLogin() + " successfully added");
        // Redireciona para a página de listagem
        result.redirectTo(this).list();
    }

    @Put(value = {"/", ""})
    public void update(Pessoa pessoa) {
        if (pessoa.getId() > 0) {
            pessoaDAO.update(pessoa);
        }

        // Redireciona para a página de listagem
        result.redirectTo(this).list();
    }

    @Delete("{id}")
    public void delete(int id) {
        pessoaDAO.delete(pessoaDAO.getById(id));
        result.forwardTo(PersonController.class).list();
    }

}
