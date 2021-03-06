package com.nikosportolos.MtCProject1.controllers;

import com.nikosportolos.MtCProject1.models.responses.AllPositionsResponse;
import com.nikosportolos.MtCProject1.models.responses.AllUnitsResponse;
import com.nikosportolos.MtCProject1.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UnitController {

    @Autowired
    UnitService service;

    @GetMapping("/units")
    @ResponseBody
    public AllUnitsResponse getUnits() {
        System.out.println("###Loading all units...");
        return service.getAllUnits();
    }

    @GetMapping("/unit/{id}")
    @ResponseBody
    public AllUnitsResponse getUnitById(@PathVariable("id") long id) {
        System.out.println("###Loading unit by id: " + id);
        return service.getUnitById(id);
    }
}
