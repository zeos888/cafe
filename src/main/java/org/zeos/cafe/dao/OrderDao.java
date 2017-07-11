package org.zeos.cafe.dao;

import org.zeos.cafe.entity.Order1;
import org.zeos.cafe.entity.Table1;
import org.zeos.cafe.exception.AlreadyClosedException;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
public interface OrderDao {
    Order1 getById(int id);
    List<Order1> getAll();
    List<Order1> getByTable(Table1 table1);
    Order1 getActiveByTable(Table1 table1);
    void insert(Order1 order1);
    void delete(Order1 order1) throws AlreadyClosedException;
    void close(Order1 order1) throws AlreadyClosedException;
}
