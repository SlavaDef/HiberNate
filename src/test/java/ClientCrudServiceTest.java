import entity.Client;
import grud.ClientCrudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClientCrudServiceTest {


    ClientCrudService service;

    @BeforeEach
    public void beforeEach() {
        service = new ClientCrudService();
    }

    @Test
    public void findById() {
        Client find = service.findById(3L);
        assertEquals("Elon Doe", find.getName());
    }

    @Test
    public void delateById() {
        service.deleteClient(9L);
        assertEquals(null, service.findById(9L));
    }

    @Test
    public void getAllClients() {
        List<Client> clientList = service.getAllClients();
        System.out.println("ClientList is " + clientList);
    }

    @Test
    public void saveNewClient() {
        Client client = new Client();
        client.setName("Tom Jeronimo");
        service.saveClient(client);
        Client tom = service.findById(client.getId());
        assertEquals(client.getName(), tom.getName());

    }

    @Test
    public void updateClient(){
        Client client = service.updateClient(2L,"Jerri");
        Client jerri = service.findById(client.getId());
        assertEquals(client.getName(), jerri.getName());
    }
}
