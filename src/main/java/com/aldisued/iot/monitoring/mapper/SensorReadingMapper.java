package com.aldisued.iot.monitoring.mapper;

import com.aldisued.iot.monitoring.dto.response.SensorReadingResponse;
import com.aldisued.iot.monitoring.entity.SensorReading;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorReadingMapper {
    SensorReadingResponse toResponse(SensorReading sensorReading);
}
