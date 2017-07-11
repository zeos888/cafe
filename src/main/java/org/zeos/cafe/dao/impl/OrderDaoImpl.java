package org.zeos.cafe.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zeos.cafe.dao.OrderDao;
import org.zeos.cafe.entity.Order1;
import org.zeos.cafe.entity.Table1;
import org.zeos.cafe.exception.AlreadyClosedException;

import java.util.Date;
import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
@Repository
public class OrderDaoImpl implements OrderDao {
    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    public Order1 getById(int id) {
        return session.get(Order1.class, id);
    }

    public List<Order1> getAll() {
        return (List<Order1>) session.createQuery("from Order1");
    }

    public List<Order1> getByTable(Table1 table1) {
        return (List<Order1>) session.createQuery("from Order1 where table1Id = :tableId").setParameter("tableId", table1.getId()).list();
    }

    public void insert(Order1 order1) {
        session.saveOrUpdate(order1);
    }

    public void delete(Order1 order1) throws AlreadyClosedException{
        if (order1.getEndDate() != null){
            session.delete(order1);
        } else {
            throw new AlreadyClosedException();
        }
    }

    public void close(Order1 order1) throws AlreadyClosedException{
        if (order1.getEndDate() != null){
            order1.setEndDate(new Date());
            session.saveOrUpdate(order1);
        } else {
            throw new AlreadyClosedException();
        }
    }

    public Order1 getActiveByTable(Table1 table1) {
        List<Order1> order1s = getByTable(table1);
        Order1 activeOrder1 = null;
        for (Order1 order1 : order1s){
            if (order1.getEndDate() == null){
                activeOrder1 = order1;
            }
        }
        return activeOrder1;
    }
}
