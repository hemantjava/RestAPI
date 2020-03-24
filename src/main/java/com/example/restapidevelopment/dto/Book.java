package com.example.restapidevelopment.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
    long id;
    String name;
    String author;
}
