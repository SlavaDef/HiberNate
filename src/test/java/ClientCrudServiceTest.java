import entity.Client;
import grud.ClientCrudService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class ClientCrudServiceTest {

    ClientCrudService service = new ClientCrudService();
    Client client;

    @BeforeEach
    public void beforeEach() {
        client = new Client();
        client.setName("Bobbi Fisher");
    }

    @Test
    public void saveClient() {
        service.save(client);
        String name = String.valueOf(service.findById(client.getId()));
        Assertions.assertEquals(client.getName(), name);
    }

    @Test
    public void testFindById() {
        long id = 12L;
        String expect = client.getName();
        String name = String.valueOf(service.findById(id));
        Assertions.assertEquals(expect, name);

    }



}
