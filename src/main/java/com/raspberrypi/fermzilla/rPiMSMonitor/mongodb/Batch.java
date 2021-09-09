package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@NoArgsConstructor
public class Batch {

    @Id
    private String batchId;

    private Set<Double> temperatures;
}
