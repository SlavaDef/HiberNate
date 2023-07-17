package grud;

import entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import storage.HibernateUtil;

import java.util.List;


public class ClientCrudService implements ClientDao {
    private final Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

    @Override
    public Client findById(long id) {
        return session.get(Client.class, id);
    }

    @Override
    public Client save(Client client) {
        Transaction tx1 = session.beginTransaction();
        session.persist(client);
        tx1.commit();
        session.close();
        return client;
    }

    @Override
    public Client update(long id, String name) {
        Client client = session.get(Client.class, id);
        client.setName(name);
        Transaction tx1 = session.beginTransaction();
        session.merge(client);
        tx1.commit();
        session.close();
        return client;
    }

    @Override
    public Client delete(long id) {
        Client client = session.get(Client.class, id);
        Transaction tx1 = session.beginTransaction();
        session.remove(client);
        tx1.commit();
        session.close();
        return client;

    }

    public List<Client> getAll() {
        List<Client> clientList = session.createQuery("from Client", Client.class).list();
        session.close();
        return clientList;
    }

}

