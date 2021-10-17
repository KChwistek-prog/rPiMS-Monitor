package com.raspberrypi.fermzilla.rPiMSMonitor;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class MonitorEndpoints {
    PiConnect piConnect;

    @Autowired
    public MonitorEndpoints(PiConnect piConnect) {
        this.piConnect = piConnect;
    }

    @GetMapping(value = "hello")
    public String helloMessage(){
        return "Hello";
    }

    @GetMapping(value = "thermowelltmp")
    public Double getThermowellTemp() throws UnirestException {
        return piConnect.getTempFromPi();
    }
}
