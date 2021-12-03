package org.example.repository;

import org.example.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


public class JpaCustomerRepository implements CustomerRepository{

    private EntityManagerFactory entityManagerFactory;

    public JpaCustomerRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(customer);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Customer> findAll(String filter) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql="from customers";
        if(filter.equals("all")){
            jpql="* from customers";
        }
//        if(filter.equals("completed")){
//            jpql="from Todo where completed=true";
//        }
        Query query=entityManager.createQuery(jpql);
        List<Customer> customer= query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return  customer;
    }

    @Override
    public Customer findById(int customerId) {
        return null;
    }
}