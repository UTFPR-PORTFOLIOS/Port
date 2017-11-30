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
import br.edu.utfpr.webapp.vraptor.dao.TagsDAO;
import br.edu.utfpr.webapp.vraptor.model.Tags;
import javax.inject.Inject;

/**
 *
 * @author Victor
 */
@Controller
@Path("/api/tags")
public class TagsController {

    @Inject
    private TagsDAO tagsDAO;

    @Inject
    private Result result;

    @Consumes(value = "application/json")
    @Post(value = {"/", ""})
    public void save(Tags tags) {
        try {
            tagsDAO.save(tags);

            result.nothing();
            result.use(Results.json())
                    .withoutRoot()
                    .from(tags)
                    .serialize();
        } catch (Exception e) {
            e.printStackTrace();
            result.notFound();
        }
    }

    @Put(value = {"/", ""})
    public void update(Tags tags) {
        if (tags.getIdTag() > 0) {
            tagsDAO.update(tags);
        }

    }

    @Delete("{id}")
    public void delete(int id) {
        tagsDAO.delete(tagsDAO.getById(id));
    }

    @Get("{id}")
    public void get(int id) {
        result.use(Results.json())
                .withoutRoot()
                .from(tagsDAO.getById(id))
                .serialize();
    }

    @Get(value = {"", "/"})
    public void todosJson() {
        result.use(Results.json())
                .withoutRoot()
                .from(tagsDAO.findAll())
                .recursive()
                .serialize();
    }

    @Get(value = "/xml")
    public void todosXml() {
        result.use(Results.xml())
                .from(tagsDAO.findAll())
                .serialize();
    }

}
