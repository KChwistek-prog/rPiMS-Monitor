package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MongoService {
    private final BatchRepo batchRepo;

    @Autowired
    public MongoService(BatchRepo batchRepo) {
        this.batchRepo = batchRepo;
    }

    public String findBatchByName(String batchName){
        return batchRepo.findAll().stream()
                .filter(batch -> batch.getBatchName().contains(batchName))
                .map(Batch::getBatchId)
                .collect(Collectors.joining());
    }

    public boolean checkIfBatchNameExists(final String batchName){
        return batchRepo.findAll().stream()
                .findAny().filter(e -> e.getBatchName().contentEquals(batchName)).isPresent();
    }

    public Batch saveReadings(final Batch batch){
        return batchRepo.save(batch);
    }

    public void saveReadingsWithId(final Batch batch, String id){
        batch.setBatchId(id);
        batchRepo.save(batch);
    }

}
