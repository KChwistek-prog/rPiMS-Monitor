package com.raspberrypi.fermzilla.rPiMSMonitor;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.raspberrypi.fermzilla.rPiMSMonitor.adminConfig.AdminConfig;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.*;

@Component
public class PiConnect {

    private final AdminConfig adminConfig;

    public PiConnect(AdminConfig adminConfig) {
        this.adminConfig = adminConfig;
    }

    private int checkConnection() throws IOException {
        var responseCode = 0;
        try {
            URL url = new URL(adminConfig.getPiIpAddress());
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(3000);
            HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
            responseCode = httpURLConnection.getResponseCode();
            httpURLConnection.disconnect();
        } catch (SocketTimeoutException e) {
            System.out.println("Timeout");
            responseCode = 408;
        }
        return responseCode;
    }

    public Double getTempFromPi() throws UnirestException, IOException {
        if(checkConnection() == 200){
            return Unirest.get(adminConfig.getPiIpAddress() + "/v1/temperature").asJson().getBody().getObject().getDouble("thermoWellTemp");
        }else {
            return 99.00;
        }

    }
}