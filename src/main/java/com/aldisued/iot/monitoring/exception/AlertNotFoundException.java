package com.aldisued.iot.monitoring.exception;

public class AlertNotFoundException extends RuntimeException {
    public AlertNotFoundException(String sensorId) {
        super("Alert not found for sensor with ID: " + sensorId);
    }
}
