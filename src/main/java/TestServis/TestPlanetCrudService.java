package TestServis;

import entity.Planet;
import grud.PlanetCrudService;

import java.util.List;

public class TestPlanetCrudService {

    public void testFindbyId(PlanetCrudService planetCrudService) {

        String name = planetCrudService.findById("EAR");
        System.out.println(name);
    }

    public void testSave(PlanetCrudService planetCrudService) {
        Planet planet = new Planet();
        planet.setId("Sun32");
        planet.setName("Sunny");
        planetCrudService.save(planet);
    }

    public void testGetAll(PlanetCrudService planetCrudService) {
        List<Planet> planets = planetCrudService.getAll();
        System.out.println(planets);
    }

    public void testUpdate(PlanetCrudService planetCrudService) {
        planetCrudService.update("MAR", "MARS2");
    }

    public void testDelate(PlanetCrudService planetCrudService) {
        planetCrudService.delete("MAR");
    }


    public static void main(String[] args) {
        // new TestPlanetCrudService().testSave(new PlanetCrudService());
        // new TestPlanetCrudService().testFindbyId(new PlanetCrudService());
         new TestPlanetCrudService().testGetAll(new PlanetCrudService());
        //  new TestPlanetCrudService().testUpdate(new PlanetCrudService());
        // new TestPlanetCrudService().testDelate(new PlanetCrudService());

    }
}
