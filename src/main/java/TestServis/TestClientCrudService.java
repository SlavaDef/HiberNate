package TestServis;

import entity.Client;
import grud.ClientCrudService;
import storage.DatabaseInitService;

import java.util.List;

public class TestClientCrudService {

    public void InItBaze(DatabaseInitService databaseInitService) {
        databaseInitService.initDb();
    }

    public void TestFind(ClientCrudService clientCrudService) {
        String name = clientCrudService.findById(5L);
        System.out.println(name);
    }

    public void TestSave(ClientCrudService clientCrudService) {
        Client client = new Client();
        client.setName("Arni");
    }

    public void TestUpdate(ClientCrudService clientCrudService){
        clientCrudService.update(3L,"Kate Frost");
    }

    public void TestDelate(ClientCrudService clientCrudService){
        clientCrudService.delete(2L);
    }

    public  void  TestGetAll(ClientCrudService clientCrudService){
        List<Client> clientList = clientCrudService.getAll();
        System.out.println(clientList);
    }


    public static void main(String[] args) {
       // new TestClientCrudService().InItBaze(new DatabaseInitService());
       //   new TestClientCrudService().TestFind(new ClientCrudService());
      // new TestClientCrudService().TestSave(new ClientCrudService());
       // new TestClientCrudService().TestUpdate(new ClientCrudService());
       // new TestClientCrudService().TestDelate(new ClientCrudService());
      // new TestClientCrudService().TestGetAll(new ClientCrudService());

    }
}
