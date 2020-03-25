package com.example.restapidevelopment.controller;

import com.example.restapidevelopment.dto.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Field Management System", description="Operations pertaining to fields in Field Management System")
@RestController
@RequestMapping("/filter")
public class DynamicFilteringController {

    @GetMapping("/dynamic1")

    @ApiOperation(value = "View a list of available Field1,Field2 ", response = MappingJacksonValue.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public MappingJacksonValue getSomeBeanDynamic1(){
        SomeBean someBean = new SomeBean("Field1","Field2","Field3","Field4");
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue (someBean);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/dynamic2")
    @ApiOperation(value = "View a list of available Field3,Field4 ", response = MappingJacksonValue.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public MappingJacksonValue getSomeBeanDynamic2(){
        SomeBean someBean = new SomeBean("Field1","Field2","Field3","Field4");
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field3","field4");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue (someBean);
        mapping.setFilters(filters);
        return mapping;
    }
}
