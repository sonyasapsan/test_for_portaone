package org.example.service.serviceimpl;

import org.example.service.ValueService;

import java.util.ArrayList;
import java.util.List;

public class ValueServiceImpl implements ValueService {
    @Override
    public int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(i -> i)
                .max()
                .orElseThrow(() -> new RuntimeException("Can't find the max number"));
    }

    @Override
    public int findMinNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(i -> i)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't find the min number"));
    }

    @Override
    public double findMedian(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        if (sortedNumbers.size() % 2 != 0) {
            return sortedNumbers.get(sortedNumbers.size()/2);
        }
        int indexOfMiddle = sortedNumbers.size()/2;
        return (sortedNumbers.get(indexOfMiddle) + sortedNumbers
                .get(indexOfMiddle - 1)) * 0.5;
    }

    @Override
    public double findArithmeticMean(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(i -> i)
                .sum() / numbers.size();
    }

    @Override
    public List<Integer> findPositiveSequence(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temporary = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i + 1) > numbers.get(i)) {
                if (temporary.isEmpty()) {
                    temporary.add(numbers.get(i));
                }
                temporary.add(numbers.get(i + 1));
            } else {
                temporary.clear();
            }
            if (temporary.size() > result.size()) {
                result = List.copyOf(temporary);
            }
        }
        return result;
    }

    @Override
    public List<Integer> findNegativeSequence(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temporary = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i + 1) < numbers.get(i)) {
                if (temporary.isEmpty()) {
                    temporary.add(numbers.get(i));
                }
                temporary.add(numbers.get(i + 1));
            } else {
                temporary.clear();
            }
            if (temporary.size() > result.size()) {
                result = List.copyOf(temporary);
            }
        }
        return result;
    }
}
