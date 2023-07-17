package TestServis;

import entity.Client;
import entity.Planet;
import entity.Ticket;
import grud.ClientCrudService;
import grud.PlanetCrudService;
import grud.TicketCrudService;


public class TestTicketCrudService {

    public void testGetAll(TicketCrudService ticketCrudService) {
        ticketCrudService.getAllTickets();
    }

    public Ticket testFindTicketById(TicketCrudService ticketCrudService, long id) {
        Ticket ticket = ticketCrudService.findTicketById(id);
        return ticket;
    }

    public void testSaveTicket(TicketCrudService ticletCrudService) {
        Ticket ticket = new Ticket();

        ticket.setClient(new ClientCrudService()
                .getAll().stream().findAny().orElse(null));

        ticket.setFromPlanetId(new PlanetCrudService()
                .getAll().stream().findAny().orElse(null));

        ticket.setToPlanetId(new PlanetCrudService().getAll().stream().findAny().orElse(null));
        ticletCrudService.saveTicket(ticket);

    }

    public void testUpdateTicket(TicketCrudService ticketCrudService, long id) {
        Ticket ticket = new TicketCrudService().getAllTickets()
                .stream().findAny().orElse(null);
        Planet planet = new Planet();
        Client client = new Client();
        client.setId(8);
        planet.setName("MARS");
        ticket.setToPlanetId(planet);
        ticket.setClient(client);
        ticketCrudService.updateTicket(id);
    }

    void testRemoveTicket(TicketCrudService ticketCrudService) {
        ticketCrudService.deleteTicket(2L);
    }

    public boolean testSaveNoClient(TicketCrudService ticketCrudService) {
        return ticketCrudService.saveNoClient();
    }

    public boolean testSaveNullClient(TicketCrudService ticketCrudService) {
        return ticketCrudService.saveNullClient();
    }

    public boolean testSaveNullPlanet(TicketCrudService ticketCrudService) {
        return ticketCrudService.saveNullPlanet();
    }

    public boolean testSaveNoPlanet(TicketCrudService ticketCrudService) {
        return ticketCrudService.saveNoPlanet();
    }


    public static void main(String[] args) {

        //  new TestTicketCrudService().testGetAll(new TicketCrudService());
        // new TestTicketCrudService().testFindTicketById(new TicketCrudService(),4);
        // new TestTicketCrudService().testSaveTicket(new TicketCrudService());
        // new TestTicketCrudService().testUpdateTicket(new TicketCrudService(),9L);
        // new TestTicketCrudService().testRemoveTicket(new TicketCrudService());
       /* boolean res1 = new TestTicketCrudService().testSaveNoClient(new TicketCrudService());
        System.out.println(res1); // false */
       /* boolean res2 = new TestTicketCrudService().testSaveNullClient(new TicketCrudService());
        System.out.println(res2); // false */
       /* boolean res3 = new TestTicketCrudService().testSaveNullPlanet(new TicketCrudService());
        System.out.println(res3); // false */
        boolean res4 = new TestTicketCrudService().testSaveNoPlanet(new TicketCrudService());
        System.out.println(res4); // false

    }
}
