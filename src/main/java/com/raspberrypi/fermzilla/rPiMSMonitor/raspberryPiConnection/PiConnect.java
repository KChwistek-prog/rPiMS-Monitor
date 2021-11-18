package com.raspberrypi.fermzilla.rPiMSMonitor.raspberryPiConnection;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.raspberrypi.fermzilla.rPiMSMonitor.adminConfig.AdminConfig;
import org.springframework.stereotype.Component;

@Component
public class PiConnect {

    private final AdminConfig adminConfig;

    private PiConnect(AdminConfig adminConfig) {
        this.adminConfig = adminConfig;
    }

    public Double thermowellTemperatureSensor() {
        try {
            return Unirest.get(adminConfig.getPiIpAddress() + "/v1/temperature").asJson().getBody().getObject().getDouble("thermoWellTemp");
        } catch (UnirestException e) {
            System.out.println("Connection lost");
            return 99.0;
        }
    }

    public Double roomTemperatureSensor() {
        //placeholder for room tmp sensor
        return 25.0;
    }
}