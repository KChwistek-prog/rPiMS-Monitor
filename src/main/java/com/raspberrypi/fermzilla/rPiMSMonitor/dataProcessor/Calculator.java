package com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public CarbCalcDto calculator(int tempC, double desiredCarb) {
        double temperatureF = tempC * 1.8 + 32;
        double pressureInPsi = (-16.6999) - (0.0101059 * temperatureF) + 0.00116512 * (temperatureF * temperatureF) + (0.173354 * temperatureF * desiredCarb) + (4.24267 * desiredCarb) - (0.0684226 * (desiredCarb * desiredCarb));
        double pressureInBar = pressureInPsi * 0.0689475729317831;
        return new CarbCalcDto(desiredCarb,tempC,pressureInBar);
    }
}
