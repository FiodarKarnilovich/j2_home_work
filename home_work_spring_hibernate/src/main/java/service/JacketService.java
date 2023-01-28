package service;

import dao.JacketDao;
import entity.Jacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JacketService {

    @Autowired
    private JacketDao jacketDao;

    @Transactional
    public void newJacket(Jacket jacket){
        jacketDao.addJacket(jacket);
    }

    @Transactional
    public Jacket getJacket(Integer id){
        return jacketDao.getJacket(id);
    }

    @Transactional
    public void deleteJacket(Integer id){
        jacketDao.deleteJacket(id);
    }

}
