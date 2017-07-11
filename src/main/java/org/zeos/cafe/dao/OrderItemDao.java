package org.zeos.cafe.dao;

import org.zeos.cafe.entity.Order1;
import org.zeos.cafe.entity.OrderItem;
import org.zeos.cafe.exception.NotEnoughException;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
public interface OrderItemDao {
    OrderItem getById(int id);
    List<OrderItem> getByOrder(Order1 order1);
    void insert(OrderItem orderItem);
    void delete(OrderItem orderItem);
    void plusOne(OrderItem orderItem) throws NotEnoughException;
    void minusOne(OrderItem orderItem) throws NotEnoughException;
}
