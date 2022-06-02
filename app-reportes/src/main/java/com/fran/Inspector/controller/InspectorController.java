package com.fran.Inspector.controller;

import com.fran.Inspector.dto.common.RestResponse;
import com.fran.Inspector.dto.inspector.InspectorRequestDto;
import com.fran.Inspector.model.Inspector;
import com.fran.Inspector.service.InspectorService;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
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
    public RestResponse<Inspector> addNewInspector(@RequestBody InspectorRequestDto addNewInspector) {
        Inspector body= null;
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String message = "Malo";
        Inspector inspectorResponse = inspectorService.addNewInspector(addNewInspector);
        if(!ObjectUtils.isEmpty(inspectorResponse)){
            httpStatus = HttpStatus.CREATED;
            message = "El inspector fue guardado exitosamente";
            body = inspectorResponse;
        }
        RestResponse<Inspector> restResponse = null;
        restResponse.setStatusCode(httpStatus.value());
        restResponse.setMessage(message);
        restResponse.setBody(body);
        return restResponse;
       // return new RestResponse<>(httpStatus,message,body);
    }

    @PostMapping(value = "/addnewinspector")
    public RestResponse<Inspector> addNewInspector2(@RequestBody InspectorRequestDto addNewInspector) {
        Inspector body= null;
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String message = "Malo";
        Inspector inspectorResponse = inspectorService.addNewInspector(addNewInspector);
        if(ObjectUtils.isEmpty(inspectorResponse)){
            return new RestResponse<>(httpStatus,message,body);
        }
        httpStatus = HttpStatus.CREATED;
        message = "El inspector fue guardado exitosamente";
        body = inspectorResponse;
        RestResponse<Inspector> restResponse = null;
        restResponse.setStatusCode(httpStatus.value());
        restResponse.setMessage(message);
        restResponse.setBody(body);

        return restResponse;
    }

}
