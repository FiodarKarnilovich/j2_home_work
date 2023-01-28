package orm.ex8.table_per_class.dao;


import orm.ex8.table_per_class.Person3;

import java.util.List;

public interface PerTableDao {

    void create(Person3 person3);
    List readAll();
}
