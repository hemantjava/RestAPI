package com.example.restapidevelopment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Represent list of Book's Details")
public class Book {
    long id;
    String name;
    @Size(min = 3)
    @ApiModelProperty("Author name should be 3 characters ")
    String author;
}
