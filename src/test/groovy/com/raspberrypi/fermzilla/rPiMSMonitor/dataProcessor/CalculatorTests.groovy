package com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor

import spock.lang.Specification

class CalculatorTests extends Specification{
    def "calculator accuracy test"(){
       expect:
       def calc = new Calculator()
       calc.computeCarbonation(temperature, desiredCarbonation) == pressure
        where:
        temperature << [5, 10, 15, 5, 10, 15, 5, 10]
        desiredCarbonation << [1.75, 1.75, 1.75, 2.5, 2.5, 2.5, 4.0, 4.0]
        pressure << [0.31, 0.56, 0.82, 0.88, 1.21, 1.55, 2.01, 2.50]
    }
}
