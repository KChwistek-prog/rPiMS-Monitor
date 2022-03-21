package com.raspberrypi.fermzilla.rPiMSMonitor.database.DTOs;

import java.util.Date;

public record BatchDetailsDTO(Date time, Double roomTemperature, Double thermowellTemperature, Double pressure) {
}
