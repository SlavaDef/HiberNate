package grud;

import entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import storage.HibernateUtil;

import java.util.List;

public class PlanetCrudService implements PlanetDao {
    private Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

    @Override
    public String findById(String id) {
        Planet planet = session.get(Planet.class, id);
        String name = planet.getName();
        session.close();
        return name;
    }

    @Override
    public void save(Planet planet) {
        Transaction tx1 = session.beginTransaction();
        session.persist(planet);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(String id, String name) {
        Planet planet = session.get(Planet.class, id);
        planet.setName(name);
        Transaction tx1 = session.beginTransaction();
        session.merge(planet);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(String id) {
        Transaction tx1 = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        session.remove(planet);
        tx1.commit();
        session.close();
    }

    public List<Planet> getAll() {
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        session.close();
        return planets;
    }
}
