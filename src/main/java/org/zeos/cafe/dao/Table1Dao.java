package org.zeos.cafe.dao;

import org.zeos.cafe.entity.Area;
import org.zeos.cafe.entity.Table1;
import org.zeos.cafe.exception.AlreadyOccupiedException;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
public interface Table1Dao {
    Table1 getById(int id);
    void insert(Table1 table1);
    void delete(Table1 table1);
    List<Table1> getAll();
    List<Table1> getByArea(Area area);
    void occupy(Table1 table1) throws AlreadyOccupiedException;
    void release(Table1 table1) throws AlreadyOccupiedException;
}
