package com.raspberrypi.fermzilla.rPiMSMonitor;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class PiConnect {

    public JSONObject getTempFromPi() throws UnirestException {
        return Unirest.get("http://192.168.0.102:8080/v1/temperature").asJson().getBody().getObject();
    }

}
