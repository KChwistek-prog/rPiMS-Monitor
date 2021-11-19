package com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor;

import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.MongoService;
import com.raspberrypi.fermzilla.rPiMSMonitor.raspberryPiConnection.PiConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Processor {
    private final PiConnect piConnect;
    private final MongoService mongoService;

    @Autowired
    public Processor(PiConnect piConnect, MongoService mongoService) {
        this.piConnect = piConnect;
        this.mongoService = mongoService;
    }

    public RPiSensorData sensorsDataReadings() {
        Double thermowellTemperatureSensor = piConnect.thermowellTemperatureSensor();
        Double roomTemperatureSensor = piConnect.roomTemperatureSensor();
        return new RPiSensorData(thermowellTemperatureSensor, roomTemperatureSensor);
    }
}
