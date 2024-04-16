package com.Kalisto.service;

import com.Kalisto.Dto.RegisterDto;
import com.Kalisto.entity.*;
import com.Kalisto.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthServiceImpl implements  AuthService{


    @Autowired
    RoleRepository roleRepository;


    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    StateRepository stateRepository;


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DesignationRepository designationRepository;

    @Autowired
    ServiceProviderrepository serviceProviderrepository;


    @Override
    public boolean registerUser(RegisterDto registerDto) {
        try {
            Role role = roleRepository.findById(registerDto.getRoleId())
                    .orElseThrow(() -> new IllegalArgumentException("Role not found"));

            User user = createUserFromDto(registerDto, role);
            userRepository.save(user);

            Address address = createAddressFromDto(registerDto);
            address = addressRepository.save(address);

            if (role.getName().equals("Service Provider")) {
                addServiceProvider(registerDto, user, address);
            } else if (role.getName().equals("Client")) {
                addClient(registerDto, user, address);
            }

            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    private User createUserFromDto(RegisterDto registerDto, Role role) {
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setRole(role);
        user.setPhone(registerDto.getPhone());
        user.setFullName(registerDto.getFullName());
        String encodedPassword = BCrypt.hashpw(registerDto.getPassword(), BCrypt.gensalt());
        user.setPassword(encodedPassword);
        return user;
    }

    private Address createAddressFromDto(RegisterDto registerDto) {
        Optional<District> districtOptional = districtRepository.findById(registerDto.getDistrictId());
        District district = districtOptional.orElseThrow(() -> new IllegalArgumentException("District not found"));

        Optional<State> stateOptional = stateRepository.findById(registerDto.getStateId());
        State state = stateOptional.orElseThrow(() -> new IllegalArgumentException("State not found"));

        Address address = new Address();
        address.setPinCode(registerDto.getPinCode());
        address.setDistrict(district);
        address.setState(state);
        return address;
    }

    private void addClient(RegisterDto registerDto, User user, Address address) {
        Client client = new Client();
        client.setAddress(address);
        client.setUser(user);
        clientRepository.save(client);
    }

    private void addServiceProvider(RegisterDto registerDto, User user, Address address) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setAddress(address);
        serviceProvider.setUser(user);
        serviceProvider.setDesignation(designationRepository.findById(registerDto.getDesignationId())
                .orElseThrow(() -> new IllegalArgumentException("Designation not found")));
        serviceProviderrepository.save(serviceProvider);
    }







}
