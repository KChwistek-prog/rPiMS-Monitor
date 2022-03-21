package com.raspberrypi.fermzilla.rPiMSMonitor.database;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BATCHDETAILS")
public class BatchDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Date time;

    @Column
    private Double roomTemperature;

    @Column
    private Double thermowellTemperature;

    @Column
    private Double pressure;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;


    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public Double getRoomTemperature() {
        return roomTemperature;
    }

    public Double getThermowellTemperature() {
        return thermowellTemperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setRoomTemperature(Double roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    public void setThermowellTemperature(Double thermowellTemperature) {
        this.thermowellTemperature = thermowellTemperature;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatchDetails that = (BatchDetails) o;

        if (!id.equals(that.id)) return false;
        if (!time.equals(that.time)) return false;
        if (!roomTemperature.equals(that.roomTemperature)) return false;
        if (!thermowellTemperature.equals(that.thermowellTemperature)) return false;
        if (!pressure.equals(that.pressure)) return false;
        return batch.equals(that.batch);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + roomTemperature.hashCode();
        result = 31 * result + thermowellTemperature.hashCode();
        result = 31 * result + pressure.hashCode();
        result = 31 * result + batch.hashCode();
        return result;
    }

    public BatchDetails() {
    }

    public BatchDetails(Long id, Date time, Double roomTemperature, Double thermowellTemperature, Double pressure, Batch batch) {
        this.id = id;
        this.time = time;
        this.roomTemperature = roomTemperature;
        this.thermowellTemperature = thermowellTemperature;
        this.pressure = pressure;
        this.batch = batch;
    }
}
