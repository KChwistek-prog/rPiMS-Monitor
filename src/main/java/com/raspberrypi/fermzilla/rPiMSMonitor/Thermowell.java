package com.raspberrypi.fermzilla.rPiMSMonitor;

public class Thermowell {
    private Double thermowellTemperature;

    public Double getThermowellTemperature() {
        return thermowellTemperature;
    }

    public Thermowell(Double thermowellTemperature) {
        this.thermowellTemperature = thermowellTemperature;
    }

    @Override
    public String toString() {
        return "Thermowell{" +
                "thermowellTemperature=" + thermowellTemperature +
                '}';
    }
}
