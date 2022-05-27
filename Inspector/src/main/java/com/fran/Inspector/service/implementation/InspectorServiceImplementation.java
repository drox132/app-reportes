package com.fran.Inspector.service.implementation;



import com.fran.Inspector.dto.inspector.InspectorRequestDto;
import com.fran.Inspector.exception.ValidateInspectorException;
import com.fran.Inspector.model.Inspector;
import com.fran.Inspector.repository.InspectorRepository;
import com.fran.Inspector.service.InspectorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectorServiceImplementation implements InspectorService {

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
        return inspectorRepository.getInspectorById(id);
    }

    @Override
    public void addNewInspector(InspectorRequestDto addNewInspector) {

        
        try {
            if (!addNewInspector.validateFields()){
                throw new ValidateInspectorException("Attribute of Inspector is Empty");
            }
            Inspector inspector= new Inspector();
            inspector.setName(addNewInspector.getName());
            inspector.setCel(addNewInspector.getCel());
            inspector.setEmail(addNewInspector.getEmail());
            inspectorRepository.save(inspector);

        }catch (ValidateInspectorException exception){
            System.out.println(exception);
        }
    }

    @Override
    public void updateInspector(Inspector updateInspector) {

    }
}
