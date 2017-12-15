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
import javax.validation.constraints.Pattern;
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
    private int id;

    @NotNull
    @Length(min = 3, max = 20) //bean validation
    @Pattern(regexp = "[a-z0-9_]+", message = "{invalid_user}")
    private String login;

    @NotNull
    @Length(min = 4, max = 20)
    private String password;

    @Column(nullable = false)
    @NotNull
    private int registroInterno;

    @Column(nullable = false)
    @Length(min = 3, max = 100)
    @NotNull
    private String email;

    @Column(nullable = false)
    @Length(min = 3, max = 100)
    @NotNull
    private String nome;

    @Column(nullable = false)
    @NotNull
    private boolean nivelAdm;

    @Column
    private int ramal;

    @Embedded
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegistroInterno() {
        return registroInterno;
    }

    public void setRegistroInterno(int registroInterno) {
        this.registroInterno = registroInterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
