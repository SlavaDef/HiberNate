package grud;

import entity.Ticket;
import org.hibernate.Session;
import storage.HibernateUtil;

import java.util.List;

public class TicketCrudService implements TicketDao {

    private Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

    @Override
    public Ticket findTicketById(long id) {
        Ticket ticket = session.find(Ticket.class, id);
        session.close();
        return ticket;
    }

    @Override
    public void saveTicket(Ticket ticket) {

    }

    @Override
    public void updateTicket(String id, String name) {

    }

    @Override
    public void deleteTicket(long id) {

    }

    @Override
    public List<Ticket> getAllTickets() {

        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).list();
        session.close();
        return tickets;
    }

}
