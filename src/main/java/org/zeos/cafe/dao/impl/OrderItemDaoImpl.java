package org.zeos.cafe.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zeos.cafe.dao.OrderItemDao;
import org.zeos.cafe.entity.Dish;
import org.zeos.cafe.entity.Order1;
import org.zeos.cafe.entity.OrderItem;
import org.zeos.cafe.exception.NotEnoughException;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
@Repository
public class OrderItemDaoImpl implements OrderItemDao {
    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    public OrderItem getById(int id) {
        return session.get(OrderItem.class, id);
    }

    public List<OrderItem> getByOrder(Order1 order1) {
        return (List<OrderItem>) session.createQuery("from OrderItem where order1Id = :orderId").setParameter("orderId", order1.getId()).list();
    }

    public void insert(OrderItem orderItem) {
        session.saveOrUpdate(orderItem);
    }

    public void delete(OrderItem orderItem) {
        session.delete(orderItem);
    }

    public void plusOne(OrderItem orderItem) throws NotEnoughException {
        Dish dish = orderItem.getDish();
        int left = dish.getQuantity();
        if (left > 0){
            dish.setQuantity(left - 1);
            orderItem.setQuantity(orderItem.getQuantity() + 1);
        } else {
            throw new NotEnoughException();
        }
    }

    public void minusOne(OrderItem orderItem) throws NotEnoughException {
        Dish dish = orderItem.getDish();
        int ordered = orderItem.getQuantity();
        if (ordered <= 0){
            orderItem.setQuantity(ordered - 1);
            dish.setQuantity(dish.getQuantity() + 1);
        } else {
            throw new NotEnoughException();
        }
    }
}
