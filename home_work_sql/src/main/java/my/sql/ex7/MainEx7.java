package my.sql.ex7;

import my.sql.ex7.dao.ExpsRecDaoImpl;

import static javax.sound.midi.MidiSystem.getReceiver;

public class MainEx7 {
    public static void main(String[] args) {

        ExpsRecDaoImpl expsRecDao = new ExpsRecDaoImpl();

        expsRecDao.addReceiver(new Receiver(4,"SPAR"));
        expsRecDao.addExpense(new Expense(4,"11-11-2021", 4, 250.15));
        System.out.println(expsRecDao.getReceiver(2));
        System.out.println(expsRecDao.getReceivers());
        System.out.println(expsRecDao.getExpense(1));
        System.out.println(expsRecDao.getExpenses());


    }
}
