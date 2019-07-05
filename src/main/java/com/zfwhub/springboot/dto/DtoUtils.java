package com.zfwhub.springboot.dto;

import org.springframework.beans.BeanUtils;

public class DtoUtils {
    
    private DtoUtils() { }

    public static <P, D> void convertToDto(P po, D dto) {
        BeanUtils.copyProperties(po, dto);
    }
    
    public static <P, D> void convertToPo(D dto, P po) {
        BeanUtils.copyProperties(dto, po);
    }

}
