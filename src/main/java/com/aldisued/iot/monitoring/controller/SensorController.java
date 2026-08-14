package com.aldisued.iot.monitoring.controller;

import com.aldisued.iot.monitoring.dto.SensorDto;
import com.aldisued.iot.monitoring.dto.response.SensorResponse;
import com.aldisued.iot.monitoring.service.SensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping
    public SensorResponse saveSensor(@RequestBody @Valid SensorDto sensorDto) {
        return sensorService.saveSensor(sensorDto);
    }
}
