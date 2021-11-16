package com.raspberrypi.fermzilla.rPiMSMonitor;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.Batch;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.BatchDetails;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.BatchRepo;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Component
@EnableScheduling
public class Scheduler {
    private PiConnect piConnect;
    private MongoService mongoService;

    public Batch batch = new Batch();
    public List<BatchDetails> tempList = new ArrayList<>();
    public BatchDetails batchDetails = new BatchDetails();

    @Autowired
    public Scheduler(PiConnect piConnect, MongoService mongoService) {
        this.piConnect = piConnect;
        this.mongoService = mongoService;
    }

  //  @Scheduled(fixedDelay = 5000)
//    public void periodicGetTemp() throws UnirestException, IOException {
//        batchDetails.setTime(new Date());
//        var getTempeFromInnerSensor = piConnect.getTempFromPi();
//        tempList.add(batchDetails);
//        batch.setBatchName("MongoEntityTest");
//       // batchDetails.setTemperature(getTempeFromInnerSensor);
//        batch.setTemperatures(tempList);
//
//        //mongoService.saveReadings(batch);
//        mongoService.saveReadingsWithId(batch, "61388de20619830ec91f5120");
//        System.out.println(mongoService.findBatchByName("Mongo"));
//        System.out.println(batch);
//    }

}
