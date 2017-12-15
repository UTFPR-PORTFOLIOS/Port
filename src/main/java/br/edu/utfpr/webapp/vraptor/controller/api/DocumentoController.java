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
import br.edu.utfpr.webapp.vraptor.dao.DocumentoDAO;
import br.edu.utfpr.webapp.vraptor.model.Documento;
import javax.inject.Inject;

/**
 *
 * @author Victor
 */
@Controller
@Path("/api/documento")
public class DocumentoController {
    
    @Inject
    private DocumentoDAO documentoDAO;
    
    @Inject
    private Result result;
    
    @Consumes(value = "application/json")
    @Post(value = {"/",""})
    public void save(Documento documento) {
        try {
            documentoDAO.save(documento);
            
            result.nothing();
            result.use(Results.json())
              .withoutRoot()
              .from( documento )
              .serialize();
        } catch(Exception e) {
            e.printStackTrace();
            result.notFound();
        }
    }
    
    @Put(value = {"/",""})
    public void update(Documento documento) {
        if(documento.getIdDocumento()> 0)
            documentoDAO.update(documento);
        
    }
    
    @Delete("{id}")
    public void delete(int id) {
        documentoDAO.delete(documentoDAO.getById(id));
    }
    
    
    @Get("{id}")
    public void get(int id) {
        result.use(Results.json())
              .withoutRoot()
              .from( documentoDAO.getById(id) )
              .serialize();
    }

    
    @Get(value = {"","/"})
    public void todosJson() {
        result.use(Results.json())
              .withoutRoot()
              .from( documentoDAO.findAll() )
                .recursive()
                
              .serialize();
    }
    
    @Get(value = "/xml")
    public void todosXml() {
        result.use(Results.xml())
              .from(documentoDAO.findAll() )
              .serialize();
    }
}
