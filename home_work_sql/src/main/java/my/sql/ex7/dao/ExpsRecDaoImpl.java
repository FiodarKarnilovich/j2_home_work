package my.sql.ex7.dao;

import my.sql.MySqlConnection;
import my.sql.ex7.Expense;
import my.sql.ex7.Receiver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpsRecDaoImpl implements ExpsRecDao {

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

        Receiver receiver = new Receiver();
        try (Connection connection = myConnection.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT * from receiver WHERE id=" + num + ";");

            while (resultSet.next()) {
                receiver.setId(resultSet.getInt("id"));
                receiver.setStore(resultSet.getString("store"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receiver;
    }

    @Override
    public List<Receiver> getReceivers() {
        List<Receiver> receiverList = new ArrayList<>();
        Receiver receiver = new Receiver();
        try (Connection connection = myConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * from receiver");
            while (resultSet.next()) {

                receiver.setId(resultSet.getInt("id"));
                receiver.setStore(resultSet.getString("store"));
                receiverList.add(receiver);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return receiverList;
    }

    @Override
    public Expense getExpense(int num) {

        Expense expense = new Expense();
        try (Connection connection = myConnection.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT * from expense WHERE id=" + num + ";");

            while (resultSet.next()) {
                expense.setId(resultSet.getInt("id"));
                expense.setDate(resultSet.getString("date"));
                expense.setStore_id(resultSet.getInt("id_store"));
                expense.setSum(resultSet.getDouble("sum"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expense;
    }

    @Override
    public List<Expense> getExpenses() {
        List<Expense> expenseList = new ArrayList<>();
        Expense expense = new Expense();
        try (Connection connection = myConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * from expense");
            while (resultSet.next()) {

                expense.setId(resultSet.getInt("id"));
                expense.setDate(resultSet.getString("date"));
                expense.setStore_id(resultSet.getInt("id_store"));
                expense.setSum(resultSet.getDouble("sum"));
                expenseList.add(expense);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expenseList;
    }

    @Override
    public void addReceiver(Receiver receiver) {
        try (Connection connection = myConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO receiver (id, store) VALUES (?,?)")) {
            preparedStatement.setInt(1, receiver.getId());
            preparedStatement.setString(2, receiver.getStore());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addExpense(Expense expense) {

        try (Connection connection = myConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO expense (id, date, id_store, sum) VALUES (?,?, ?, ?)")) {
            preparedStatement.setInt(1, expense.getId());
            preparedStatement.setString(2, expense.getDate());
            preparedStatement.setInt(3, expense.getStore_id());
            preparedStatement.setDouble(4, expense.getSum());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
