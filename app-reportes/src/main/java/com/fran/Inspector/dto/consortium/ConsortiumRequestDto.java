package com.fran.Inspector.dto.consortium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsortiumRequestDto {
    private String name;
    private String cuit;
    private Integer idInspector;

    public Boolean validateFields(){
        if (ObjectUtils.isEmpty(name)){
            return false;
        }
        if (ObjectUtils.isEmpty(cuit)){
            return false;
        }
        if (ObjectUtils.isEmpty(idInspector)){
            return false;
        }
        return true;
    }
}
