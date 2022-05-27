package com.fran.Inspector.controller;

import com.fran.Inspector.dto.consortium.ConsortiumRequestDto;
import com.fran.Inspector.model.Consortium;
import com.fran.Inspector.service.ConsortiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/consortium")
public class ConsortiumController {

    private final ConsortiumService consortiumService;

    @Autowired
    public ConsortiumController(ConsortiumService consortiumService) {
        this.consortiumService = consortiumService;
    }

    @GetMapping(value = "/getby/{id}")
    public Optional<Consortium> getConsortiumById(@PathVariable Integer id){
        return consortiumService.getConsortiumById(id);
    }

    @PostMapping(value = "/addconsortium")
    public void addNewConsortium(@RequestBody ConsortiumRequestDto addNewConsortiumDto){
        consortiumService.addNewConsortiumDto(addNewConsortiumDto);
    }
}
