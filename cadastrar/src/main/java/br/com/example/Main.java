package br.com.example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Documento documento = new Documento("doc", "ssp");

        Pessoa p1 = new Pessoa();
        p1.setDocumento(documento);

        // Cria o EntityManagerFactory com base na unidade de persistência 'meuPU'
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();

        // Inicia a transação
        em.getTransaction().begin();

        // Persiste o objeto no banco de dados
        em.persist(p1);
  
        // Finaliza a transação
        em.getTransaction().commit();


        //Listar (JPQL) FROM nomeDaClasse
        List<Pessoa> pessoas = em.createQuery("FROM Pessoa", Pessoa.class).getResultList();
        for (Pessoa p  : pessoas) {
            System.out.println(p.getNome());
        }

        // Fecha o EntityManager e o EntityManagerFactory
        em.close();
        emf.close();

        System.out.println("Pessoa salva com sucesso!");



    }
}
