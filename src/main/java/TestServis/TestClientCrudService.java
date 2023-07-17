package TestServis;

import entity.Client;
import grud.ClientCrudService;
import storage.DatabaseInitService;

import java.util.List;

public class TestClientCrudService {

    public void InItBaze(DatabaseInitService databaseInitService) {
        databaseInitService.initDb();
    }

    public Client TestFind(ClientCrudService clientCrudService) {
        return clientCrudService.findById(5L);

    }

    public Client TestSave(ClientCrudService clientCrudService) {
        Client client = new Client();
        client.setName("Arni");
        return clientCrudService.save(client);
    }

    public Client TestUpdate(ClientCrudService clientCrudService){

        return clientCrudService.update(3L,"Kate Frost");
    }

    public Client TestDelate(ClientCrudService clientCrudService){

        return clientCrudService.delete(2L);
    }

    public  List<Client>  TestGetAll(ClientCrudService clientCrudService){
        return clientCrudService.getAll();
    }


    public static void main(String[] args) {
       // new TestClientCrudService().InItBaze(new DatabaseInitService());
       // new TestClientCrudService().TestFind(new ClientCrudService());
      // new TestClientCrudService().TestSave(new ClientCrudService());
       // new TestClientCrudService().TestUpdate(new ClientCrudService());
       // new TestClientCrudService().TestDelate(new ClientCrudService());
      // new TestClientCrudService().TestGetAll(new ClientCrudService());

    }
}
