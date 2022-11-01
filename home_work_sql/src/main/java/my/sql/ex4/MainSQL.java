package my.sql.ex4;

import my.sql.ex4.dao.ExpsDaoImpl;

import java.util.List;

public class MainSQL {
    public static void main(String[] args) {

        int id = Integer.parseInt(args[0]);
        String date = args[1];
        String store = args[2];
        Double sum = Double.parseDouble(args[3]);

        Exps exps = new Exps(id, date, store, sum);
        ExpsDaoImpl expsDao = new ExpsDaoImpl();
        expsDao.create(exps);
        List<Exps> expsList = expsDao.readAll();
        for (Exps ex : expsList) {
            System.out.println(ex);
        }

    }
}
