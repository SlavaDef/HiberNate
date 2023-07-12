package grud;

import entity.Planet;
import entity.Ticket;

import java.util.List;

public interface TicketDao {

    public Ticket findTicketById(long id);

    public boolean saveTicket(Ticket ticket);

    public void updateTicket(long id);

    public void deleteTicket(long id);

    public List<Ticket> getAllTickets();
}
