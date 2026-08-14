package com.aldisued.iot.monitoring.dto.response;

import java.time.LocalDateTime;

public record SensorReadingResponse(

        String id,
        Double value,
        LocalDateTime timestamp,
        SensorResponse sensor

) {
}
