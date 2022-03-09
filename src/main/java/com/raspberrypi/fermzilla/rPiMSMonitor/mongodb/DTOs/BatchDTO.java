package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.DTOs;

import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.BatchDetails;

import java.util.List;

public record BatchDTO(String batchId, String batchName, List<BatchDetails> temperatures) {
}
