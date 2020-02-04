package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;


import java.util.ArrayList;
import java.util.List;

public class UserHibernateDAO implements UserDAO {
//    Session session;
    private SessionFactory sessionFactory = DBHelper.getSessionFactory();

    public UserHibernateDAO() {
//        this.session = session;
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
//        List<User> user = new ArrayList<User>();
        try (Session session = sessionFactory.openSession()) {
//            return (ArrayList<User>) session.createCriteria(User.class).list();
//            user = ;
            return (ArrayList<User>) session.createQuery("from User ").list();
        }
    }

    @Override
    public boolean deleteUserFromIdDAO(int id) {
        Transaction transaction;
        try (Session session = sessionFactory.openSession()) {
            User user = session.get(User.class, id);
//            transaction = session.getTransaction();
//            transaction.begin();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
//            transaction.commit();
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