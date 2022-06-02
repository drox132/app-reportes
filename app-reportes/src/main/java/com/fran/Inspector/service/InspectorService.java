package com.fran.Inspector.service;

import com.fran.Inspector.dto.inspector.InspectorRequestDto;
import com.fran.Inspector.model.Inspector;


import java.util.List;

public interface InspectorService {
    List<Inspector> getAllInspector();
    Inspector getInspectorById(Integer id);
    Inspector addNewInspector (InspectorRequestDto addNewInspector);
    void updateInspector (Inspector updateInspector);
}
