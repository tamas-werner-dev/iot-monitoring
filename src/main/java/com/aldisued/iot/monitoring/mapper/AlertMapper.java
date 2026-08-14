package com.aldisued.iot.monitoring.mapper;

import com.aldisued.iot.monitoring.dto.response.AlertLatestResponse;
import com.aldisued.iot.monitoring.dto.response.AlertSaveResponse;
import com.aldisued.iot.monitoring.entity.Alert;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlertMapper {
    @Mapping(target = "sensorId", source = "alert.sensor.id")
    AlertLatestResponse toLatestResponse(Alert alert);

    @Mapping(target = "sensor", source = "alert.sensor")
    AlertSaveResponse toSaveResponse(Alert alert);
}
