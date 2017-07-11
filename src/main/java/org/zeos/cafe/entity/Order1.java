package org.zeos.cafe.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alxev on 09.07.2017.
 */
@Entity
@Table(name="order1")
public class Order1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Table1 table;

    private Date startDate;
    private Date endDate;

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

    @Override
    public String toString() {
        return "Order1{" +
                "id=" + id +
                ", table=" + table +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Table1 getTable() {
        return table;
    }

    public void setTable(Table1 table) {
        this.table = table;
    }

}
