package my.sql.ex4_5.dao;

import my.sql.ex4_5.Exps;

import java.util.List;

public interface ExpsDao {

    void create (Exps exps);

    List<Exps> readAll ();
}
