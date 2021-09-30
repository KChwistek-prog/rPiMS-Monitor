package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class Batch {
    @Id
    private String batchId;

    private String batchName;

    private List<BatchDetails> temperatures;

    public Batch() {
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public List<BatchDetails> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<BatchDetails> temperatures) {
        this.temperatures = temperatures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Batch batch = (Batch) o;

        if (!batchId.equals(batch.batchId)) return false;
        if (!batchName.equals(batch.batchName)) return false;
        return temperatures.equals(batch.temperatures);
    }

    @Override
    public int hashCode() {
        int result = batchId.hashCode();
        result = 31 * result + batchName.hashCode();
        result = 31 * result + temperatures.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId='" + batchId + '\'' +
                ", batchName='" + batchName + '\'' +
                ", temperatures=" + temperatures +
                '}';
    }
}
