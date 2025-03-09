package com.ssebide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssebide.modal.Saloon;
import com.ssebide.payload.dto.SaloonDTO;
import com.ssebide.payload.dto.UserDTO;
import com.ssebide.repository.SaloonRepository;
import com.ssebide.service.SaloonService;

@Service
public class SaloonServiceImpl implements SaloonService {

    @Autowired
    private SaloonRepository saloonRepository;

    @Override
    public Saloon createSaloon(SaloonDTO req, UserDTO user) {
        Saloon saloon = new Saloon();

        saloon.setName(req.getName());
        saloon.setAddress(req.getAddress());
        saloon.setEmail(req.getEmail());
        saloon.setCity(req.getCity());
        saloon.setImages(req.getImages());
        saloon.setOwnerId(user.getId());
        saloon.setOpenTime(req.getOpenTime());
        saloon.setCloseTime(req.getCloseTime());
        saloon.setPhoneNumber(req.getPhoneNumber());

        return saloonRepository.save(saloon);

    }

    @Override
    public Saloon updateSaloon(SaloonDTO saloon, UserDTO user, Long saloonId) throws Exception {
        
        Saloon existingSaloon = saloonRepository.findById(saloonId).orElseThrow();
        if(existingSaloon != null && saloon.getOwnerId().equals(user.getId())){
            existingSaloon.setCity(saloon.getCity());
            existingSaloon.setName(saloon.getName());
            existingSaloon.setAddress(saloon.getAddress());
            existingSaloon.setEmail(saloon.getEmail());
            existingSaloon.setImages(saloon.getImages());
            existingSaloon.setOpenTime(saloon.getOpenTime());
            existingSaloon.setCloseTime(saloon.getCloseTime());
            existingSaloon.setPhoneNumber(saloon.getPhoneNumber());
            existingSaloon.setOwnerId(user.getId());

            return saloonRepository.save(existingSaloon);
        }
        throw new Exception("Saloon doesnt exist");
    }

    @Override
    public List<Saloon> getAllSaloons() {
        
        return saloonRepository.findAll();
    }

    @Override
    public Saloon getSaloonById(Long saloonId) throws Exception {
        
        Saloon saloon = saloonRepository.findById(saloonId).orElse(null);

        if(saloon == null){
            throw new Exception("Saloon doesnt exist");
        }
        return saloon;
    }

    @Override
    public Saloon getSaloonByOwnerId(Long ownerId) {
        return saloonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Saloon> searchSaloonByCity(String city) {
        return saloonRepository.searSaloons(city);
    }

}
