package orm.ex8.single_table;

import orm.ex8.single_table.dao.SingleTableDaoImpl;

public class Main1Ex8 {

    public static void main(String[] args) {
        SingleTableDaoImpl singleTableDao = new SingleTableDaoImpl();

        Person1 student1 = new Student1(1, "Fiodar", "Karnilovich","BSU", "MMF" );
        Person1 employee1 = new Employee1(2, "Dima", "Petrov", "Amkodor", "Director");

//        singleTableDao.create(student1);
//        singleTableDao.create(employee1);

        System.out.println(singleTableDao.readAll());

    }
}
