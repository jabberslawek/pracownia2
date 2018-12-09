package Przyrost2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
    private static EntityManager entityManager = null;
    private static EntityManagerFactory entityManagerFactory = null;

    public static void main( String[] args ) {

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
            entityManager = entityManagerFactory.createEntityManager();
        } catch (Exception ex) {
            System.out.println("ERR: " + ex.getCause());
        }

        MainLogic mainLogic = new MainLogic();
        mainLogic.getThemAll(entityManager);
        //mainLogic.printThemAll();
        mainLogic.addCompanyCar(entityManager);


    }
}
