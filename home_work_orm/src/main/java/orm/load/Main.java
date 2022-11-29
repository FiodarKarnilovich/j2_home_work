package orm.load;

import orm.dao.ClothesDaoImpl;
import orm.entity.Jacket;
import orm.entity.JacketDescription;
import orm.entity.Pants;
import orm.entity.PantsDescription;

public class Main {

    public static void main(String[] args) {

        Pants pants= new Pants(null, "Fjallraven", 500.0, new PantsDescription("red", "XL"));
        Jacket jacket = new Jacket(null, "Fjallraven", 350.0, new JacketDescription("blue", "M"));

        ClothesDaoImpl clothesDao = new ClothesDaoImpl();

        clothesDao.create(pants);
        clothesDao.create(jacket);
        System.out.println(clothesDao.readJ(1));
        System.out.println(clothesDao.readP(1));

        System.out.println("-----------------------------------------------");
        System.out.println(pants);
        System.out.println(jacket);

    }
}
