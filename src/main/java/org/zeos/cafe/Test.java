package org.zeos.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeos.cafe.dao.*;
import org.zeos.cafe.entity.Area;
import org.zeos.cafe.entity.Dish;
import org.zeos.cafe.entity.DishType;
import org.zeos.cafe.entity.Table1;

/**
 * Created by alxev on 09.07.2017.
 */
public class Test {

    @Autowired
    private AreaDao areaDao;
    @Autowired
    private DishTypeDao dishTypeDao;
    @Autowired
    private DishDao dishDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private Table1Dao table1Dao;

    public void init(){
        Area area1 = new Area();
        area1.setName("Main");
        areaDao.insert(area1);
        Area area2 = new Area();
        area2.setName("Street");
        areaDao.insert(area2);

        Table1 table1 = new Table1();
        table1.setArea(area1);
        table1.setName("Table #1");
        table1Dao.insert(table1);
        Table1 table2 = new Table1();
        table2.setArea(area1);
        table2.setName("Table #2");
        table1Dao.insert(table2);
        Table1 table3 = new Table1();
        table3.setName("Table #3");
        table3.setArea(area2);

        DishType dishType = new DishType();
        dishType.setName("Food");
        dishTypeDao.insert(dishType);

        Dish dish = new Dish();
        dish.setDishType(dishType);
        dish.setQuantity(1);
        dish.setName("Steak");
        dish.setPrice(900d);


    }
}
