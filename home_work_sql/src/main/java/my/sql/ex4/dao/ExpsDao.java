package my.sql.ex4.dao;

import my.sql.ex4.Exps;

import java.util.List;

public interface ExpsDao {

    void create (Exps exps);

    List<Exps> readAll ();
}
