package org.zeos.cafe.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zeos.cafe.dao.AreaDao;
import org.zeos.cafe.entity.Area;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
@Repository
public class AreaDaoImpl implements AreaDao{
    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    public Area getById(int id) {
        return session.get(Area.class, id);
    }

    public void insert(Area area) {
        session.saveOrUpdate(area);
    }

    public List<Area> getAll() {
        return (List<Area>) session.createQuery("from Area").list();
    }
}
