package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Person persist(Person person){
        person.setId(null);
        entityManager.persist(person);
        return person;
    }

    @Transactional
    public Person update(Person person){
        return entityManager.merge(person);
    }

    public Person get(Long id){
        return entityManager.find(Person.class, id);
    }

    public List<Person> getAll(){
        return entityManager.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();
    }
}
