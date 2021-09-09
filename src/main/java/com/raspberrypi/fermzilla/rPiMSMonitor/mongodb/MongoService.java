package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoService {
    private BatchRepo batchRepo;

    @Autowired
    public MongoService(BatchRepo batchRepo) {
        this.batchRepo = batchRepo;
    }

    public void saveReadings(final Batch batch){
        batchRepo.save(batch);
    }

}
