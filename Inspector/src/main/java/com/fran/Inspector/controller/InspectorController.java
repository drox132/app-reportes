package com.fran.Inspector.controller;

import com.fran.Inspector.model.Inspector;
import com.fran.Inspector.service.InspectorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inspector")
public class InspectorController {

    private final InspectorService inspectorService;

    public InspectorController(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }

    @GetMapping(value = "/getinspectorby/{id}")
    public Inspector getInspectorById(@PathVariable Integer id ){
        return inspectorService.getInspectorById(id);
    }



    @PostMapping(value = "/addnewinspector")
    public void addNewInspector(@RequestBody Inspector addNewInspector) {
        inspectorService.addNewInspector(addNewInspector);
    }

}
