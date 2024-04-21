package com.Kalisto.controller;


import com.Kalisto.Dto.InfoDto;
import com.Kalisto.service.AddressService;
import com.Kalisto.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
public class DetailsController {

    @Autowired
    AddressService addressService;

    @Autowired
    ServiceProviderService serviceProviderService;



    @GetMapping("/states")
    public List<InfoDto> getStates(){

     return addressService.getStates();

    }

    @GetMapping("/districts/{id}")
    public List<InfoDto> getDistricts(@PathVariable Long id){
        return addressService.getDistricts(id);
    }

    @GetMapping("/designation")
    public List<InfoDto> getdesignations(){
        return serviceProviderService.getDestinations();
    }


}
