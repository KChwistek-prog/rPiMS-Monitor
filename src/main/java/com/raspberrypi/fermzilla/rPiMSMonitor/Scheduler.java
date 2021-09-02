package com.raspberrypi.fermzilla.rPiMSMonitor;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Scheduler {
    public PiConnect piConnect;

    @Autowired
    public Scheduler(PiConnect piConnect) {
        this.piConnect = piConnect;
    }

    @Scheduled(fixedDelay = 5000)
    public void periodicGetTemp() throws UnirestException {
        System.out.println("getTemp " + piConnect.getTempFromPi().get("innerTemperature"));
    }

}
