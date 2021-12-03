package org.example.repository;

import org.example.entity.Transfer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


public class JpaTransferRepository implements TransferRepository{

    private EntityManagerFactory entityManagerFactory;

    public JpaTransferRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Transfer transfer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(transfer);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Transfer> findAll(String filter) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql="from transfers";
        if(filter.equals("all")){
            jpql="* from transfers";
        }
//        if(filter.equals("completed")){
//            jpql="from Todo where completed=true";
//        }
        Query query=entityManager.createQuery(jpql);
        List<Transfer> transfer= query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return  transfer;
    }

    @Override
    public Transfer findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Transfer transfer=entityManager.find(Transfer.class,id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return  transfer;
    }
}
