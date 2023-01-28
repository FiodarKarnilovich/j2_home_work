package dao;


import entity.Jacket;
import org.springframework.stereotype.Repository;

@Repository
public interface JacketDao {

    void addJacket(Jacket jacket);
    Jacket getJacket(Integer id);
    void deleteJacket(Integer id);
}
