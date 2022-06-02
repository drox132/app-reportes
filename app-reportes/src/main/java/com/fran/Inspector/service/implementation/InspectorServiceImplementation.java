package com.fran.Inspector.service.implementation;



import com.fran.Inspector.dto.inspector.InspectorRequestDto;
import com.fran.Inspector.exception.ValidateInspectorException;
import com.fran.Inspector.model.Inspector;
import com.fran.Inspector.repository.InspectorRepository;
import com.fran.Inspector.service.InspectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectorServiceImplementation implements InspectorService {

    Logger logger = LoggerFactory.getLogger(InspectorServiceImplementation.class);

    private final InspectorRepository inspectorRepository;


    public InspectorServiceImplementation(InspectorRepository inspectorRepository) {
        this.inspectorRepository = inspectorRepository;
    }

    @Override
    public List<Inspector> getAllInspector() {
        return null;
    }


    @Override
    public Inspector getInspectorById(Integer id) {
        logger.info("Ejecutando el metodo getInspectorById");
        return inspectorRepository.getInspectorById(id);
    }

    @Override
    public Inspector addNewInspector(InspectorRequestDto addNewInspector) {

        logger.info("ejecutando el metodo addNewInspector utilizando como parametro el inspectorDto");

        Inspector inspectorResponse= null;
        try {
            if (!addNewInspector.validateFields()) {
                logger.error("fallo la validacion de datos del Inspector algun atributo es Vacio se redirigira el error al catch");
                throw new ValidateInspectorException("Attribute of Inspector is Empty");
            }

            logger.info("La condicion de validacion fue pasada exitosamente");

            logger.info("se precede a guardar en inspector en la base de datos utilizando metodos de JpaRepository");

             inspectorResponse= this.inspectorMapper(addNewInspector);
            inspectorRepository.save(inspectorResponse);

           // return inspectorResponse;

        } catch ( IllegalArgumentException | ValidateInspectorException exception) {
            logger.info("se procedera a ejecutar la excepcion por la falla de validacion del INspector Dto");
            System.out.println(exception);
        }

        return inspectorResponse;
    }

            // conversion de inspectorDto a un Inpertor Entidad
    private Inspector inspectorMapper (InspectorRequestDto addNewInspectorRequestDto){

        Inspector inspector= new Inspector();
        inspector.setName(addNewInspectorRequestDto.getName());
        inspector.setCel(addNewInspectorRequestDto.getCel());
        inspector.setEmail(addNewInspectorRequestDto.getEmail());
        return inspector;
    }

    @Override
    public void updateInspector(Inspector updateInspector) {

    }
}
