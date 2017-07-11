package org.zeos.cafe.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zeos.cafe.dao.DishTypeDao;
import org.zeos.cafe.entity.DishType;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
@Repository
public class DishTypeDaoImpl implements DishTypeDao {
    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    public DishType getById(int id) {
        return session.get(DishType.class, id);
    }

    public void insert(DishType dishType) {
        session.saveOrUpdate(dishType);
    }

    public List<DishType> getAll() {
        return (List<DishType>)session.createQuery("from DishType").list();
    }

    public void delete(DishType dishType) {
        session.delete(dishType);
    }
}
