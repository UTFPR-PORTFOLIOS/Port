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
import br.edu.utfpr.webapp.vraptor.dao.PessoaDAO;
//import br.edu.utfpr.webapp.vraptor.interceptor.Public;
import br.edu.utfpr.webapp.vraptor.model.Person;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@Path("/person")
public class PersonController {
    private final Result result;
    private final Validator validator;
    private final PessoaDAO pessoaDAO;

    /**
     * @deprecated CDI eyes only
     */
    protected PersonController() {
        this(null, null, null);
    }

    @Inject
    public PersonController(PessoaDAO pessoaDAO, Result result, Validator validator) {
        this.pessoaDAO = pessoaDAO;
        this.result = result;
        this.validator = validator;
    }

    @Get(value = {"","/"})
    public List<Person> list() {
        return pessoaDAO.findAll();
    }
    
//    @Public
    @Get(value={"{id}", "new"})
    public Person form(int id) {
        return pessoaDAO.getById(id);
    }
    
    public Person form(Person person) {
        return person;
    }
    
    @Post(value = {"/",""})
    public void save(@NotNull @Valid Person person) {
        validator.onErrorForwardTo(this).form(person);
        
        pessoaDAO.save(person);
        
        result.include("notice", "Person " + person.getLogin()+ " successfully added");
        // Redireciona para a página de listagem
        result.redirectTo(this).list();
    }
    
    @Put(value = {"/",""})
    public void update(Person person) {
        if(person.getId() > 0)
            pessoaDAO.update(person);
        
        // Redireciona para a página de listagem
        result.redirectTo(this).list();
    }
    
    @Delete("{id}")
    public void delete(int id) {
        pessoaDAO.delete(pessoaDAO.getById(id));
        result.forwardTo(PersonController.class).list();
    }

    
    @Get(value = "/json")
    public void todosJson() {
        result.use(Results.json())
              .withoutRoot()
              .from(list())
              .serialize();
    }
    
    @Get(value = "/xml")
    public void todosXml() {
        result.use(Results.xml())
              .from(list())
              .serialize();
    }
}