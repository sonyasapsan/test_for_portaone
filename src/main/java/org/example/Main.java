package org.example;

import org.example.service.DataParser;
import org.example.service.FileReader;
import org.example.service.FileWriter;
import org.example.service.ValueService;
import org.example.service.serviceimpl.DataParserImpl;
import org.example.service.serviceimpl.FileReaderImpl;
import org.example.service.serviceimpl.FileWriterImpl;
import org.example.service.serviceimpl.ValueServiceImpl;

import java.time.LocalTime;
import java.util.List;

public class Main {
    private static final String fileName = "src/main/resources/10m.txt";
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        DataParser dataParser = new DataParserImpl();
        List<String> lines = fileReader.readDataFromFile(fileName);
        List<Integer> numbers = dataParser.parseStringToNumber(lines);
        ValueService valueService = new ValueServiceImpl();
        String result = String.format(
                "\t The max number = %d\n\t The min number = %d\n"
                + "\t The median = %fl\n\t The arithmetic mean = %fl\n"
                + "\t The positive sequence: \n\n%s\n\n\t The negative sequence: \n\n%s",
                valueService.findMaxNumber(numbers), valueService.findMinNumber(numbers),
                valueService.findMedian(numbers), valueService.findArithmeticMean(numbers),
                dataParser.parseIntegersToString(valueService.findPositiveSequence(numbers)),
                dataParser.parseIntegersToString(valueService.findNegativeSequence(numbers)));
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeDataToTheFile("src/main/resources/result.txt", result);
    }
}