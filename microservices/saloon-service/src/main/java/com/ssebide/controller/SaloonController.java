package com.ssebide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssebide.mapper.SaloonMapper;
import com.ssebide.modal.Saloon;
import com.ssebide.payload.dto.SaloonDTO;
import com.ssebide.payload.dto.UserDTO;
import com.ssebide.service.SaloonService;

@RestController
@RequestMapping("/api/saloons")
public class SaloonController {

    @Autowired
    private SaloonService saloonService;

    @PostMapping
    public ResponseEntity<SaloonDTO> createSaloon(@RequestBody SaloonDTO saloonDTO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Saloon saloon = saloonService.createSaloon(saloonDTO, userDTO);
        SaloonDTO saloonDTO1 = SaloonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(saloonDTO1);
    }

    @PatchMapping("/{saloonId}")
    public ResponseEntity<SaloonDTO> updateSaloon(@RequestBody SaloonDTO saloonDTO, @PathVariable Long saloonId) throws Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Saloon saloon = saloonService.updateSaloon(saloonDTO, userDTO, saloonId);
        SaloonDTO saloonDTO1 = SaloonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(saloonDTO1);
    }

    @GetMapping()
    public ResponseEntity<List<SaloonDTO>> getSaloons() throws Exception{  

        List<Saloon> saloons = saloonService.getAllSaloons();
        
        List<SaloonDTO> saloonDTOs = saloons.stream().map((saloon) -> {
            SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);
            return saloonDTO;
        }).toList();
        return ResponseEntity.ok(saloonDTOs);
    }

    @GetMapping("/{saloonId}")
    public ResponseEntity<SaloonDTO> getSaloonById(@PathVariable Long saloonId) throws Exception{

        Saloon saloon = saloonService.getSaloonById(saloonId);

        SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SaloonDTO>> searchSaloons(@RequestParam("city") String city) throws Exception{

        List<Saloon> saloons = saloonService.searchSaloonByCity(city);
        
        List<SaloonDTO> saloonDTOs = saloons.stream().map((saloon) -> {
            SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);
            return saloonDTO;
        }).toList();
        return ResponseEntity.ok(saloonDTOs);
    }

    @GetMapping("/owner")
    public ResponseEntity<SaloonDTO> getSaloonByOwnerId(@PathVariable Long saloonId) throws Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Saloon saloon = saloonService.getSaloonByOwnerId(userDTO.getId());

        SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO);
    }
}
