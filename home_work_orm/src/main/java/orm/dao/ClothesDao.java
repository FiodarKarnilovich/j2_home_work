package orm.dao;

import orm.entity.Jacket;
import orm.entity.Pants;

public interface ClothesDao<T> {

    void create(T object);
    Jacket readJ(Integer id);

    Pants readP(Integer id);
}
