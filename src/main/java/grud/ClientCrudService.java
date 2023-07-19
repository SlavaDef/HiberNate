package grud;

import entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import storage.HibernateUtil;

import java.util.List;


public class ClientCrudService implements ClientDao {

    @Override
    public Client findById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        return session.get(Client.class, id);
    }

    @Override
    public Client saveClient(Client client) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(client);
        tx1.commit();
        session.close();
        return client;
    }

    @Override
    public Client updateClient(long id, String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        client.setName(name);
        Transaction tx1 = session.beginTransaction();
        session.merge(client);
        tx1.commit();
        session.close();
        return client;
    }

    @Override
    public Client deleteClient(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        Transaction tx1 = session.beginTransaction();
        session.remove(client);
        tx1.commit();
        session.close();
        return client;

    }

    public List<Client> getAllClients() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Client> clientList = session.createQuery("from Client", Client.class).list();
        session.close();
        return clientList;
    }

}

