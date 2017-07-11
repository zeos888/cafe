package org.zeos.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zeos.cafe.entity.Area;
import org.zeos.cafe.service.CafeService;

import java.util.List;

/**
 * Created by alxev on 10.07.2017.
 */
@RestController
@RequestMapping("/")
public class CafeController {
    @Autowired
    private CafeService cafeService;

    @RequestMapping(value = "/getArea/", method = RequestMethod.GET)
    public List<Area> getAreas(){
        List<Area> areas = cafeService.findAllArea();
        return areas;
    }
    public ResponseEntity<List<Area>> getAreaJSON(){
        List<Area> areas = cafeService.findAllArea();
        return ResponseEntity.ok(areas);
    }
}
