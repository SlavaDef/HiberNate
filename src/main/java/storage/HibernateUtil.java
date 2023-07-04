package storage;

import entity.Client;
import entity.Planet;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {

    private static final HibernateUtil INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() { // приватний конструктор створює обьект і там ми вже конфігуруємо його
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

// само не закриється треба очищати ресурси

    public void close() {
        sessionFactory.close();
    }

    public static void main(String[] args) {

        HibernateUtil util = new HibernateUtil().getInstance();

        /* Session session = util.getSessionFactory().openSession();
        Client client = session.get(Client.class,2L);
        System.out.println("Second client is " + client);
        session.close(); */

        Session session = util.getSessionFactory().openSession();
        List<Client> clientList = session.createQuery("from Client",Client.class).list();
        System.out.println(clientList+"\n");
        session.close();
    }

}
