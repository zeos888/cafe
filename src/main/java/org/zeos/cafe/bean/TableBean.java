package org.zeos.cafe.bean;

/**
 * Created by alxev on 09.07.2017.
 */
public class TableBean {
    private int areaId;
    private String name;
    private boolean reserved;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
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
