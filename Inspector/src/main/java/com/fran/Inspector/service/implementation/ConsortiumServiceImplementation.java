package com.fran.Inspector.service.implementation;

import com.fran.Inspector.dto.consortium.ConsortiumRequestDto;
import com.fran.Inspector.exception.ValidateConsortiumException;
import com.fran.Inspector.exception.ValidateInspectorException;
import com.fran.Inspector.model.Consortium;
import com.fran.Inspector.repository.ConsortiumRepository;
import com.fran.Inspector.service.ConsortiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsortiumServiceImplementation implements ConsortiumService {

    private final ConsortiumRepository consortiumRepository;

    @Autowired
    public ConsortiumServiceImplementation(ConsortiumRepository consortiumRepository) {
        this.consortiumRepository = consortiumRepository;
    }

    @Override
    public Optional<Consortium> getConsortiumById(Integer id) {
        return consortiumRepository.findById(id);
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
