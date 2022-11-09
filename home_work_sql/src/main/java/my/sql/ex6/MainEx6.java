package my.sql.ex6;

import my.sql.ex4_5.Exps;
import my.sql.ex6.dao.Ex6DaoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainEx6 {

    public static void main(String[] args) {

       //список получателей и сумма по ка ждому из них
        Ex6DaoImp ex6DaoImp = new Ex6DaoImp();
        ex6DaoImp.exam6_1();
        ex6DaoImp.exam6_2();
        ex6DaoImp.exam6_3();





    }
}
