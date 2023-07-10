package grud;

import entity.Planet;
import entity.Ticket;

import java.util.List;

public interface TicketDao {

    public Ticket findTicketById(long id);

    public void saveTicket(Ticket ticket);

    public void updateTicket(String id, String name);

    public void deleteTicket(long id);

    public List<Ticket> getAllTickets();
}
