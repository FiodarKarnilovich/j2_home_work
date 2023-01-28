package orm.ex8.joined;

import orm.ex8.joined.dao.JoinedTableDaoImpl;
import orm.ex8.single_table.Employee1;
import orm.ex8.single_table.Person1;
import orm.ex8.single_table.Student1;
import orm.ex8.single_table.dao.SingleTableDaoImpl;

public class Main2ex8 {
    public static void main(String[] args) {
        JoinedTableDaoImpl joinedTableDao = new JoinedTableDaoImpl();

        Person2 student1 = new Student2(1, "Fiodar", "Karnilovich","BSU", "MMF" );
        Person2 employee1 = new Employee2(2, "Dima", "Petrov", "Amkodor", "Director");

        joinedTableDao.create(student1);
        joinedTableDao.create(employee1);

        System.out.println(joinedTableDao.readAll());

    }
}
