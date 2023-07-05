package storage;

import entity.Client;
import grud.ClientCrudService;

import java.util.List;

public class TestAll {

    public void InItBaze(DatabaseInitService databaseInitService) {
        databaseInitService.initDb();
    }

    public void TestFind(ClientCrudService clientCrudService) {
        clientCrudService.findById(5L);
    }

    public void TestSave(ClientCrudService clientCrudService) {
        Client client = new Client();
        client.setName("Arni");
        clientCrudService.save(client);
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
      //  new TestAll().InItBaze(new DatabaseInitService());
        new TestAll().TestFind(new ClientCrudService());
        new TestAll().TestSave(new ClientCrudService());
        new TestAll().TestUpdate(new ClientCrudService());
       // new TestAll().TestDelate(new ClientCrudService());
        new TestAll().TestGetAll(new ClientCrudService());

    }
}
