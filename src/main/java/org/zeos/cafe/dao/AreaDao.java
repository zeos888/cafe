package org.zeos.cafe.dao;

import org.zeos.cafe.entity.Area;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
public interface AreaDao {
    Area getById(int id);
    void insert(Area area);
    List<Area> getAll();
}
