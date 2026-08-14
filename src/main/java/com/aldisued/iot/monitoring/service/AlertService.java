package com.aldisued.iot.monitoring.service;

import com.aldisued.iot.monitoring.dto.AlertDto;
import com.aldisued.iot.monitoring.dto.response.AlertLatestResponse;
import com.aldisued.iot.monitoring.dto.response.AlertSaveResponse;
import com.aldisued.iot.monitoring.entity.Alert;
import com.aldisued.iot.monitoring.exception.AlertNotFoundException;
import com.aldisued.iot.monitoring.exception.SensorNotFoundException;
import com.aldisued.iot.monitoring.mapper.AlertMapper;
import com.aldisued.iot.monitoring.repository.AlertRepository;
import com.aldisued.iot.monitoring.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository alertRepository;
    private final SensorRepository sensorRepository;
    private final KafkaTemplate<String, AlertDto> kafkaTemplate;
    private final AlertMapper alertMapper;
    private static final String ALERTS_TOPIC = "alerts";

    public AlertSaveResponse saveAlert(AlertDto alertDto) {
        var sensor = sensorRepository.findById(alertDto.sensorId())
                .orElseThrow(() -> new SensorNotFoundException(alertDto.sensorId()));

        var alert = alertRepository.save(new Alert(alertDto.message(), alertDto.timestamp(), sensor));

        kafkaTemplate.send(ALERTS_TOPIC, alertDto);

        return alertMapper.toSaveResponse(alert);
    }

    public AlertLatestResponse findLastAlertBySensorId(UUID sensorId) {
        var alert = alertRepository.findFirstBySensorIdOrderByTimestampDesc(sensorId)
                .orElseThrow(() -> new AlertNotFoundException(sensorId.toString()));

        return alertMapper.toLatestResponse(alert);
    }
}
