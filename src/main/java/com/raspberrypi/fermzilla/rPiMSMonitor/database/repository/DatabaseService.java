package com.raspberrypi.fermzilla.rPiMSMonitor.database.repository;

import com.raspberrypi.fermzilla.rPiMSMonitor.database.Batch;
import com.raspberrypi.fermzilla.rPiMSMonitor.database.BatchDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    private final BatchRepository batchRepository;

    @Autowired
    public DatabaseService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public boolean checkIfBatchNameExists(final String batchName) {
        return batchRepository.findAll().stream()
                .findAny().filter(e -> e.getBatchName().contentEquals(batchName)).isPresent();
    }

    public Batch saveReadings(final Batch batch) {
        return batchRepository.save(batch);
    }

    public void saveReadingsWithId(final BatchDetails batchDetails, Long id) {

    }
}
