import org.hibernate.Session;
import java.util.Arrays;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;


public class Database {

    // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("kantinesimulatie");
    private EntityManager manager;

    public Database() {
    }

    public void runVoorbeeld(){

        manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        manager.close();
        ENTITY_MANAGER_FACTORY.close();
    }
}