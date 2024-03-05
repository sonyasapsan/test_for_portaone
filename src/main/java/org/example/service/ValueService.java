package org.example.service;

import java.util.List;

public interface ValueService {
    int findMaxNumber(List<Integer> numbers);

    int findMinNumber(List<Integer> numbers);

    double findMedian(List<Integer> numbers);

    double findArithmeticMean(List<Integer> numbers);

    List<Integer> findPositiveSequence(List<Integer> numbers);

    List<Integer> findNegativeSequence(List<Integer> numbers);
}
