package my.sql.ex4_5.dao;

import my.sql.MySqlConnection;
import my.sql.ex4_5.Exps;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpsDaoImpl implements ExpsDao{

    private MySqlConnection myConnection;

    public ExpsDaoImpl()  {
       try {
           this.myConnection = new MySqlConnection();
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
    }

    @Override
    public void create(Exps exps) {
        try (Connection connection = myConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO exps (id, date, store, sum) VALUES (?,?,?,?)")){
            preparedStatement.setInt(1, exps.getId());
            preparedStatement.setString(2, exps.getDate());
            preparedStatement.setString(3, exps.getStore());
            preparedStatement.setDouble(4, exps.getSum());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Exps> readAll() {

        List<Exps> expsList = new ArrayList<>();
        try (Connection connection = myConnection.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * from exps");
            while (resultSet.next()){
                Exps exps = new Exps();
                exps.setId(resultSet.getInt("id"));
                exps.setDate(resultSet.getString("date"));
                exps.setStore(resultSet.getString("store"));
                exps.setSum(resultSet.getDouble("sum"));
                expsList.add(exps);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expsList;
    }
}
