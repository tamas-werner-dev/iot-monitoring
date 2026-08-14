package com.aldisued.iot.monitoring.service;

import com.aldisued.iot.monitoring.dto.SensorReadingDto;
import com.aldisued.iot.monitoring.dto.response.SensorReadingResponse;
import com.aldisued.iot.monitoring.entity.SensorReading;
import com.aldisued.iot.monitoring.exception.SensorNotFoundException;
import com.aldisued.iot.monitoring.mapper.SensorReadingMapper;
import com.aldisued.iot.monitoring.repository.SensorReadingRepository;
import com.aldisued.iot.monitoring.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorReadingService {

    private final SensorReadingRepository sensorReadingRepository;
    private final SensorRepository sensorRepository;
    private final SensorReadingMapper sensorReadingMapper;

    public SensorReadingResponse saveSensorReading(SensorReadingDto sensorReadingDto) {
        var sensor = sensorRepository.findById(sensorReadingDto.sensorId())
                .orElseThrow(() -> new SensorNotFoundException(sensorReadingDto.sensorId()));

        var sensorReading = sensorReadingRepository.save(
                new SensorReading(sensorReadingDto.value(), sensorReadingDto.timestamp(), sensor)
        );

        return sensorReadingMapper.toResponse(sensorReading);
    }

}
