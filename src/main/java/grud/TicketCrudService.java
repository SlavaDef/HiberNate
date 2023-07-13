package grud;


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
        System.out.println(tickets);
        return tickets;
    }

    public boolean saveZeroTicket() {

        try {
            Transaction tx1 = session.beginTransaction();

            session.persist(new Ticket());
            tx1.commit();
            session.close();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean saveNullTicket() {

        try {
            Transaction tx1 = session.beginTransaction();

            session.persist(null);
            tx1.commit();
            session.close();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
