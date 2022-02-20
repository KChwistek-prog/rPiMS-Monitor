package com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class Calculator {
    private static final BigDecimal base = new BigDecimal("-16.6999");
    private static final BigDecimal constantInEquationPartOne = new BigDecimal("0.0101059");
    private static final BigDecimal constantInEquationPartTwo = new BigDecimal("0.00116512");
    private static final BigDecimal constantInEquationPartThree = new BigDecimal("0.173354");
    private static final BigDecimal constantInEquationPartFour = new BigDecimal("4.24267");
    private static final BigDecimal constantInEquationPartFive = new BigDecimal("0.0684226");
    private static final BigDecimal onePsiInBar = new BigDecimal("0.0689475729317831");
    private static final BigDecimal multiplyConstInConverter = new BigDecimal("1.8");
    private static final BigDecimal addConstInCelsiusConverter = new BigDecimal("32");

    public CarbCalcDto calculator(int tempC, double desiredCarb) {
        var pressureInBar = computeCarbonation(tempC, desiredCarb);
        return new CarbCalcDto(desiredCarb, tempC, pressureInBar);
    }

    public double computeCarbonation(int tempC, double desiredCarb) {
        var desiredCarbBig = new BigDecimal(desiredCarb);
        var temperatureFBig = convertCtoFahrenheit(tempC);

        //original formula:
        // P = -16.6999 || - 0.0101059 T || + 0.00116512 T^2 || + 0.173354 T V || + 4.24267 V || - 0.0684226 V^2
        //      base    ||       I       ||         II       ||        III     ||       IV    ||        V
        var requiredPressureInPsiEquation = base
                .subtract(equationPartOne(temperatureFBig))
                .add(equationPartTwo(temperatureFBig))
                .add(equationPartThree(temperatureFBig, desiredCarbBig))
                .add(equationPartFour(desiredCarbBig))
                .subtract(equationPartFive(desiredCarbBig));

        return convertPSItoBar(requiredPressureInPsiEquation).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private BigDecimal equationPartOne(BigDecimal temperatureInFahrenheit) {
        return constantInEquationPartOne.multiply(temperatureInFahrenheit);
    }

    private BigDecimal equationPartTwo(BigDecimal temperatureInFahrenheit) {
        return constantInEquationPartTwo.multiply(temperatureInFahrenheit.pow(2));
    }

    private BigDecimal equationPartThree(BigDecimal temperatureInFahrenheit, BigDecimal desiredCarbonation) {
        return constantInEquationPartThree.multiply(temperatureInFahrenheit).multiply(desiredCarbonation);
    }

    private BigDecimal equationPartFour(BigDecimal desiredCarbonation) {
        return constantInEquationPartFour.multiply(desiredCarbonation);
    }

    private BigDecimal equationPartFive(BigDecimal desiredCarbonation) {
        return constantInEquationPartFive.multiply(desiredCarbonation.pow(2));
    }

    private BigDecimal convertPSItoBar(BigDecimal pressureInBar) {
        return pressureInBar.multiply(onePsiInBar);
    }

    private BigDecimal convertCtoFahrenheit(int temperatureInC) {
        var bigDecimalTemp = new BigDecimal(temperatureInC);
        return bigDecimalTemp.multiply(multiplyConstInConverter).add(addConstInCelsiusConverter);
    }
}
