package org.zeos.cafe.entity;

import javax.persistence.*;

/**
 * Created by alxev on 09.07.2017.
 */
@Entity
@Table(name = "orderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Order1 order1;

    @ManyToOne
    private Dish dish;

    private int quantity;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order1=" + order1 +
                ", dish=" + dish +
                ", quantity=" + quantity +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order1 getOrder1() {
        return order1;
    }

    public void setOrder1(Order1 order1) {
        this.order1 = order1;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
