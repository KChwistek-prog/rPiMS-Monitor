package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepo extends MongoRepository<Batch, String> {

}
