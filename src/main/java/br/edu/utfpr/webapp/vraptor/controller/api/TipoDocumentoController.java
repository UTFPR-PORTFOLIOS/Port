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
import br.edu.utfpr.webapp.vraptor.dao.TipoDocumentoDAO;
import br.edu.utfpr.webapp.vraptor.model.TipoDocumento;
import javax.inject.Inject;

/**
 *
 * @author Victor
 */
@Controller
@Path("/api/tipoDocumento")
public class TipoDocumentoController {

    @Inject
    private TipoDocumentoDAO tipoDocumentoDAO;

    @Inject
    private Result result;

    @Consumes(value = "application/json")
    @Post(value = {"/", ""})
    public void save(TipoDocumento tipoDocumento) {
        try {
            tipoDocumentoDAO.save(tipoDocumento);

            result.nothing();
            result.use(Results.json())
                    .withoutRoot()
                    .from(tipoDocumento)
                    .serialize();
        } catch (Exception e) {
            e.printStackTrace();
            result.notFound();
        }
    }

    @Put(value = {"/", ""})
    public void update(TipoDocumento tipoDocumento) {
        if (tipoDocumento.getIdTipoDocumento() > 0) {
            tipoDocumentoDAO.update(tipoDocumento);
        }

    }

    @Delete("{id}")
    public void delete(int id) {
        tipoDocumentoDAO.delete(tipoDocumentoDAO.getById(id));
    }

    @Get("{id}")
    public void get(int id) {
        result.use(Results.json())
                .withoutRoot()
                .from(tipoDocumentoDAO.getById(id))
                .serialize();
    }

    @Get(value = {"", "/"})
    public void todosJson() {
        result.use(Results.json())
                .withoutRoot()
                .from(tipoDocumentoDAO.findAll())
                .recursive()
                .serialize();
    }

    @Get(value = "/xml")
    public void todosXml() {
        result.use(Results.xml())
                .from(tipoDocumentoDAO.findAll())
                .serialize();
    }

}
