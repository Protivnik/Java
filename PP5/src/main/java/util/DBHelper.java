package util;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBHelper {
    private static DBHelper dbHelper;
    private static SessionFactory sessionFactory;
    private static Connection connection;

    private DBHelper(){
    }


    public static DBHelper getDbHelper() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    public static Connection getConnection() {
        if (connection == null) {
            connection = getMysqlConnection();
        }
        return getMysqlConnection();
    }

    @SuppressWarnings("UnusedDeclaration")
    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        Properties property = new Properties();

        try {
            property.load(DBHelper.class.getClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        configuration.setProperty(property.getProperty("dialect"), property.getProperty("dialectDB"));
        configuration.setProperty(property.getProperty("driver"), property.getProperty("driverDB"));
        configuration.setProperty(property.getProperty("url"), property.getProperty("urlDB"));
        configuration.setProperty(property.getProperty("username"), property.getProperty("usernameDB"));
        configuration.setProperty(property.getProperty("password"), property.getProperty("passwordDB"));
        configuration.setProperty(property.getProperty("show_sql"), property.getProperty("show_sqlDB"));
        configuration.setProperty(property.getProperty("hdm2ddl"), property.getProperty("hdm2ddlDB"));
        return configuration;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = DBHelper.getConfiguration();
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static Connection getMysqlConnection() {
        Properties property = new Properties();

        try {
            property.load(DBHelper.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            DriverManager.registerDriver((Driver) Class.forName(property.getProperty("jdbcDriver")).newInstance());

            StringBuilder url = new StringBuilder();
            url.append(property.getProperty("jdbcDbType")).             //db type
                    append(property.getProperty("jdbcHost")).           //host name
                    append(property.getProperty("jdbcPort")).           //port
                    append(property.getProperty("jdbcDbName")).         //db name
                    append(property.getProperty("jdbcLogin")).          //login
                    append(property.getProperty("jdbcPassword")).       //password
                    append(property.getProperty("jdbcServerTime"));     //setup server time
            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

}
