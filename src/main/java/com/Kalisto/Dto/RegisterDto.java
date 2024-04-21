package com.Kalisto.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDto {

    private String password;
    private String email;
    private String phone;
    private String fullName;
    private Long districtId;
    private Long stateId;
    private String pinCode;
    private Long designationId;

}
