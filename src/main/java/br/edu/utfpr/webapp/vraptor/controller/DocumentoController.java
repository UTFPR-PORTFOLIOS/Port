/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.webapp.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.webapp.vraptor.dao.DocumentoDAO;
import br.edu.utfpr.webapp.vraptor.model.Documento;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kazz
 */
@Controller
@Path("/documento")
public class DocumentoController {

    private final Result result;
    private final Validator validator;
    private final DocumentoDAO documentoDAO;

    protected DocumentoController() {
        this(null, null, null);
    }

    @Inject
    public DocumentoController(Result result, Validator validator, DocumentoDAO documentoDAO) {
        this.result = result;
        this.validator = validator;
        this.documentoDAO = documentoDAO;

    }

    @Get(value = {"", "/"})
    public List<Documento> list() {
        return documentoDAO.findAll();
    }

    @Get
    public Documento form(Documento documento) {
        //result.include("departamento", documentoDAO.findAll());
        return documento;
    }

    @Post(value = {"/", ""})
    public void save(@NotNull @Valid Documento documento, UploadedFile fileDocumento) throws IOException {
        documento.setCaminhoArquivo("/arquivo/documento");
        validator.onErrorForwardTo(this).form(documento);
        File doc = new File("/arquivo/documento", fileDocumento.getFileName());
        fileDocumento.writeTo(doc);
        ///home/kazz/Documents/topicos_avan/projeto-atualizado2-css/projeto-atualizado/Port/arquivo/documento

        documentoDAO.save(documento);

        result.include("notice", "Doc " + documento.getDescDocumento() + " successfully added");
        // Redireciona para a página de listagem
        result.redirectTo(this).list();
    }
}
