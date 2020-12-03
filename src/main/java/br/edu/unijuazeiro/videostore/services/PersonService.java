package br.edu.unijuazeiro.videostore.services;

import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.edu.unijuazeiro.videostore.dao.PersonDAO;
import br.edu.unijuazeiro.videostore.model.person.Person;

public class PersonService {

    private PersonDAO personDAO = new PersonDAO();

    public void save(Person person) {
        if (person.getName().length() > 30) {
            // disparo uma exception
        }
        personDAO.save(person);
    }

    public void update(Person person) {
        if (person.getPassword() == null) {
            throw new RuntimeException("Senha obrigatória");
        }
        String pwdCipher = BCrypt.withDefaults().hashToString(11, person.getPassword().toCharArray());
        System.out.println(pwdCipher);
        person.setPassword(pwdCipher);
        personDAO.update(person);
    }

    public Person login(String email, String password) {
        Person p = personDAO.findByEmail(email);
        if (p == null) {
            throw new RuntimeException("Dados inválido");
        }
        if (!BCrypt.verifyer().verify(password.toCharArray(), p.getPassword().toCharArray()).verified) {
            throw new RuntimeException("Dados inválido 2");
        }
        return p;
    }

    public List<Person> list() {
        return personDAO.list();
    }

}
