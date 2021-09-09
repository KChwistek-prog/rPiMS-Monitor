package com.raspberrypi.fermzilla.rPiMSMonitor;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.Batch;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@EnableScheduling
public class Scheduler {
    private PiConnect piConnect;
    private MongoService mongoService;

    public Batch batch = new Batch();
    public Set<Double>tempList = new HashSet<>();

    @Autowired
    public Scheduler(PiConnect piConnect, MongoService mongoService) {
        this.piConnect = piConnect;
        this.mongoService = mongoService;
    }

    @Scheduled(fixedDelay = 5000)
    public void periodicGetTemp() throws UnirestException {
        String id = "61388de20619830ec91f5120";
        var getTempeFromInnerSensor = piConnect.getTempFromPi();
        var sensorReadingsToDouble = piConnect.PiResponseToDouble(getTempeFromInnerSensor);

        tempList.add(sensorReadingsToDouble);
        batch.setBatchId(id);
        batch.setTemperatures(tempList);

        mongoService.saveReadings(batch);

        System.out.println(batch);
        System.out.println(sensorReadingsToDouble);
    }

}
