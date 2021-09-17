package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class MongoService {
    private BatchRepo batchRepo;

    @Autowired
    public MongoService(BatchRepo batchRepo) {
        this.batchRepo = batchRepo;
    }

    public String findBatchByName(String name){
        return batchRepo.findAll().stream()
                .filter(batch -> batch.getBatchName().contains(name))
                .map(Batch::getBatchId)
                .collect(Collectors.joining());
    }

    public void saveReadings(final Batch batch){
        batchRepo.save(batch);
    }

    public void saveReadingsWithId(final Batch batch, String id){
        batch.setBatchId(id);
        batchRepo.save(batch);
    }

}
