package storage;

import entity.Client;
import grud.ClientCrudService;

import java.util.List;

public class TestClientGridService {

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
      //  new TestClientGridService().InItBaze(new DatabaseInitService());
       //   new TestClientGridService().TestFind(new ClientCrudService());
      // new TestClientGridService().TestSave(new ClientCrudService());
       // new TestClientGridService().TestUpdate(new ClientCrudService());
       // new TestClientGridService().TestDelate(new ClientCrudService());
       new TestClientGridService().TestGetAll(new ClientCrudService());

    }
}
