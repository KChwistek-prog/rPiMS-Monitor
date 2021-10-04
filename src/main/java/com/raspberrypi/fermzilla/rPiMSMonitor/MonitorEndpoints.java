package com.raspberrypi.fermzilla.rPiMSMonitor;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class MonitorEndpoints {
    PiConnect piConnect;

    @Autowired
    public MonitorEndpoints(PiConnect piConnect) {
        this.piConnect = piConnect;
    }

    @GetMapping(value = "/thermowelltmp")
    @ResponseBody
    public Double getThermowellTemp() throws UnirestException, IOException {
        return piConnect.getTempFromPi();
    }
}
