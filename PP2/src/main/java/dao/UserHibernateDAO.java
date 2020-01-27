package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;


import java.util.ArrayList;
import java.util.List;

public class UserHibernateDAO implements UserDAO {
    Session session;
    private SessionFactory sessionFactory = DBHelper.getSessionFactory();

    public UserHibernateDAO(Session session) {
        this.session = session;
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
        List<User> user;
        try (Session session = sessionFactory.openSession()) {
            user = session.createQuery("from User ").list();
            return (ArrayList<User>) user;
        }
    }

    @Override
    public boolean deleteUserFromIdDAO(int id) {
        Transaction transaction;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
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