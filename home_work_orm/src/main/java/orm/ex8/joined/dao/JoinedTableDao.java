package orm.ex8.joined.dao;

import orm.ex8.joined.Person2;
import orm.ex8.single_table.Person1;

import java.util.List;

public interface JoinedTableDao {

    void create(Person2 person2);
    List readAll();
}
