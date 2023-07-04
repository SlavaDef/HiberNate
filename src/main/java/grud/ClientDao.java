package grud;

import entity.Client;

import java.util.List;

public interface ClientDao {

    public Client findById(long id);

    public void save(Client client);

    public void update(long id, String name);

    public void delete(long id);

    public List<Client> getAll();


}
