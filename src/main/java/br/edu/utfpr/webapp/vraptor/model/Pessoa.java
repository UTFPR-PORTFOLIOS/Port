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
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kazz
 */
@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 
    private int idPessoa;

    @OneToOne(cascade = CascadeType.ALL)
    private Person login;

    @Column(nullable = false)
    @NotNull
    private int registroInterno;

    @Column(nullable = false)
    @Length(min = 3, max = 100)
    @NotNull
    private String descEmail;

    @Column(nullable = false)
    @Length(min = 3, max = 100)
    @NotNull
    private String descNome;

    @Column(nullable = false)
    @Length(min = 3, max = 100)
    @NotNull
    private String descSobrenome;

    @Column(nullable = false)
    @NotNull
    private boolean nivelAdm;

    @Column
    private int ramal;

    @Embedded
    @NotNull
    private Endereco endereco;

    //@Column(nullable = false)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_pessoa")
    private Collection<Documento> documentos = new ArrayList<>();

    public Collection<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Collection<Documento> documentos) {
        this.documentos = documentos;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getRegistroInterno() {
        return registroInterno;
    }

    public void setRegistroInterno(int registroInterno) {
        this.registroInterno = registroInterno;
    }

    public String getDescEmail() {
        return descEmail;
    }

    public void setDescEmail(String descEmail) {
        this.descEmail = descEmail;
    }

    public String getDescNome() {
        return descNome;
    }

    public void setDescNome(String descNome) {
        this.descNome = descNome;
    }

    public String getDescSobrenome() {
        return descSobrenome;
    }

    public void setDescSobrenome(String descSobrenome) {
        this.descSobrenome = descSobrenome;
    }

    public boolean isNivelAdm() {
        return nivelAdm;
    }

    public void setNivelAdm(boolean nivelAdm) {
        this.nivelAdm = nivelAdm;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
