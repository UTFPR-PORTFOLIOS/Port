package br.edu.utfpr.webapp.vraptor.interceptor;

import br.edu.utfpr.webapp.vraptor.model.Pessoa;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped //Objeto dessa classe no contexto web sera de escopo de sessao// Sessao de Usuario
@Named //CDI // injecao de dependencia // pode ser ingetada em qualquer lugar do servidor de aplicacao
public class UserInfo implements Serializable {
//Classe responsavel por manter a sessao do usuario
    private static final long serialVersionUID = 1232435511714L;
    private Pessoa person;

    public Pessoa getPerson() {
        return person;
    }

    public void login(Pessoa person) {
        this.person = person;
    }

    public void logout() {
        this.person = null;
    }
}
