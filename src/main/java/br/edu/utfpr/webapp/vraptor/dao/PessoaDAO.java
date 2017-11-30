package br.edu.utfpr.webapp.vraptor.dao;

import br.edu.utfpr.webapp.vraptor.model.Person;
import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;

@RequestScoped
public class PessoaDAO extends GenericDAO<Integer, Person> {

    public PessoaDAO() {
        super();
    }

    public boolean containsUserWithLogin(String login) {
        Long count = entityManager
                .createQuery("select count(p) from Person p where p.login = :login", Long.class)
                .setParameter("login", login)
                .getSingleResult();
        return count > 0;
    }

    public Person find(String login, String password) {
        try {
            return entityManager
                    .createQuery("select p from Person p where p.login = :login and p.password = :password", Person.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
