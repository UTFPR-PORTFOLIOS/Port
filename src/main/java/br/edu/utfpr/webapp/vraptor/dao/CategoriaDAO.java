/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.webapp.vraptor.dao;

import br.edu.utfpr.webapp.vraptor.model.Categoria;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author kazz
 */

@RequestScoped
public class CategoriaDAO extends GenericDAO<Integer, Categoria>{

    public CategoriaDAO() {
        super();
    }
}
