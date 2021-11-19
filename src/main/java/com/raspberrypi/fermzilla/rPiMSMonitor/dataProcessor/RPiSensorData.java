package com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor;

public class RPiSensorData {
    private final Double thermowellTemperatureReadings;
    private final Double roomTemperatureReadings;

    public Double getThermowellTemperatureReadings() {
        return thermowellTemperatureReadings;
    }

    public Double getRoomTemperatureReadings() {
        return roomTemperatureReadings;
    }

    public RPiSensorData(Double thermowellTemperatureReadings, Double roomTemperatureReadings) {
        this.thermowellTemperatureReadings = thermowellTemperatureReadings;
        this.roomTemperatureReadings = roomTemperatureReadings;
    }

    @Override
    public String toString() {
        return "Thermowell{" +
                "thermowellTemperatureReadings=" + thermowellTemperatureReadings +
                ", roomTemperatureReadings=" + roomTemperatureReadings +
                '}';
    }
}
