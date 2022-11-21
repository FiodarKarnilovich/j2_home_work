package hibernate.dao;

import hibernate.model.Fish;

public interface FishDao {

    void create(Fish fish);
    void delete(Fish fish);
    Fish search(int id);
}
