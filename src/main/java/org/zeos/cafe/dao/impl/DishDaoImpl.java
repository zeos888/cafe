package org.zeos.cafe.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zeos.cafe.dao.DishDao;
import org.zeos.cafe.entity.Dish;
import org.zeos.cafe.entity.DishType;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
@Repository
public class DishDaoImpl implements DishDao {
    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    public Dish getById(int id) {
        return session.get(Dish.class, id);
    }

    public void delete(Dish dish) {
        session.delete(dish);
    }

    public void insert(Dish dish) {
        session.saveOrUpdate(dish);
    }
    public List<Dish> getAll() {
        return (List<Dish>) session.createQuery(" from Dish").list();
    }

    public List<Dish> getByType(DishType dishType) {
        return (List<Dish>) session.createQuery("from Dish where dishTypeId = :dishTypeId").setParameter("dishTypeId", dishType.getId()).list();
    }
}
