package com.cordis.hrms360.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeReq {
    private String firstName;
    private String lastName;
    private String email;
    private String department;

    @JsonProperty("addresses")
    private List<AddressReq> addressReqList;
}
