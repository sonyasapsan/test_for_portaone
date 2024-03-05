package org.example.service;

import java.util.List;

public interface DataParser {
    List<Integer> parseStringToNumber(List<String> stringList);

    String parseIntegersToString(List<Integer> numbers);
}
