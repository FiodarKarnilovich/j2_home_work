package orm.ex8.table_per_class;

import orm.ex8.table_per_class.dao.PerTableDao;
import orm.ex8.table_per_class.dao.PerTableDaoImpl;

public class Main3Ex8 {

    public static void main(String[] args) {
        PerTableDaoImpl perTableDao = new PerTableDaoImpl();

        Person3 student1 = new Student3(1, "Fiodar", "Karnilovich","BSU", "MMF" );
        Person3 employee1 = new Employee3(2, "Dima", "Petrov", "Amkodor", "Director");

        perTableDao.create(student1);
        perTableDao.create(employee1);

        System.out.println(perTableDao.readAll());

    }
}
