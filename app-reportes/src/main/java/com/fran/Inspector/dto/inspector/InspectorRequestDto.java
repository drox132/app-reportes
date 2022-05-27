package com.fran.Inspector.dto.inspector;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectorRequestDto {

private String name;
private String cel;
private String email;


public Boolean validateFields(){
    if (ObjectUtils.isEmpty(name)){
        return false;
    }
    if (ObjectUtils.isEmpty(cel)){
        return false;
    }
    if (ObjectUtils.isEmpty(email)){
        return false;
    }
    return true;
}


}
