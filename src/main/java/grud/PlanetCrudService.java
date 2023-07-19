package grud;

import entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.hql.HqlInterpretationException;
import storage.HibernateUtil;

import java.util.List;

public class PlanetCrudService implements PlanetDao {

    @Override
    public Planet findById(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    @Override
    public Planet save(Planet planet) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(planet);
        tx1.commit();
        session.close();
        return planet;
    }

    @Override
    public boolean update(Planet planet) {
      try(  Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
          Transaction tx1 = session.beginTransaction();
          session.merge(planet);
          tx1.commit();
          return true;
      }catch (HqlInterpretationException e){
          return false;
      }
    }

    @Override
    public boolean delete(String id) {
       try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession();){
           Transaction tx1 = session.beginTransaction();
           Planet planet = session.get(Planet.class, id);
           session.remove(planet);
           tx1.commit();
           return true;
       }catch (HqlInterpretationException e){
           return false;
       }
    }

    public List<Planet> getAll() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        session.close();
        return planets;
    }
}
