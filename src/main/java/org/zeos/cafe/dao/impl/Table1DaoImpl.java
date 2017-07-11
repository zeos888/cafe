package org.zeos.cafe.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zeos.cafe.dao.OrderDao;
import org.zeos.cafe.dao.Table1Dao;
import org.zeos.cafe.entity.Area;
import org.zeos.cafe.entity.Table1;
import org.zeos.cafe.exception.AlreadyOccupiedException;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
@Repository
public class Table1DaoImpl implements Table1Dao {
    @Autowired
    private OrderDao orderDao;

    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    public Table1 getById(int id) {
        return session.get(Table1.class, id);
    }

    public void insert(Table1 table1) {
        session.saveOrUpdate(table1);
    }

    public void delete(Table1 table1) {
        session.delete(table1);
    }

    public List<Table1> getByArea(Area area) {
        return (List<Table1>) session.createQuery("from Table1 where areaId = :areaId").setParameter("areaId", area.getId()).list();
    }

    public List<Table1> getAll() {
        return (List<Table1>) session.createQuery("from Table1").list();
    }

    public void occupy(Table1 table1) throws AlreadyOccupiedException {
        if (table1.isReserved()){
            table1.setReserved(true);
            session.saveOrUpdate(table1);
        } else {
            throw new AlreadyOccupiedException();
        }
    }

    public void release(Table1 table1) throws AlreadyOccupiedException {
        if (!table1.isReserved() || (orderDao.getActiveByTable(table1) != null)){
            table1.setReserved(false);
            session.saveOrUpdate(table1);
        } else {
            throw new AlreadyOccupiedException();
        }
    }
}
