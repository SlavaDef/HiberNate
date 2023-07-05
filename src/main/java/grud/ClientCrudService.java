package grud;

import entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import storage.HibernateUtil;

import java.util.List;


public class ClientCrudService implements ClientDao {
    private Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

    @Override
    public Client findById(long id) {

        return session.get(Client.class, id);
    }

    @Override
    public void save(Client client) {
        Transaction tx1 = session.beginTransaction();
        session.persist(client);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(long id, String name) {
        Client client = session.get(Client.class, id);
        client.setName(name);
        Transaction tx1 = session.beginTransaction();
        session.merge(client);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Transaction tx1 = session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.remove(client);
        tx1.commit();
        session.close();
    }

    public List<Client> getAll() {
        List<Client> clientList = session.createQuery("from Client", Client.class).list();
        session.close();
        return clientList;
    }

}