package grud;

import entity.Planet;

import java.util.List;

public interface PlanetDao {

    public Planet findById(String id);

    public Planet save(Planet planet);

    public Planet update(String id, String name);

    public Planet delete(String id);

    public List<Planet> getAll();
}
