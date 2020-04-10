package org.dfm.facility.rest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.ComponentScan
import org.dfm.facility.domain.port.RequestFacility

@SpringBootApplication
@ComponentScan(basePackages = ["org.dfm.facility"])
class FacilityPoetryRestAdapterApplication {

  @MockBean
  private lateinit var requestFacility: RequestFacility
}

fun main(args: Array<String>) {
  SpringApplication.run(FacilityPoetryRestAdapterApplication::class.java, *args)
}
