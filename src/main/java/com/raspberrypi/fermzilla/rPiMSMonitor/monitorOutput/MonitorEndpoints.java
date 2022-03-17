package com.raspberrypi.fermzilla.rPiMSMonitor.monitorOutput;

import com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor.Calculator;
import com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor.CarbCalcDto;
import com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor.Processor;
import com.raspberrypi.fermzilla.rPiMSMonitor.dataProcessor.RPiSensorData;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.DTOs.BatchDTO;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.MongoService;
import com.raspberrypi.fermzilla.rPiMSMonitor.mongodb.mapper.BatchMapper;
import com.raspberrypi.fermzilla.rPiMSMonitor.monitorOutput.exceptions.BatchNameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class MonitorEndpoints {
    private final Processor processor;
    private final Calculator calculator;
    private final MongoService mongoService;
    private final BatchMapper batchMapper;

    @Autowired
    public MonitorEndpoints(Processor processor, Calculator calculator, MongoService mongoService, BatchMapper batchMapper) {
        this.processor = processor;
        this.calculator = calculator;
        this.mongoService = mongoService;
        this.batchMapper = batchMapper;
    }

    @GetMapping(value = "readDataFromPiSensors")
    @ResponseBody
    public RPiSensorData getDataReadingsFromRPi() {
        return processor.sensorsDataReadings();
    }

    @GetMapping(value = "carbonation/{temperature}&{desiredCarb}")
    @ResponseBody
    public CarbCalcDto calculatedCarbonation(@PathVariable("temperature") int temperature, @PathVariable("desiredCarb") double desiredCarb) {
        return calculator.calculator(temperature, desiredCarb);
    }

    @PostMapping(value = "createNewBatch", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BatchDTO createNewBatch(@RequestBody BatchDTO batchDto) throws BatchNameAlreadyExistsException {
        if (mongoService.checkIfBatchNameExists(batchDto.batchName())) {
            throw new BatchNameAlreadyExistsException();
        } else {
            var persistentBatch = mongoService.saveReadings(batchMapper.mapToBatch(batchDto));
            return batchMapper.mapToBatchDto(persistentBatch);
        }
    }
}
