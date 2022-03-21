package com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.raspberrypi.fermzilla.rPiMSMonitor.adminConfig.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Processor {
    private final AdminConfig adminConfig;

    @Autowired
    public Processor(AdminConfig adminConfig) {
        this.adminConfig = adminConfig;
    }

    public RPiSensorData sensorsDataReadings() {
        try {
            var getFromPi = Unirest.get(adminConfig.getPiIpAddress() + "/v1/temperature").asJson();
            return new RPiSensorData(
                    getFromPi.getBody().getObject().getDouble("thermowellTemp"),
                    getFromPi.getBody().getObject().getDouble("roomTemperature"),
                    getFromPi.getBody().getObject().getDouble("setupPressure"));
        } catch (UnirestException e) {
            System.out.println("Connection lost");
            return new RPiSensorData(99.0, 99.0, 99.0);
        }
    }
}
