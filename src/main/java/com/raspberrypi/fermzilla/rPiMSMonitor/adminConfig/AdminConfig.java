package com.raspberrypi.fermzilla.rPiMSMonitor.adminConfig;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminConfig {

    @Value("${rpims.piaddress}")
    private String piIpAddress;

    public String getPiIpAddress() {
        return piIpAddress;
    }
}
