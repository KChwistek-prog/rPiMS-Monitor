package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class BatchDetails {
    private Date time;
    private Double roomTemperature;
    private Double thermowellTemperature;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getRoomTemperature() {
        return roomTemperature;
    }

    public void setRoomTemperature(Double roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    public Double getThermowellTemperature() {
        return thermowellTemperature;
    }

    public void setThermowellTemperature(Double thermowellTemperature) {
        this.thermowellTemperature = thermowellTemperature;
    }

    public BatchDetails(Date time, Double roomTemperature, Double thermowellTemperature) {
        this.time = time;
        this.roomTemperature = roomTemperature;
        this.thermowellTemperature = thermowellTemperature;
    }

    public BatchDetails() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatchDetails that = (BatchDetails) o;

        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (roomTemperature != null ? !roomTemperature.equals(that.roomTemperature) : that.roomTemperature != null)
            return false;
        return thermowellTemperature != null ? thermowellTemperature.equals(that.thermowellTemperature) : that.thermowellTemperature == null;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (roomTemperature != null ? roomTemperature.hashCode() : 0);
        result = 31 * result + (thermowellTemperature != null ? thermowellTemperature.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BatchDetails{" +
                "time=" + time +
                ", roomTemperature=" + roomTemperature +
                ", thermowellTemperature=" + thermowellTemperature +
                '}';
    }
}
