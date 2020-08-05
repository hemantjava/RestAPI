package com.example.restapidevelopment.dto;

import lombok.*;

import javax.persistence.Entity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    Integer id;
    String firstName;
    Integer age;

}
