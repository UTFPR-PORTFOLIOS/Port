/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.webapp.vraptor.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kazz
 */
@Entity
@Table(name = "Documento")
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumento;

    @Column(nullable = false)
    @NotNull
    @Length(min = 3, max = 100)
    private String descDocumento;

    @Column(nullable = false)
    @NotNull
    private Date dataInclusao;

    @Column(nullable = false)
    @Length(min = 3, max = 200)
    @NotNull
    private String caminhoArquivo;

    //@Column(nullable = false)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_documento")
    @NotNull
    private Collection<Tags> tags = new ArrayList<>();

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDescDocumento() {
        return descDocumento;
    }

    public void setDescDocumento(String descDocumento) {
        this.descDocumento = descDocumento;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public Collection<Tags> getTags() {
        return tags;
    }

    public void setTags(Collection<Tags> tags) {
        this.tags = tags;
    }

}
