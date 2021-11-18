package com.raspberrypi.fermzilla.rPiMSMonitor.monitorOutput;

import com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor.Processor;
import com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor.RPiSensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class MonitorEndpoints {
    Processor processor;

    @Autowired
    public MonitorEndpoints(Processor processor) {
        this.processor = processor;
    }

    @GetMapping(value = "hello")
    public String helloMessage(){
        return "Hello";
    }

    @GetMapping(value = "thermowelltmp")
    @ResponseBody
    public RPiSensorData getDataReadingsFromRPi() {
        return processor.sensorsDataReadings();
    }
}
