package my.sql.ex7.dao;

import my.sql.ex7.Expense;
import my.sql.ex7.Receiver;

import java.util.List;

public interface ExpsRecDao {

    Receiver getReceiver(int num);
       List<Receiver> getReceivers();

    Expense getExpense(int num);
    List<Expense> getExpenses();
    void addReceiver(Receiver receiver);
    void addExpense(Expense expense);



}
