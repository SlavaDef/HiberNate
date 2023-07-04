package grud;

import entity.Client;

public interface ClientDao {

    public Client findById(int id);

    public void save(Client client);

    public void update(Client client);

    public void delete(Client client);


}
