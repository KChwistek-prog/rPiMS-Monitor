package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.DTOs;

import java.util.Date;

public record BatchDetailsDTO(Date time, Double roomTemperature, Double thermowellTemperature) {
}
