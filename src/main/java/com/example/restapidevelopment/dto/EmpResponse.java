package com.example.restapidevelopment.dto;

import com.example.restapidevelopment.entity.Emp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

import java.util.ArrayList;
import java.util.Collection;

@Builder
@Data
@RequiredArgsConstructor
public class EmpResponse {

    @JsonIgnore
    @Delegate
    public final Emp emp;


}
