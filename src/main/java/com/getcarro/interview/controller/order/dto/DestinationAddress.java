package com.getcarro.interview.controller.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinationAddress {

    private String address1;
    private String city;
    private String country;
    private String countryCode;
    private String provinceCode;
    private String province;
    private String zip;
    private String firstName;
    private String lastName;
    private String email;

}