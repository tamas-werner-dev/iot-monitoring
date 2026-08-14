package com.aldisued.iot.monitoring.exception;

public class SensorNameAlreadyExists extends RuntimeException {
    public SensorNameAlreadyExists(String sensorName) {
        super("Sensor name already exists: " + sensorName);
    }
}
