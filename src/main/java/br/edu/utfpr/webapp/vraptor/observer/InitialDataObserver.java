package br.edu.utfpr.webapp.vraptor.observer;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import javax.persistence.Persistence;

@Dependent
public class InitialDataObserver {

    /*
    public void insert(@Observes VRaptorInitialized event) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ContatosPU");
        EntityManager manager = null;

        try {
            
            manager = factory.createEntityManager();
            manager.getTransaction().begin();

            //Person defaultUser = new Person();
            //defaultUser.setLogin("user");
            //defaultUser.setPassword("user");
            //defaultUser.setName("Default User");

            //manager.persist(defaultUser);
            manager.getTransaction().commit();

        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }*/
}
