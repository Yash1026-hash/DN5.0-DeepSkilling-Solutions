package com.dn5.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SortRunner {

    @Autowired
    private SortAlgorithm sortAlgorithm;

    public void runSort() {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Using: " + sortAlgorithm.getClass().getSimpleName());
        sortAlgorithm.sort(numbers);
    }
}
