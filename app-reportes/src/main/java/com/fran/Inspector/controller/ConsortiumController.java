package com.fran.Inspector.controller;

import com.fran.Inspector.dto.common.RestResponse;
import com.fran.Inspector.dto.consortium.ConsortiumRequestDto;
import com.fran.Inspector.model.Consortium;
import com.fran.Inspector.service.ConsortiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public RestResponse<Consortium> getConsortiumById(@PathVariable Integer id){
        Consortium consortiumById = consortiumService.getConsortiumById(id);
        return new RestResponse<>(HttpStatus.FOUND, "siiiiii",consortiumById);
    }

    @PostMapping(value = "/addconsortium")
    public RestResponse<Consortium> addNewConsortium(@RequestBody ConsortiumRequestDto addNewConsortiumDto){
        RestResponse<Consortium>restResponseConsortium=new RestResponse<>();

        consortiumService.addNewConsortiumDto(addNewConsortiumDto);
        return new RestResponse<>(HttpStatus.ACCEPTED,"El consorcio fue guardado exitosamente");
    }
}
