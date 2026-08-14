package com.aldisued.iot.monitoring.messaging;

import com.aldisued.iot.monitoring.dto.SensorReadingDto;
import com.aldisued.iot.monitoring.service.SensorReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SensorReadingListener {
  private final SensorReadingService sensorReadingService;

  @KafkaListener(
          topics = {"sensor-reading"},
          groupId = "iot-monitoring",
          properties = "spring.json.value.default.type=com.aldisued.iot.monitoring.dto.SensorReadingDto"
  )
  public void listen(SensorReadingDto sensorReadingDto) {
    sensorReadingService.saveSensorReading(sensorReadingDto);
  }

}
