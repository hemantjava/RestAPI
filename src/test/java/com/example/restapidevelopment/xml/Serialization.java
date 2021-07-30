package com.example.restapidevelopment.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

public class Serialization {

    @Test
    void testSerialization() throws IOException {
        SimpleBean simpleBean = SimpleBean.builder()
                .x(234)
                .y(789)
                .build();

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(simpleBean);
        assertNotNull(xml);
        System.out.println(xml);

        //xmlMapper.writeValue(new File("simple_bean.xml"), simpleBean);

        SimpleBean simpleBean1 = xmlMapper.readValue(xml, SimpleBean.class);
        System.out.println(simpleBean1);


    }
}
