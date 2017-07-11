package org.zeos.cafe.dao;

import org.zeos.cafe.entity.DishType;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
public interface DishTypeDao {
    DishType getById(int id);
    void insert(DishType dishType);
    void delete(DishType dishType);
    List<DishType> getAll();
}
