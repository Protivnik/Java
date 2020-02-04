package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;


import java.util.ArrayList;
import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private SessionFactory sessionFactory = DBHelper.getSessionFactory();

    public UserHibernateDAO() {
    }


    @Override
    public boolean addUserDAO(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.save(user);
            return true;
        }
    }

    @Override
    public ArrayList<User> getUserDAO() {
        try (Session session = sessionFactory.openSession()) {
//            return (ArrayList<User>) session.createCriteria(User.class).list();
            return (ArrayList<User>) session.createQuery("from User ").list();
        }
    }

    @Override
    public boolean deleteUserFromIdDAO(int id) {
        try (Session session = sessionFactory.openSession()) {
            User user = session.get(User.class, id);
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public User searchUserFromIdDAO(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public boolean editUserDAO(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return true;
        }
    }
}