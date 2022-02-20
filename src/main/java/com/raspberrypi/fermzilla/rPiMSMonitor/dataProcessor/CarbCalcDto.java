package com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor;

public record CarbCalcDto(double desiredCarbonation, int beerTemperature, double requiredPressureInBars) {

    @Override
    public String toString() {
        return "CarbCalcDto{" +
                "desiredCarbonation=" + desiredCarbonation +
                ", beerTemperature=" + beerTemperature +
                ", requiredPressureInBars=" + requiredPressureInBars +
                '}';
    }
}
