package com.ssebide.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssebide.modal.ServiceOffering;
import com.ssebide.payload.dto.CategoryDTO;
import com.ssebide.payload.dto.SaloonDTO;
import com.ssebide.payload.dto.ServiceDTO;
import com.ssebide.repository.ServiceOfferingRepository;
import com.ssebide.service.ServiceOfferingService;

@Service
public class ServiceOfferingServiceImpl implements ServiceOfferingService {

    @Autowired
    private ServiceOfferingRepository serviceOfferingRepository;

    @Override
    public ServiceOffering createService(SaloonDTO saloonDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {
        
        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setImage(serviceDTO.getImage());
        serviceOffering.setSaloonId(serviceDTO.getId());
        serviceOffering.setName(serviceDTO.getName());
        serviceOffering.setDescription(serviceDTO.getDescription());
        serviceOffering.setCategoryId(categoryDTO.getId());
        serviceOffering.setPrice(serviceDTO.getPrice());
        serviceOffering.setDuration(serviceDTO.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception {
        
        ServiceOffering serviceOffering = serviceOfferingRepository.findById(serviceId).orElse(null);

        if(serviceOffering == null){
            throw new Exception("Service doesnt exists with id" + serviceId);
        }

        serviceOffering.setImage(service.getImage());
        serviceOffering.setName(service.getName());
        serviceOffering.setDescription(service.getDescription());
        serviceOffering.setPrice(service.getPrice());
        serviceOffering.setDuration(service.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySaloonId(Long saloonId, Long categoryId) {

        Set<ServiceOffering> services = serviceOfferingRepository.findBySaloonId(saloonId);

        if(categoryId!=null){
            services = services.stream().filter((service) -> service.getCategoryId() != null && service.getCategoryId() == categoryId).collect(Collectors.toSet());
        }

        return services;
    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        List<ServiceOffering> services =  serviceOfferingRepository.findAllById(ids);
        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceById(Long id) throws Exception {
        
        ServiceOffering serviceOffering = serviceOfferingRepository.findById(id).orElse(null);

        if(serviceOffering == null){
            throw new Exception("Service doesnt exists with id" + id);
        }
        return serviceOffering;
    }

}
