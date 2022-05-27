package com.fran.Inspector.service;

import com.fran.Inspector.dto.consortium.ConsortiumRequestDto;
import com.fran.Inspector.model.Consortium;

import java.util.Optional;

public interface ConsortiumService {

    Optional<Consortium> getConsortiumById (Integer id);
    void addNewConsortiumDto(ConsortiumRequestDto addNewConsortiumDto);

}
