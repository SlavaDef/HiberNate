package grud;

import entity.Planet;

import java.util.List;

public interface PlanetDao {

    public Planet findById(String id);

    public Planet save(Planet planet);

    public boolean update(Planet planet);

    public boolean delete(String id);

    public List<Planet> getAll();
}
