package ru.sapteh.service;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.UserRole;

import java.util.List;

public class UserRoleServ implements DAO<UserRole, Integer> {
    private final SessionFactory factory;
    public UserRoleServ (SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(UserRole userRole) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(userRole);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(UserRole userRole) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(userRole);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(UserRole userRole) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(userRole);
            session.getTransaction().commit();
        }
    }

    @Override
    public UserRole read(Integer id) {
        try (Session session = factory.openSession()) {
            UserRole result = session.get(UserRole.class, id);
            if(result != null) {
                Hibernate.initialize(result.getRole());
                Hibernate.initialize(result.getUser());
            }
            return result;
        }
    }

    @Override
    public List<UserRole> findByAll() {
        try (Session session = factory.openSession()) {
            Query<UserRole> userRoleQuery = session.createQuery("FROM USerList");
            return userRoleQuery.list();
        }
    }
}
