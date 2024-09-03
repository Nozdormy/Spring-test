package ru.spring.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.models.Person;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1() {
        Session session = entityManager.unwrap(Session.class);

/*        // 1 запрос
        List<Person> people = session.createQuery("select p from Person p", Person.class)
                .getResultList();

        // N запросов к БД
        for (Person person : people) {
            System.out.println("Person :" + person.getName() + " has : " + person.getItems());
        }*/

        // Решение, не забыть переопределить hashCode and equals
        Set<Person> people = new HashSet<>(session.createQuery("select p from Person p left join fetch p.items", Person.class)
                .getResultList());

        for (Person person : people) {
            System.out.println("Person :" + person.getName() + " has : " + person.getItems());
        }
    }


    /*private final SessionFactory sessionFactory;
    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Person.class, id);
    }

    @Transactional(readOnly = true)
    public Optional<Person> show(String email) {
        Session session = sessionFactory.getCurrentSession();

        return Optional.ofNullable(session.get(Person.class, email));
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Transactional
    public void update(int id, Person person) {
        Session session = sessionFactory.getCurrentSession();
        Person personToBeUpdated = session.get(Person.class, id);

        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
        personToBeUpdated.setAddress(person.getAddress());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Person.class, id));
    }*/
}
