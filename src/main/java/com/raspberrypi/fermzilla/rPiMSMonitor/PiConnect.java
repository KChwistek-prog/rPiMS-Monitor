package com.raspberrypi.fermzilla.rPiMSMonitor;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.raspberrypi.fermzilla.rPiMSMonitor.adminConfig.AdminConfig;
import org.springframework.stereotype.Component;

@Component
public class PiConnect {

    private final AdminConfig adminConfig;

    public PiConnect(AdminConfig adminConfig) {
        this.adminConfig = adminConfig;
    }

    public Thermowell getTempFromPi() {
        try {
            Double response = Unirest.get(adminConfig.getPiIpAddress() + "/v1/temperature").asJson().getBody().getObject().getDouble("thermoWellTemp");
            return new Thermowell(response);
        } catch (UnirestException e) {
            System.out.println("Connection lost");
            return new Thermowell(99.0);
        }
    }
}