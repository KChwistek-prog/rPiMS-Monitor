package com.raspberrypi.fermzilla.rPiMSMonitor;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.raspberrypi.fermzilla.rPiMSMonitor.adminConfig.AdminConfig;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.*;
import java.lang.String;
import java.util.Optional;

@Component
public class PiConnect {

    private final AdminConfig adminConfig;

    public PiConnect(AdminConfig adminConfig) {
        this.adminConfig = adminConfig;
    }


    private int checkConnection() throws IOException {
        int responseCode = 0;
        try {
            URL url = new URL(adminConfig.getPiIpAddress());
            URLConnection connection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
            responseCode = httpURLConnection.getResponseCode();
        } catch (ConnectException e) {
            System.out.println("Timeout");
        }
        return responseCode;
    }

    public Double getTempFromPi() throws UnirestException {
            return Unirest.get(adminConfig.getPiIpAddress() + "/v1/temperature").asJson().getBody().getObject().getDouble("thermoWellTemp");

    }
}