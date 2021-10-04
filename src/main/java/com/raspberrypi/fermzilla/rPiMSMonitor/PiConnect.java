package com.raspberrypi.fermzilla.rPiMSMonitor;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.*;

@Component
public class PiConnect {
    private final String URL = "http://192.168.0.101:8080/v1/temperature";

    private int checkConnection() throws IOException {
        int responseCode = 0;
        try {
            URL url = new URL(URL);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
            responseCode = httpURLConnection.getResponseCode();
        } catch (ConnectException e) {
            System.out.println("Timeout");
        }
        return responseCode;
    }

    public Double getTempFromPi() throws UnirestException, IOException {
        if(checkConnection() == 200) {
            var response = Unirest.get(URL).asJson().getBody().getObject();
            return response.optDouble("innerTemperature");
        } else {
            return 99.00;
        }
    }
}