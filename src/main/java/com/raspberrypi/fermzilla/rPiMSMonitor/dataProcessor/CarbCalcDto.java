package com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor;
import java.math.BigDecimal;

public record CarbCalcDto(double desiredCarbonation, int beerTemperature, BigDecimal requiredPressureInBars) {

    @Override
    public String toString() {
        return "CarbCalcDto{" +
                "desiredCarbonation=" + desiredCarbonation +
                ", beerTemperature=" + beerTemperature +
                ", requiredPressureInBars=" + requiredPressureInBars +
                '}';
    }
}
