package org.zeos.cafe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeos.cafe.dao.AreaDao;
import org.zeos.cafe.dao.DishTypeDao;
import org.zeos.cafe.dao.Table1Dao;
import org.zeos.cafe.entity.Area;
import org.zeos.cafe.entity.Table1;
import org.zeos.cafe.service.CafeService;

import java.util.List;

/**
 * Created by alxev on 10.07.2017.
 */
@Service("cafeService")
public class CafeServiceImpl implements CafeService {
    @Autowired
    private AreaDao areaDao;

    @Autowired
    private Table1Dao table1Dao;

    @Autowired
    private DishTypeDao dishTypeDao;

    public List<Area> findAllArea() {
        return areaDao.getAll();
    }

    public List<Table1> findAllTable1() {
        return table1Dao.getAll();
    }

    public List<Table1> findTable1ByAreaId(int areaId) {
        return table1Dao.getByArea(areaDao.getById(areaId));
    }
}
