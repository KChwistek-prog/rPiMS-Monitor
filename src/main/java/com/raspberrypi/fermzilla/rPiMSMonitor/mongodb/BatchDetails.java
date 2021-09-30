package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class BatchDetails {
    private Date time;
    private Double temperature;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public BatchDetails() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatchDetails that = (BatchDetails) o;

        if (!time.equals(that.time)) return false;
        return temperature.equals(that.temperature);
    }

    @Override
    public int hashCode() {
        int result = time.hashCode();
        result = 31 * result + temperature.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BatchDetails{" +
                "time=" + time +
                ", temperature=" + temperature +
                '}';
    }
}
