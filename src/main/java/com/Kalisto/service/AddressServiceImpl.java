package com.Kalisto.service;

import com.Kalisto.Dto.InfoDto;
import com.Kalisto.entity.District;
import com.Kalisto.entity.State;
import com.Kalisto.repository.DistrictRepository;
import com.Kalisto.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    DistrictRepository districtRepository;


    @Override
    public List<InfoDto> getStates() {

        List<State> states = stateRepository.findAll();

        return states.stream()
                .map(state -> new InfoDto(state.getId(), state.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<InfoDto> getDistricts(Long id) {
        List<District> districts = districtRepository.getDistrictsByState(id);

         return districts.stream()
                .map(district -> new InfoDto(district.getId(), district.getName()))
                .collect(Collectors.toList());
    }
}
