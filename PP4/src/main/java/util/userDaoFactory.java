package util;

import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;

import java.io.IOException;
import java.util.Properties;

public class userDaoFactory {
    private Properties properties = new Properties();
    private UserDAO userDAO;

    public UserDAO getDAO() {
        try {
            properties.load(userDaoFactory.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String input = properties.getProperty("userDAO");
        if (input.equals("hibernateDAO")) {
            userDAO = new UserHibernateDAO();
        } else if (input.equals("jdbcDAO")) {
            userDAO = new UserJdbcDAO(DBHelper.getMysqlConnection());
        }
        return userDAO;
    }
}




