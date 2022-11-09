package my.sql.ex7.dao;

import my.sql.ex7.Expense;
import my.sql.ex7.Receiver;

import java.util.List;

public interface ExpsRecDao {

    Receiver getReceiver(int num);
    List<Receiver> getReceiver();
    Expense getExpense(int num);
    List<Expense> getExpenses();
    int addReceiver(Receiver receiver);
    int addExpense(Expense expense);


}
