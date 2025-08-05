package br.com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        
        Pessoa p1 = new Pessoa();
        p1.setNome("isadora");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(em);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}