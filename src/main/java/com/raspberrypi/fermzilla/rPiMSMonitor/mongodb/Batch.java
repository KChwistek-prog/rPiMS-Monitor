package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
@Data
public class Batch {
    @Id
    private String batchId;

    private String batchName;

    private List<BatchDetails> temperatures;

    public Batch() {
    }
}
