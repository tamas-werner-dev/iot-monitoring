package com.aldisued.iot.monitoring.repository;

import com.aldisued.iot.monitoring.entity.SensorReading;
import com.aldisued.iot.monitoring.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SensorReadingRepository extends JpaRepository<SensorReading, String> {
    @Query("SELECT avg(sr.value) FROM SensorReading sr WHERE sr.sensor.type = :type AND sr.timestamp BETWEEN :from AND :to")
    Optional<Double> averageTemperature(LocalDateTime from, LocalDateTime to, SensorType type);

    @Query("SELECT sr.value FROM SensorReading sr WHERE sr.sensor.type = :type AND sr.timestamp BETWEEN :from AND :to ORDER BY sr.timestamp")
    List<Double> measurementValues(SensorType type, LocalDateTime from, LocalDateTime to);
}
