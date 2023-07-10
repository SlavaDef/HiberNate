package storage;

import entity.Planet;
import grud.PlanetCrudService;

import java.util.List;

public class TestPlanetCrudService {

    public void testFindbyId(PlanetCrudService planetCrudService){
        planetCrudService.findById("EAR1");
    }

    public void testSave(PlanetCrudService planetCrudService){
        Planet planet = new Planet();
        planet.setId("Sun32");
        planet.setName("Sunny");
        planetCrudService.save(planet);
    }

    public void testGetAll(PlanetCrudService planetCrudService){
        List<Planet> planets = planetCrudService.getAll();
        System.out.println(planets);
    }

    public void testUpdate(PlanetCrudService planetCrudService){
        planetCrudService.update("MAR22", "Uran25");
    }
    public void testDelate(PlanetCrudService planetCrudService){
        planetCrudService.delete("MAR22");
    }


    public static void main(String[] args) {
        // new TestPlanetCrudService().testFindbyId(new PlanetCrudService());
       // new TestPlanetCrudService().testGetAll(new PlanetCrudService());
        new TestPlanetCrudService().testSave(new PlanetCrudService()); // ??????
      // new TestPlanetCrudService().testUpdate(new PlanetCrudService());
      //  new TestPlanetCrudService().testDelate(new PlanetCrudService());


    }
}

// PersistenceException: Converting `org.hibernate.id.IdentifierGenerationException` to JPA
// `PersistenceException` : ids for this class must be manually assigned before calling save():
// entity.Planet