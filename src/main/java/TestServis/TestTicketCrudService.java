package TestServis;

import entity.Client;
import entity.Planet;
import entity.Ticket;
import grud.ClientCrudService;
import grud.PlanetCrudService;
import grud.TicketCrudService;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;

public class TestTicketCrudService {

    public void testGetAll(TicketCrudService ticletCrudService) {
        ticletCrudService.getAllTickets();
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

    public void testUpdateTicket(TicketCrudService ticketCrudService, long id){
        Ticket ticket = new TicketCrudService().getAllTickets()
                .stream().findAny().orElse(null);
        Planet planet = new Planet();
        Client client = new Client();
        client.setId(8);
        planet.setName("MARS");
        ticket.setToPlanetId(planet);
        ticket.setClient(client);

        // ticket.setClient(new Client());
        ticketCrudService.updateTicket(id);
    }

    public void testRemoveTicket(TicketCrudService ticketCrudService, long id){
        ticketCrudService.deleteTicket(id);
    }


    public static void main(String[] args) {

        new TestTicketCrudService().testGetAll(new TicketCrudService());
        // System.out.println( new TestTicketCrudService().testFindTicketById(new TicketCrudService(),4));
        //new TestTicketCrudService().testSaveTicket(new TicketCrudService());
       // new TestTicketCrudService().testUpdateTicket(new TicketCrudService(),13L);
       // new TestTicketCrudService().testRemoveTicket(new TicketCrudService(),15L);
    }
}
