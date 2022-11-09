package my.sql.ex7.dao;

import my.sql.MySqlConnection;
import my.sql.ex7.Expense;
import my.sql.ex7.Receiver;

import java.util.List;

public class ExpsRecDaoImpl implements ExpsRecDao{

    private MySqlConnection myConnection;

    public ExpsRecDaoImpl() {
        try {
            this.myConnection = new MySqlConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Receiver getReceiver(int num) {
        return null;
    }

    @Override
    public List<Receiver> getReceiver() {
        return null;
    }

    @Override
    public Expense getExpense(int num) {
        return null;
    }

    @Override
    public List<Expense> getExpenses() {
        return null;
    }

    @Override
    public int addReceiver(Receiver receiver) {
        return 0;
    }

    @Override
    public int addExpense(Expense expense) {
        return 0;
    }
}
