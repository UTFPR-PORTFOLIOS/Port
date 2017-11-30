package br.edu.utfpr.webapp.vraptor.dao;

import br.edu.utfpr.webapp.vraptor.model.Pessoa;
import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;

/**
 *
 * @author Victor
 */
@RequestScoped
public class PessoaDAO extends GenericDAO<Integer, Pessoa> {

    public PessoaDAO() {
        super();
    }

    public boolean containsUserWithLogin(String login) {
        Long count = entityManager
                .createQuery("select count(p) from Pessoa p where p.login = :login", Long.class)
                .setParameter("login", login)
                .getSingleResult();
        return count > 0;
    }

    public Pessoa find(String login, String password) {
        try {
            return entityManager
                    .createQuery("select p from Pessoa p where p.login = :login and p.password = :password", Pessoa.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
