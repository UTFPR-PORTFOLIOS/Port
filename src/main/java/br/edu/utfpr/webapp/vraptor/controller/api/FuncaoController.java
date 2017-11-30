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
import br.edu.utfpr.webapp.vraptor.dao.FuncaoDAO;
import br.edu.utfpr.webapp.vraptor.model.Funcao;
import javax.inject.Inject;

/**
 *
 * @author Victor
 */
@Controller
@Path("/api/funcao")
public class FuncaoController {
    
    @Inject
    private FuncaoDAO funcaoDAO;
    
    @Inject
    private Result result;
    
    @Consumes(value = "application/json")
    @Post(value = {"/",""})
    public void save(Funcao funcao) {
        try {
            funcaoDAO.save(funcao);
            
            result.nothing();
            result.use(Results.json())
              .withoutRoot()
              .from( funcao )
              .serialize();
        } catch(Exception e) {
            e.printStackTrace();
            result.notFound();
        }
    }
    
    @Put(value = {"/",""})
    public void update(Funcao funcao) {
        if(funcao.getIdFuncao()> 0)
            funcaoDAO.update(funcao);
        
    }
    
    @Delete("{id}")
    public void delete(int id) {
        funcaoDAO.delete(funcaoDAO.getById(id));
    }
    
    
    @Get("{id}")
    public void get(int id) {
        result.use(Results.json())
              .withoutRoot()
              .from( funcaoDAO.getById(id) )
              .serialize();
    }

    
    @Get(value = {"","/"})
    public void todosJson() {
        result.use(Results.json())
              .withoutRoot()
              .from( funcaoDAO.findAll() )
                .recursive()
                
              .serialize();
    }
    
    @Get(value = "/xml")
    public void todosXml() {
        result.use(Results.xml())
              .from(funcaoDAO.findAll() )
              .serialize();
    }
}
