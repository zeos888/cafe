package org.zeos.cafe.entity;

import javax.persistence.*;

/**
 * Created by alxev on 09.07.2017.
 */
@Entity
@Table(name = "dishType")
public class DishType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Override
    public String toString() {
        return "DishType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
