package orm.dao;

import orm.entity_ex6_7.Jacket;
import orm.entity_ex6_7.Pants;

public interface ClothesDao<T> {

    void create(T object);
    Jacket readJ(Integer id);

    Pants readP(Integer id);
}
