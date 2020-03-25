package com.example.restapidevelopment.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;

@Builder
@Data
public class Book {
    long id;
    String name;
    @Size(min = 3)
    String author;
}
