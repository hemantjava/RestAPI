package com.example.restapidevelopment.dto;

import com.example.restapidevelopment.entity.Emp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
@RequiredArgsConstructor
public class EmpResponse {

    @JsonIgnore
    public final Emp emp;

    public Integer getId() {
        return this.emp.getId();
    }

    public String getName() {
        return this.emp.getName();
    }


    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public LocalDateTime getJoiningDate() {
        return this.emp.getJoiningDate();
    }


    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public LocalDateTime getLeavingDate() {
        return this.emp.getLeavingDate();
    }

    public void setId(Integer id) {
        this.emp.setId(id);
    }

    public void setName(String name) {
        this.emp.setName(name);
    }

    public void setJoiningDate(LocalDateTime joiningDate) {
        this.emp.setJoiningDate(joiningDate);
    }

    public void setLeavingDate(LocalDateTime leavingDate) {
        this.emp.setLeavingDate(leavingDate);
    }
}
