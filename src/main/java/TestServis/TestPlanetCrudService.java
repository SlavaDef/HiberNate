package TestServis;

import entity.Planet;
import grud.PlanetCrudService;

import java.util.List;

public class TestPlanetCrudService {

    public Planet testFindbyId(PlanetCrudService planetCrudService) {

        return planetCrudService.findById("EAR");
    }

    public Planet testSave(PlanetCrudService planetCrudService) {
        Planet planet = new Planet();
        planet.setId("Sun32");
        planet.setName("Sunny");
        planetCrudService.save(planet);
        return planet;
    }

    public List<Planet> testGetAll(PlanetCrudService planetCrudService) {
        return planetCrudService.getAll();
    }

    public Planet testUpdate(PlanetCrudService planetCrudService) {

        return planetCrudService.update("MAR", "MARS2");
    }

    public Planet testDelate(PlanetCrudService planetCrudService) {

        return planetCrudService.delete("MAR");
    }


    public static void main(String[] args) {
        // new TestPlanetCrudService().testSave(new PlanetCrudService());
        // new TestPlanetCrudService().testFindbyId(new PlanetCrudService());
        // new TestPlanetCrudService().testGetAll(new PlanetCrudService());
        //  new TestPlanetCrudService().testUpdate(new PlanetCrudService());
        // new TestPlanetCrudService().testDelate(new PlanetCrudService());

    }
}
