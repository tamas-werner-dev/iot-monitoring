package com.aldisued.iot.monitoring.mapper;

import com.aldisued.iot.monitoring.dto.response.SensorResponse;
import com.aldisued.iot.monitoring.entity.Sensor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    SensorResponse toResponse(Sensor sensor);
}
