package org.zeos.cafe.bean;

import org.zeos.cafe.entity.Dish;

import java.util.Date;
import java.util.Map;

/**
 * Created by alxev on 09.07.2017.
 */
public class OrderBean {
    private int tableId;
    private Date startDate;
    private Date endDate;
    private Map<Dish, Integer> orderItems;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Map<Dish, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Map<Dish, Integer> orderItems) {
        this.orderItems = orderItems;
    }
}
