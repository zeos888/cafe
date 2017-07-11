package org.zeos.cafe.service;

import org.springframework.stereotype.Service;
import org.zeos.cafe.entity.Area;
import org.zeos.cafe.entity.Table1;

import java.util.List;

/**
 * Created by alxev on 09.07.2017.
 */
public interface CafeService {
    // area
    List<Area> findAllArea();

    // tables
    List<Table1> findAllTable1();
    List<Table1> findTable1ByAreaId(int areaId);


}
