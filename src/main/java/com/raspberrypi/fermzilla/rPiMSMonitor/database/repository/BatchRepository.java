package com.raspberrypi.fermzilla.rPiMSMonitor.database.repository;

import com.raspberrypi.fermzilla.rPiMSMonitor.database.Batch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends CrudRepository<Batch, Long> {

    @Override
    List<Batch> findAll();


}
