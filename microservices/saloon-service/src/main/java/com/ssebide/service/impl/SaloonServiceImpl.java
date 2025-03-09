package com.ssebide.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssebide.modal.Saloon;
import com.ssebide.payload.dto.SaloonDTO;
import com.ssebide.payload.dto.UserDTO;
import com.ssebide.service.SaloonService;

@Service
public class SaloonServiceImpl implements SaloonService {

    @Override
    public Saloon createSaloon(SaloonDTO saloon, UserDTO user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSaloon'");
    }

    @Override
    public Saloon updateSaloon(SaloonDTO saloon, UserDTO user, Long saloonId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSaloon'");
    }

    @Override
    public List<Saloon> getAllSaloons() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSaloons'");
    }

    @Override
    public Saloon getSaloonById(Long saloonId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSaloonById'");
    }

    @Override
    public Saloon getSaloonByOwnerId(Long ownerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSaloonByOwnerId'");
    }

    @Override
    public List<Saloon> searchSaloonByCity(String city) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSaloonByCity'");
    }

}
