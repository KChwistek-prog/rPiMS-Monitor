package com.raspberrypi.fermzilla.rPiMSMonitor.mongodb;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
public class BatchDetails {
    private Date time;
    private Double temperature;
}
