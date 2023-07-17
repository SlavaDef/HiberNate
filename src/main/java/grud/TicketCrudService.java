package grud;


import entity.Client;
import entity.Planet;
import entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import storage.HibernateUtil;

import java.util.List;

public class TicketCrudService implements TicketDao {

    private final Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

    @Override
    public Ticket findTicketById(long id) {
        Ticket ticket = session.find(Ticket.class, id);
        session.close();
        return ticket;
    }

    @Override
    public boolean saveTicket(Ticket ticket) {
        try {
            Transaction tx1 = session.beginTransaction();
            session.persist(ticket);
            tx1.commit();
            session.close();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public void updateTicket(long id) {
        Ticket ticket = session.get(Ticket.class, id);
        Transaction tx1 = session.beginTransaction();
        session.merge(ticket);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteTicket(long id) {
        Transaction tx1 = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        session.remove(ticket);
        tx1.commit();
        session.close();

    }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).list();
        session.close();
        return tickets;
    }

    public boolean saveNoClient() {
        Ticket ticket = new Ticket();
        ticket.setClient(new Client());
        return new TicketCrudService().saveTicket(ticket);
    }

    public boolean saveNullClient() {
        Ticket ticket = new Ticket();
        ticket.setClient(null);
        return new TicketCrudService().saveTicket(ticket);
    }

    public boolean saveNullPlanet() {
        Ticket ticket = new Ticket();
        ticket.setToPlanetId(null);
        return new TicketCrudService().saveTicket(ticket);
    }

    public boolean saveNoPlanet() {
        Ticket ticket = new Ticket();
        Planet planet = new Planet();
        planet.setId("Fau");
        planet.setName("Faust");
        ticket.setToPlanetId(planet);
        return new TicketCrudService().saveTicket(ticket);
    }
}

