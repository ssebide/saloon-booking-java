package com.ssebide.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssebide.modal.ServiceOffering;

public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering, Long> {

    Set<ServiceOffering> findBySaloonId(Long saloonId);
}
