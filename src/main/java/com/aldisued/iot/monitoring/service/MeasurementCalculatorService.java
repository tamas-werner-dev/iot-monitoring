package com.aldisued.iot.monitoring.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class MeasurementCalculatorService {

    public List<Double> filterByAverageDeviation(List<Double> values, Double deviation) {
        if (deviation < 0 || deviation > 1) {
            throw new IllegalArgumentException("deviation must be between 0 and 1");
        }

        var doubleSummaryStatistics = new DoubleSummaryStatistics();
        values.forEach(doubleSummaryStatistics::accept);

        var average = doubleSummaryStatistics.getAverage();
        var minValue = average - average * deviation;
        var maxValue = average + average * deviation;

        return values.stream()
                .filter(value -> value >= minValue && value <= maxValue)
                .toList();
    }

    public List<Double> getMovingAverage(List<Double> data, int windowSize) {
        if (windowSize <= 0) {
            throw new IllegalArgumentException("windowSize must be positive");
        }

        if (windowSize > data.size()) {
            throw new IllegalArgumentException("windowSize must not exceed the number of values");
        }

        List<Double> resultAverage = new ArrayList<>();
        double windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += data.get(i);
        }
        resultAverage.add(windowSum / windowSize);

        for (int i = windowSize; i < data.size(); i++) {
            windowSum += data.get(i) - data.get(i - windowSize);
            resultAverage.add(windowSum / windowSize);
        }

        return resultAverage;
    }

}
