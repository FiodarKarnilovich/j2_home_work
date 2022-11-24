package hibernate.dao;

import hibernate.model.Fish;
import lombok.SneakyThrows;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FishDaoImplTest extends BaseDaoTest {

    FishDaoImpl targetObject;

    @Before
    public void setUp() throws Exception {
       targetObject = new FishDaoImpl(testSessionFactory);
    }

    @After
    public void tearDown() throws Exception {
        targetObject = null;
//        Connection connection = testMysqlJdbcDataSource.getConnection();
//        connection.createStatement().executeQuery("delete from Fish");
//        connection.close();

    }

    @Test
    @SneakyThrows
    public void testCreate() {
        Connection connection = testMysqlJdbcDataSource.getConnection();

        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from fish;");
        resultSet.next();
        int sizeTable = resultSet.getInt(1);
        assertEquals(0, sizeTable);

        Fish fish = new Fish();
        fish.setName("kilka");
        fish.setPrice(3.95);

        targetObject.create(fish);

        resultSet = connection.createStatement().executeQuery("select count(*) from fish;");
        resultSet.next();
        int sizeNewTable = resultSet.getInt(1);
        assertEquals(1, sizeNewTable);

        connection.close();
    }

    @Test
    @SneakyThrows
    public void delete(){

        IDataSet fishDataSet = new FlatXmlDataSetBuilder()
                .build(getClass().getResourceAsStream("FishDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, fishDataSet);

        List<Fish> listFish = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
           listFish.add(targetObject.search(i));
           targetObject.delete(listFish.get(i-1));
        }
        Connection connection = testMysqlJdbcDataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from fish;");
        resultSet.next();

        int sizeNewTable = resultSet.getInt(1);
        assertEquals(0, sizeNewTable);

        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection, fishDataSet);

        connection.close();
    }

    @Test
    @SneakyThrows
    public void testDelete() {

        Fish fish = new Fish();
        fish.setName("kilka");
        fish.setPrice(3.95);

        targetObject.create(fish);
        Connection connection = testMysqlJdbcDataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from fish;");
        resultSet.next();

        int sizeOldTable = resultSet.getInt(1) - 1;

        targetObject.delete(fish);
        resultSet = connection.createStatement().executeQuery("select count(*) from fish;");
        resultSet.next();

        int sizeNewTable = resultSet.getInt(1);
        assertEquals(sizeOldTable, sizeNewTable);

        connection.close();
    }


    @Test
    @SneakyThrows
    public void testSearch() {
        IDataSet fishDataSet = new FlatXmlDataSetBuilder()
                .build(getClass().getResourceAsStream("FishDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, fishDataSet);


        Fish fish = targetObject.search(2);
        assertEquals("seabass".toUpperCase(), fish.getName());

        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection, fishDataSet);


    }
}