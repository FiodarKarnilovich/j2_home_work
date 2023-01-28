package orm.load;

import orm.dao.ClothesDaoImpl;
import orm.entity_ex6_7.Jacket;
import orm.entity_ex6_7.JacketDescription;
import orm.entity_ex6_7.Pants;
import orm.entity_ex6_7.PantsDescription;

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
