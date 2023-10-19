package br.com.SistemaBancario.core;


import br.com.SistemaBancario.model.domain.*;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateManager {

    private static Session session;

    public static Session getSession() {
        if(session ==null) {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            Metadata md = new MetadataSources(ssr)
                    .addAnnotatedClass(Agencia.class)
                    .addAnnotatedClass(Cliente.class)
                    .addAnnotatedClass(ContaCorrente.class)
                    .addAnnotatedClass(ContaPoupanca.class)
                    .addAnnotatedClass(Usuario.class)
                    .addAnnotatedClass(Emprestimo.class)

                    .getMetadataBuilder().build();
            SessionFactory sessionFactory = md
                    .getSessionFactoryBuilder().build();
            session = sessionFactory.getCurrentSession();
        }
        return session;
    }
    public static EntityManager getEntityManager(){
        var s = getSession();
        if(!s.getTransaction().isActive()){
            s.beginTransaction();
        }
        return s.getEntityManagerFactory().createEntityManager();
    }
}
