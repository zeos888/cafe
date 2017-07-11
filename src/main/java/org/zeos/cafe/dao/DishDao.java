package org.zeos.cafe.dao;

import org.zeos.cafe.entity.Dish;
import org.zeos.cafe.entity.DishType;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
public interface DishDao {
    Dish getById(int id);
    void delete(Dish dish);
    void insert(Dish dish);
    List<Dish> getAll();
    List<Dish> getByType(DishType dishType);
}
