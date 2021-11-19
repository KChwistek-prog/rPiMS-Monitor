package com.raspberrypi.fermzilla.rPiMSMonitor.monitorOutput;

import com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor.Calculator;
import com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor.CarbCalcDto;
import com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor.Processor;
import com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor.RPiSensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class MonitorEndpoints {
    private final Processor processor;
    private final Calculator calculator;

    @Autowired
    public MonitorEndpoints(Processor processor, Calculator calculator) {
        this.processor = processor;
        this.calculator = calculator;
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

    @GetMapping(value = "carbonation/{temperature}&{desiredCarb}")
    @ResponseBody
    public CarbCalcDto calculatedCarbonation(@PathVariable("temperature") int temperature, @PathVariable("desiredCarb") double desiredCarb){
        return calculator.calculator(temperature,desiredCarb);
    }
}
