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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kazz
 */
@Entity
@Table(name = "Funcao")
public class Funcao implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 
    private int idFuncao;

    @Column(nullable = false)
    @NotNull
    @Length(min = 3, max = 100)
    private String descFuncao;

    //@Column(nullable = false)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_funcao")
    private Collection<Pessoa> pessoas = new ArrayList<>();

    public int getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getDescFuncao() {
        return descFuncao;
    }

    public void setDescFuncao(String descFuncao) {
        this.descFuncao = descFuncao;
    }

    public Collection<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Collection<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
