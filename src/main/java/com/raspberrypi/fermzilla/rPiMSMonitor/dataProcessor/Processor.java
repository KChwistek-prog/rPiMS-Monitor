package com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.raspberrypi.fermzilla.rPiMSMonitor.adminConfig.AdminConfig;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Processor {
    private final MongoService mongoService;
    private final AdminConfig adminConfig;

    @Autowired
    public Processor(AdminConfig adminConfig, MongoService mongoService) {
        this.adminConfig = adminConfig;
        this.mongoService = mongoService;
    }

    public RPiSensorData sensorsDataReadings() {
        try {
            var getFromPi = Unirest.get(adminConfig.getPiIpAddress() + "/v1/temperature").asJson();
            return new RPiSensorData(
                    getFromPi.getBody().getObject().getDouble("thermowellTemp"),
                    getFromPi.getBody().getObject().getDouble("roomTemperature"),
                    getFromPi.getBody().getObject().getDouble("roomTemperature"));
        } catch (UnirestException e) {
            System.out.println("Connection lost");
            return new RPiSensorData(99.0, 99.0, 99.0);
        }
    }
}
