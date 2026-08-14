package com.aldisued.iot.monitoring.messaging;

import com.aldisued.iot.monitoring.dto.AlertDto;
import com.aldisued.iot.monitoring.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlertKafkaListener {
  private final AlertService alertService;

  @KafkaListener(
          topics = {"sensor-alerts"},
          groupId = "iot-monitoring",
          properties = "spring.json.value.default.type=com.aldisued.iot.monitoring.dto.AlertDto"
  )
  public void listen(AlertDto alertDto) {
    alertService.saveAlert(alertDto);
  }

}
