
import entity.Planet;
import grud.PlanetCrudService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlanetCrudServiceTest {

    PlanetCrudService planetCrudService;

    Planet getAnyPlanet() {
        return planetCrudService.getAll().stream().findAny().orElse(null);
    }

    @BeforeEach
    public void beforeEach() {
        planetCrudService = new PlanetCrudService();
    }

    @Test
    public void findById() {
        Planet planet = planetCrudService.findById("EAR");
        assertEquals("EARTH", planet.getName());
    }

    @Test
    public void getAllPlanets() {
        List<Planet> planetList = planetCrudService.getAll();
        System.out.println("Planet List: " + planetList);
    }

    @Test
    public void delatePlanetById() {
        Planet planet = getAnyPlanet();
        String id = planet.getId();
        planetCrudService.delete(id);
        assertEquals(null, planetCrudService.findById(id));
    }

    @Test
    public void savePlanet() {
        Planet planet = new Planet();
        planet.setId("SUN2");
        planet.setName("SUNNY2");
        planetCrudService.save(planet);
        String name = planet.getName();
        assertEquals("SUNNY2", name);
    }

    @Test
    public void updatePlanet(){
        Planet planet = getAnyPlanet();
        planetCrudService.update(planet);
        Planet updatedPlanet = planetCrudService.findById(planet.getId());
        assertEquals(planet.getName(),updatedPlanet.getName());


    }

}
