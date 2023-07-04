import entity.Client;
import grud.ClientCrudService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class ClientCrudServiceTest {

    private ClientCrudService service;
    Client client;

    @BeforeEach
    public void beforeEach() {
        service = new ClientCrudService();
        client = new Client();
        client.setName("Bobbi Fisher");
    }
    @Test
    public void testId() {
        long id = 8L;
        String expect = client.getName();
        String name = String.valueOf(service.findById(id));
        Assertions.assertEquals(expect, client);

    }

    @Test
    public void saveClient() {
        service.save(client);
        String name = String.valueOf(service.findById(client.getId()));
        Assertions.assertEquals(client.getName(), name);
    }

}
