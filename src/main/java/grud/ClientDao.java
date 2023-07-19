package grud;

import entity.Client;

import java.util.List;

public interface ClientDao {

    public Client findById(long id);

    public Client saveClient(Client client);

    public Client updateClient(long id, String name);

    public Client deleteClient(long id);

    public List<Client> getAllClients();


}
