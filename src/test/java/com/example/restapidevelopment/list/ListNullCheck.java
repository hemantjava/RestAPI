package com.example.restapidevelopment.list;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListNullCheck {

    private boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty() ? Boolean.TRUE : Boolean.FALSE;
    }

    private boolean isNotNullAndEmpty(Collection collection) {
        return collection == null || collection.isEmpty() ? Boolean.FALSE : Boolean.TRUE;
    }

    @Test
    void testE() {
        List<String> strings = getList();
        System.out.println(isNullOrEmpty(strings));
        System.out.println(isNotNullAndEmpty(strings));

    }

    private List<String> getList() {
        List<String> strings = new LinkedList<>();
        strings.add("Hemant");
        return strings;
    }
}
