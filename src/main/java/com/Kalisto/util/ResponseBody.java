package com.Kalisto.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseBody <T>{

    T body;
    String message;
    int statusCode;



}
