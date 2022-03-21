package com.raspberrypi.fermzilla.rPiMSMonitor.database.DTOs;

import com.raspberrypi.fermzilla.rPiMSMonitor.database.BatchDetails;

import java.util.Set;


public record BatchDTO(Long batchId, String batchName, Set<BatchDetails> temperatures) {
}
