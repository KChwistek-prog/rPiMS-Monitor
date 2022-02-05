package com.raspberrypi.fermzilla.rPiMSMonitor.monitorOutput

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@AutoConfigureMockMvc
@SpringBootTest
class MonitorOutputTests extends Specification{

    @Autowired
    private MockMvc mvc

    def "Should get message from helloEndpoint"(){
        expect: "Status is 200 and the response is 'Hello'"
        this.mvc.perform(get("/hello"))
        .andExpect(status().isOk())
        .andReturn()
        .response
        .contentAsString == "Hello"
    }

}
