/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import br.edu.utfpr.webapp.vraptor.dao.DepartamentoDAO;
import br.edu.utfpr.webapp.vraptor.model.Departamento;
import javax.inject.Inject;

/**
 *
 * @author Victor
 */
@Controller
@Path("/api/departamento")
public class DepartamentoController {
    
    @Inject
    private DepartamentoDAO departamentoDAO;
    
    @Inject
    private Result result;
    
    @Consumes(value = "application/json")
    @Post(value = {"/",""})
    public void save(Departamento departamento) {
        try {
            departamentoDAO.save(departamento);
            
            result.nothing();
            result.use(Results.json())
              .withoutRoot()
              .from( departamento )
              .serialize();
        } catch(Exception e) {
            e.printStackTrace();
            result.notFound();
        }
    }
    
    @Put(value = {"/",""})
    public void update(Departamento departamento) {
        if(departamento.getIdDepartamento()> 0)
            departamentoDAO.update(departamento);
        
    }
    
    @Delete("{id}")
    public void delete(int id) {
        departamentoDAO.delete(departamentoDAO.getById(id));
    }
    
    
    @Get("{id}")
    public void get(int id) {
        result.use(Results.json())
              .withoutRoot()
              .from( departamentoDAO.getById(id) )
              .serialize();
    }

    
    @Get(value = {"","/"})
    public void todosJson() {
        result.use(Results.json())
              .withoutRoot()
              .from( departamentoDAO.findAll() )
                .recursive()
                
              .serialize();
    }
    
    @Get(value = "/xml")
    public void todosXml() {
        result.use(Results.xml())
              .from(departamentoDAO.findAll() )
              .serialize();
    }
    
}
