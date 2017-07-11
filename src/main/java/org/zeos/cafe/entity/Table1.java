package org.zeos.cafe.entity;

import javax.persistence.*;

/**
 * Created by alxev on 09.07.2017.
 */
@Entity
@Table(name="table1")
public class Table1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Area area;

    private String name;
    private boolean reserved;

    @Override
    public String toString() {
        return "Table1{" +
                "id=" + id +
                ", area=" + area +
                ", name='" + name + '\'' +
                ", reserved=" + reserved +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
