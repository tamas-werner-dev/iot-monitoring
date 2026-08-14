package com.aldisued.iot.monitoring.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record AlertLatestResponse(
        UUID sensorId,
        String message,
        LocalDateTime timestamp
) {
}
