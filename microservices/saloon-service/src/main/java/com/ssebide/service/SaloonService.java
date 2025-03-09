package com.ssebide.service;

import java.util.List;

import com.ssebide.modal.Saloon;
import com.ssebide.payload.dto.SaloonDTO;
import com.ssebide.payload.dto.UserDTO;

public interface SaloonService {

    Saloon createSaloon(SaloonDTO saloon, UserDTO user);

    Saloon updateSaloon(SaloonDTO saloon, UserDTO user, Long saloonId);

    List<Saloon> getAllSaloons();

    Saloon getSaloonById(Long saloonId);

    Saloon getSaloonByOwnerId(Long ownerId);

    List<Saloon> searchSaloonByCity(String city);
}
