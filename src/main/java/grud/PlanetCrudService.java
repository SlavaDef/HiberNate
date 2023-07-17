package grud;

import entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import storage.HibernateUtil;

import java.util.List;

public class PlanetCrudService implements PlanetDao {
    private final Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

    @Override
    public Planet findById(String id) {
        Planet planet = session.get(Planet.class, id);
        String name = planet.getName();
        session.close();
        return planet;
    }

    @Override
    public Planet save(Planet planet) {
        Transaction tx1 = session.beginTransaction();
        session.persist(planet);
        tx1.commit();
        session.close();
        return planet;
    }

    @Override
    public Planet update(String id, String name) {
        Planet planet = session.get(Planet.class, id);
        planet.setName(name);
        Transaction tx1 = session.beginTransaction();
        session.merge(planet);
        tx1.commit();
        session.close();
        return planet;
    }

    @Override
    public Planet delete(String id) {
        Transaction tx1 = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        session.remove(planet);
        tx1.commit();
        session.close();
        return planet;
    }

    public List<Planet> getAll() {
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        session.close();
        return planets;
    }
}
