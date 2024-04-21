package com.Kalisto.service;

import com.Kalisto.Dto.InfoDto;
import com.Kalisto.entity.Designation;
import com.Kalisto.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceProviderImpl  implements  ServiceProviderService{

    @Autowired
    DesignationRepository designationRepository;

    @Override
    public List<InfoDto> getDestinations() {
        List<Designation> designations = designationRepository.findAll();
        return designations.stream()
                .map(designation -> new InfoDto(designation.getId(), designation.getName()))
                .collect(Collectors.toList());
    }
}
