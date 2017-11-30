package br.edu.utfpr.webapp.vraptor.validation.impl;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.edu.utfpr.webapp.vraptor.dao.PessoaDAO;
import br.edu.utfpr.webapp.vraptor.model.Person;
import br.edu.utfpr.webapp.vraptor.validation.LoginAvailable;

public class LoginAvailableValidator
        implements ConstraintValidator<LoginAvailable, Person> {

    @Inject
    private PessoaDAO pessoaDAO;

    @Override
    public void initialize(LoginAvailable constraintAnnotation) {

    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext context) {
        return !pessoaDAO.containsUserWithLogin(person.getLogin());
    }
}
