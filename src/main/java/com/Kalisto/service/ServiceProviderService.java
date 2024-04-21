package com.Kalisto.service;

import com.Kalisto.Dto.InfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceProviderService {

    public List<InfoDto> getDestinations();


}
