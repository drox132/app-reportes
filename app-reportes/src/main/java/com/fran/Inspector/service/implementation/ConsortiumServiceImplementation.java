package com.fran.Inspector.service.implementation;

import com.fran.Inspector.dto.consortium.ConsortiumRequestDto;
import com.fran.Inspector.exception.ValidateConsortiumException;
import com.fran.Inspector.exception.ValidateInspectorException;
import com.fran.Inspector.model.Consortium;
import com.fran.Inspector.repository.ConsortiumRepository;
import com.fran.Inspector.service.ConsortiumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ConsortiumServiceImplementation implements ConsortiumService {

    private final ConsortiumRepository consortiumRepository;

    @Autowired
    public ConsortiumServiceImplementation(ConsortiumRepository consortiumRepository) {
        this.consortiumRepository = consortiumRepository;
    }

    @Override
    public Consortium getConsortiumById(Integer id) {
      log.info("Iniciando el metodo getConsortiumById");
        Optional<Consortium> byId = consortiumRepository.findById(id);
        log.info("se procede a convertir el Optional consortium a un Consortium");
        Consortium consortium = byId.orElseThrow(() -> new ValidateConsortiumException("malo"));

        //SE PUEDE HACER EN UNA SOLA LINEA
        /*Consortium consortium= consortiumRepository.findById(id)
         .orElseThrow(() -> new ValidateConsortiumException("Consorcio con datos incorrectos o vacios"));

         EXISTEN OTROS METODOS DEL OPTIONAL QUE DETERMINAN SI EL DATO isEmpty o ifPresent POR AVERIGUAR COMO FUNCIONAN
         */
        return consortium;
    }

    @Override
    public void addNewConsortiumDto(ConsortiumRequestDto addNewConsortiumDto) {
    try { if (!addNewConsortiumDto.validateFields()){
        throw new ValidateConsortiumException("Atribute of Consortium is empty");
    }
    Consortium consortium = new Consortium();
        consortium.setName(addNewConsortiumDto.getName());
        consortium.setCuit(addNewConsortiumDto.getCuit());
        consortium.setIdInspector(addNewConsortiumDto.getIdInspector());

        consortiumRepository.save(consortium);

    }catch (ValidateInspectorException exception){
        System.out.println(exception);

    }

    }
}
