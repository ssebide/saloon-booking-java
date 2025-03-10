package com.ssebide.service;

import java.util.Set;

import com.ssebide.modal.ServiceOffering;
import com.ssebide.payload.dto.CategoryDTO;
import com.ssebide.payload.dto.SaloonDTO;
import com.ssebide.payload.dto.ServiceDTO;

public interface ServiceOfferingService {

    ServiceOffering createService(SaloonDTO saloonDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO);
    ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception;
    Set<ServiceOffering> getAllServiceBySaloonId(Long saloonId, Long categoryId);
    Set<ServiceOffering> getServicesByIds(Set<Long> ids);
    ServiceOffering getServiceById(Long id) throws Exception;
}
