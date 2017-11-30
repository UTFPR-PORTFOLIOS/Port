package br.edu.utfpr.webapp.vraptor.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tb_person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 
    private int id;

    @Column(nullable = false) //jpa banco
//    @NotNull(message = "{arquivo_validation messages}")
    /*@NotNull
    @Length(min = 3, max = 100)
    private String name;

    @Temporal(TemporalType.DATE)
    @Past
    private Date birthday;*/

    @NotNull
    @Length(min = 3, max = 20) //bean validation
    @Pattern(regexp = "[a-z0-9_]+", message = "{invalid_user}")
    private String login;

    @NotNull
    @Length(min = 4, max = 20)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", login=" + login + '}';
    }
}
