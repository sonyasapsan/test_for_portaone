package org.example.service.serviceimpl;

import org.example.service.DataParser;

import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    @Override
    public List<Integer> parseStringToNumber(List<String> stringList) {
        return stringList.stream()
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public String parseIntegersToString(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
