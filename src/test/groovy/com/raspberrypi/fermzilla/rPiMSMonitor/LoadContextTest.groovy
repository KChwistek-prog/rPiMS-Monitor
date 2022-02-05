package com.raspberrypi.fermzilla.rPiMSMonitor

import com.raspberrypi.fermzilla.rPiMSMonitor.monitorOutput.MonitorEndpoints
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LoadContextTest extends Specification{

    @Autowired(required = false)
    private MonitorEndpoints monitorEndpoints

    def "should create beans when context is loaded"(){
        expect: "the MonitorEndpoints is created"
        monitorEndpoints
    }
}
