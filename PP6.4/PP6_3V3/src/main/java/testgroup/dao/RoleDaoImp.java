package testgroup.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.model.Role;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public Role getOneRole(Long id) {
        return sessionFactory.getCurrentSession().get(Role.class,id);
    }

    @Override
    public List<Role> getAllRole() {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("from Role ");
        return query.getResultList();
    }
}
