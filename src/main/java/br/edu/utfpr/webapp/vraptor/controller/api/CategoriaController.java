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
import br.edu.utfpr.webapp.vraptor.dao.CategoriaDAO;
import br.edu.utfpr.webapp.vraptor.model.Categoria;
import javax.inject.Inject;

/**
 *
 * @author Victor
 */
@Controller
@Path("/api/categoria")
public class CategoriaController {
    
    @Inject
    private CategoriaDAO categoriaDAO;
    
    @Inject
    private Result result;
    
    @Consumes(value = "application/json")
    @Post(value = {"/",""})
    public void save(Categoria categoria) {
        try {
            categoriaDAO.save(categoria);
            
            result.nothing();
            result.use(Results.json())
              .withoutRoot()
              .from( categoria )
              .serialize();
        } catch(Exception e) {
            e.printStackTrace();
            result.notFound();
        }
    }
    
    @Put(value = {"/",""})
    public void update(Categoria categoria) {
        if(categoria.getIdCategoria()> 0)
            categoriaDAO.update(categoria);
        
    }
    
    @Delete("{id}")
    public void delete(int id) {
        categoriaDAO.delete(categoriaDAO.getById(id));
    }
    
    
    @Get("{id}")
    public void get(int id) {
        result.use(Results.json())
              .withoutRoot()
              .from( categoriaDAO.getById(id) )
              .serialize();
    }

    
    @Get(value = {"","/"})
    public void todosJson() {
        result.use(Results.json())
              .withoutRoot()
              .from( categoriaDAO.findAll() )
                .recursive()
                
              .serialize();
    }
    
    @Get(value = "/xml")
    public void todosXml() {
        result.use(Results.xml())
              .from(categoriaDAO.findAll() )
              .serialize();
    }
    
    
}
