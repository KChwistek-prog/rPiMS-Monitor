package com.raspberrypi.fermzilla.rPiMSMonitor.database;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BATCH")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id", nullable = false)
    private Long batchId;

    @Column
    private String batchName;

    @OneToMany(mappedBy = "batch")
    private Set<BatchDetails> temperatures;

    public Batch(Long batchId, String batchName, Set<BatchDetails> temperatures) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.temperatures = temperatures;
    }

    public Batch() {
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Set<BatchDetails> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(Set<BatchDetails> temperatures) {
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
