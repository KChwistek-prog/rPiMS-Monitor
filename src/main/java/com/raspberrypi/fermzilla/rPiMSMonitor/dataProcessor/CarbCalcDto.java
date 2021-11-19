package com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor;

public class CarbCalcDto {
    private final double desiredCarbonation;
    private final int beerTemperature;
    private final double requiredPressureInBars;

    public CarbCalcDto(double desiredCarbonation, int beerTemperature, double requiredPressureInBars) {
        this.desiredCarbonation = desiredCarbonation;
        this.beerTemperature = beerTemperature;
        this.requiredPressureInBars = requiredPressureInBars;
    }

    public double getRequiredPressureInBars() {
        return requiredPressureInBars;
    }

    @Override
    public String toString() {
        return "CarbCalcDto{" +
                "desiredCarbonation=" + desiredCarbonation +
                ", beerTemperature=" + beerTemperature +
                ", requiredPressureInBars=" + requiredPressureInBars +
                '}';
    }
}
