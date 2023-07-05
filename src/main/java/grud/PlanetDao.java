package grud;

import entity.Planet;

import java.util.List;

public interface PlanetDao {

    public String findById(String id);

    public void save(Planet planet);

    public void update(String id, String name);

    public void delete(String id);

    public List<Planet> getAll();
}
