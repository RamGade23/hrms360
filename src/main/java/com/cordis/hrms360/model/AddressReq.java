package com.cordis.hrms360.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressReq {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
