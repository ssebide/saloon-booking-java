package com.ssebide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssebide.modal.ServiceOffering;
import com.ssebide.payload.dto.CategoryDTO;
import com.ssebide.payload.dto.SaloonDTO;
import com.ssebide.payload.dto.ServiceDTO;
import com.ssebide.service.ServiceOfferingService;

@RestController
@RequestMapping("/api/service-offering/saloon-owner")
public class SaloonServiceOfferingController {

    @Autowired
    private ServiceOfferingService serviceOfferingService;

    @PostMapping()
    public ResponseEntity<ServiceOffering> createService(@RequestBody ServiceDTO serviceDTO) {

        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering serviceOfferings = serviceOfferingService.createService(saloonDTO, serviceDTO, categoryDTO);

        return ResponseEntity.ok(serviceOfferings);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(@PathVariable Long id, @RequestBody ServiceOffering serviceOffering) throws Exception {

        ServiceOffering serviceOfferings = serviceOfferingService.updateService(id, serviceOffering);

        return ResponseEntity.ok(serviceOfferings);
    }
}
