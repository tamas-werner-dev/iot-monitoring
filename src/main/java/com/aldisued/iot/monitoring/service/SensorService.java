package com.aldisued.iot.monitoring.service;

import com.aldisued.iot.monitoring.dto.SensorDto;
import com.aldisued.iot.monitoring.dto.response.SensorResponse;
import com.aldisued.iot.monitoring.entity.Sensor;
import com.aldisued.iot.monitoring.exception.SensorNameAlreadyExists;
import com.aldisued.iot.monitoring.mapper.SensorMapper;
import com.aldisued.iot.monitoring.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    public SensorResponse saveSensor(SensorDto sensor) {
        var sensorNameAlreadyExists = sensorRepository.existsByName(sensor.name());
        if (sensorNameAlreadyExists) {
            throw new SensorNameAlreadyExists(sensor.name());
        }

        var savedSensor = sensorRepository.save(new Sensor(
                sensor.name(),
                sensor.type()
        ));

        return sensorMapper.toResponse(savedSensor);
    }
}
