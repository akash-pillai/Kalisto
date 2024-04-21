package com.Kalisto.service;


import com.Kalisto.Dto.InfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {


    List<InfoDto>  getStates();

    List<InfoDto>  getDistricts(Long id);
}
