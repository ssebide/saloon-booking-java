package com.ssebide.mapper;

import com.ssebide.modal.Saloon;
import com.ssebide.payload.dto.SaloonDTO;

public class SaloonMapper {


    public static SaloonDTO mapToDTO(Saloon saloon) {
        SaloonDTO saloonDTO = new SaloonDTO();

        saloonDTO.setId(saloon.getId());
        saloonDTO.setName(saloon.getName());
        saloonDTO.setAddress(saloon.getAddress());
        saloonDTO.setCity(saloon.getCity());
        saloonDTO.setImages(saloon.getImages());
        saloonDTO.setCloseTime(saloon.getCloseTime());
        saloonDTO.setOpenTime(saloon.getOpenTime());
        saloonDTO.setPhoneNumber(saloon.getPhoneNumber());
        saloonDTO.setOwnerId(saloon.getOwnerId());
        saloonDTO.setEmail(saloon.getEmail());

        return saloonDTO;
    }
}
