package my.sql.ex6.dao;

import my.sql.MySqlConnection;
import my.sql.ex4_5.Exps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex6DaoImp implements Ex6Dao {

    private MySqlConnection myConnection;

    public Ex6DaoImp()  {
        try {
            this.myConnection = new MySqlConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void exam6_1() {

        Map<String, Double> storeList = new HashMap<>();

        try (Connection connection = myConnection.getConnection();
             Statement statement = connection.createStatement()){

                ResultSet resultSet = statement.executeQuery("SELECT store, SUM(sum)  FROM exps GROUP BY store");
        while (resultSet.next()) {
            storeList.put(resultSet.getString("store"), resultSet.getDouble("SUM(sum)"));
        }
            System.out.println("Магазины и общая сумма по ним");
            System.out.println(storeList);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exam6_2() {
        Map<String, Double> storeList = new HashMap<>();

        try (Connection connection = myConnection.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT date, SUM(sum) FROM exps WHERE date in (SELECT date FROM exps WHERE sum in (SELECT MAX(sum) FROM exps)) GROUP BY date;");
            while (resultSet.next()) {
                storeList.put(resultSet.getString("date"), resultSet.getDouble("SUM(sum)"));
            }
            System.out.println("Сумма платежей за день, когда был максимальный платеж");
            System.out.println(storeList);

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void exam6_3() {
        Map<String, Double> storeList = new HashMap<>();

        try (Connection connection = myConnection.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT date, MAX(sum) FROM exps GROUP BY date HAVING SUM(sum) = (SELECT SUM(sum) FROM exps GROUP BY date ORDER BY SUM(sum) DESC LIMIT 1)");
            while (resultSet.next()) {
                storeList.put(resultSet.getString("date"), resultSet.getDouble("MAX(sum)"));
            }
            System.out.println("Максимальный платеж за день, когда сумма была максимальная");
            System.out.println(storeList);

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
