/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.webapp.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.edu.utfpr.webapp.vraptor.dao.DepartamentoDAO;
import br.edu.utfpr.webapp.vraptor.model.Departamento;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Victor
 */
@Controller
public class DepartamentoController {

    private final Result result;
    private final DepartamentoDAO departamentoDAO;

    protected DepartamentoController() {
        this(null, null);
    }

    @Inject
    public DepartamentoController(Result result, DepartamentoDAO departamentoDAO) {
        this.result = result;
        this.departamentoDAO = departamentoDAO;
    }
    
    @Get
    public List<Departamento> listDepartamento(){
        return departamentoDAO.findAll();
    }
}
