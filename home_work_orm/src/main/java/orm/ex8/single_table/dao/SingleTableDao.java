package orm.ex8.single_table.dao;

import orm.ex8.single_table.Person1;

import java.util.List;

public interface SingleTableDao {

    void create(Person1 person1);
    List readAll();
}
