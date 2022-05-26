package com.fran.Inspector.service;



import com.fran.Inspector.model.Inspector;
import com.fran.Inspector.repository.InspectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectorServiceImplementation implements InspectorService{

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
    public void addNewInspector(Inspector addNewInspector) {
            inspectorRepository.addNewInspector(
                    addNewInspector.getName(),
                    addNewInspector.getCel(),
                    addNewInspector.getEmail());
    }

    @Override
    public void updateInspector(Inspector updateInspector) {

    }
}
