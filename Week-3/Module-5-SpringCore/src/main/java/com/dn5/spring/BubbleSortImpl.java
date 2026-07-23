package com.dn5.spring;

import org.springframework.stereotype.Component;

@Component
public class BubbleSortImpl implements SortAlgorithm {

    @Override
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.print("Bubble Sort Result: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
