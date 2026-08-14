package com.aldisued.iot.monitoring.controller;

import com.aldisued.iot.monitoring.dto.AlertDto;
import com.aldisued.iot.monitoring.dto.response.AlertLatestResponse;
import com.aldisued.iot.monitoring.dto.response.AlertSaveResponse;
import com.aldisued.iot.monitoring.service.AlertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @GetMapping("/latest")
    public AlertLatestResponse findLatestAlert(@RequestParam UUID sensorId) {
        return alertService.findLastAlertBySensorId(sensorId);
    }

    @PostMapping
    public AlertSaveResponse saveAlert(@RequestBody @Valid AlertDto alertDto) {
        return alertService.saveAlert(alertDto);
    }
}
