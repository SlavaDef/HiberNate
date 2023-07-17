package grud;

import entity.Client;

import java.util.List;

public interface ClientDao {

    public Client findById(long id);

    public Client save(Client client);

    public Client update(long id, String name);

    public Client delete(long id);

    public List<Client> getAll();


}
