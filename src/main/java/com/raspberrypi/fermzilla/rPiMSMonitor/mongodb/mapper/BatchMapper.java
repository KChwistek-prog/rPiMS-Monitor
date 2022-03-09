package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.mapper;

import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.Batch;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.DTOs.BatchDTO;
import org.springframework.stereotype.Service;

@Service
public class BatchMapper {
    public BatchDTO mapToBatchDto(Batch batch){
        return new BatchDTO(
                batch.getBatchId(),
                batch.getBatchName(),
                batch.getTemperatures()
        );
    }

    public Batch mapToBatch(BatchDTO batchDTO){
        return new Batch(
                batchDTO.batchId(),
                batchDTO.batchName(),
                batchDTO.temperatures()
        );
    }
}
