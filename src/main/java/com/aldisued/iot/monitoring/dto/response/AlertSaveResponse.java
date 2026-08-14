package com.aldisued.iot.monitoring.dto.response;

import java.time.LocalDateTime;

public record AlertSaveResponse(
        String id,
        String message,
        LocalDateTime timestamp,
        SensorResponse sensor
) {
}
