/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.webapp.vraptor.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kazz
 */

@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;
    
    @Column(nullable = false)
    @Length(min = 3, max = 100)
    private String Cateforia;
    
    //@Column(nullable = false)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_categoria")
    private Collection<TipoDocumento> tipoDocumento = new ArrayList<>();

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCateforia() {
        return Cateforia;
    }

    public void setCateforia(String Cateforia) {
        this.Cateforia = Cateforia;
    }
            
    
}
