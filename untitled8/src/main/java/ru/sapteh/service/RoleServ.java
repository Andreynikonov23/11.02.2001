package ru.sapteh.service;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;

import javax.management.relation.Role;
import java.util.List;

public class RoleServ implements DAO <Role, Integer> {
    private final SessionFactory factory;

    public RoleServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Role role) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Role role) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(role);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Role role) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(role);
            session.getTransaction().commit();
        }
    }

        @Override
        public Role read (Integer id){
        try (Session session = factory.openSession()) {
            Role result = session.get(Role.class, id);
            if (result != null) {
                Hibernate.initialize(result.getRoleValue());
            }
        }
            return null;
        }

        @Override
        public List<Role> findByAll () {
        try (Session session = factory.openSession()) {
            Query<Role> result = session.createQuery("FROM Role");
            return result.list();
        }
        }
    }