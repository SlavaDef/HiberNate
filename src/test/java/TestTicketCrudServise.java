import entity.Client;
import entity.Planet;
import entity.Ticket;
import grud.ClientCrudService;
import grud.PlanetCrudService;
import grud.TicketCrudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;


public class TestTicketCrudServise {

    TicketCrudService ticketCrudService;
    ClientCrudService clientCrudService;

    PlanetCrudService planetCrudService;

    Client getAnyClient() {
        return new ClientCrudService().getAllClients().stream().findAny().orElse(null);
    }

    Planet getAnyPlanet() {
        return new PlanetCrudService().getAll().stream().findAny().orElse(null);
    }

    Ticket getAnyTicket() {
        return new TicketCrudService().getAllTickets().stream().findAny().orElse(null);
    }

    @BeforeEach
    public void beforeEach() {
        ticketCrudService = new TicketCrudService();
        planetCrudService = new PlanetCrudService();
        clientCrudService = new ClientCrudService();
    }

    @Test
    public void saveTicket() {
        Ticket ticket = new Ticket();
        ticket.setClient(getAnyClient());
        ticket.setFromPlanetId(getAnyPlanet());
        ticket.setToPlanetId(getAnyPlanet());
        boolean res = ticketCrudService.saveTicket(ticket);
        assertTrue(res);
    }

    @Test
    public void saveTicketWithNoClient() {
        Ticket ticket = new Ticket();
        ticket.setClient(new Client());
        ticket.setFromPlanetId(getAnyPlanet());
        ticket.setToPlanetId(getAnyPlanet());
        boolean res = ticketCrudService.saveTicket(ticket);
        assertFalse(res);
    }

    @Test
    public void saveTicketWithNoPlanet() {
        Ticket ticket = new Ticket();
        ticket.setClient(getAnyClient());
        ticket.setFromPlanetId(new Planet());
        ticket.setToPlanetId(getAnyPlanet());
        boolean res = ticketCrudService.saveTicket(ticket);
        assertFalse(res);
    }

    @Test
    public void getAllTickets() {
        List<Ticket> ticketList = ticketCrudService.getAllTickets();
        System.out.println(ticketList);
    }

    @Test
    public void getTicketById() {
        Ticket ticket = ticketCrudService.findTicketById(getAnyTicket().getId());
        System.out.println(ticket);
    }

    @Test
    public void delateTicket(){
        ticketCrudService.deleteTicket(5L);
        assertEquals(null, ticketCrudService.findTicketById(5L));
    }

    @Test
    public void updateTicket(){
        Ticket ticket = getAnyTicket();
        System.out.println("ticket = " + ticket);
        long id = ticket.getId();

        Ticket ticketUpdated = ticketCrudService.findTicketById(id);
        ticket.setClient(getAnyClient());
        ticket.setToPlanetId(getAnyPlanet());
        ticketCrudService.updateTicket(ticketUpdated.getId());
        System.out.println("ticketUpdated = " + ticketUpdated);
    }



}
