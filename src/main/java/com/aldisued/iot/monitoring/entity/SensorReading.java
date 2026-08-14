package com.aldisued.iot.monitoring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "sensor_readings")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class SensorReading {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private Double value;

  @Column(nullable = false)
  private LocalDateTime timestamp;

  @ManyToOne(optional = false)
  @JoinColumn(name = "sensor_id", nullable = false)
  private Sensor sensor;

  public SensorReading(
      Double value,
      LocalDateTime timestamp,
      Sensor sensor
  ) {
    this.value = value;
    this.timestamp = timestamp;
    this.sensor = sensor;
  }

}
