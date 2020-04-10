package org.dfm.facility

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.dfm.facility.domain.FacilityDomain
import org.dfm.facility.domain.port.ObtainFacility
import org.dfm.facility.domain.port.RequestFacility
import org.dfm.facility.repository.config.JpaAdapterConfig

@SpringBootApplication
class FacilityE2EApplication {

  @TestConfiguration
  @Import(JpaAdapterConfig::class)
  class FacilityConfig {
    @Bean
    fun getRequestFacility(obtainFacility: ObtainFacility): RequestFacility {
      return FacilityDomain(obtainFacility)
    }
  }
}

fun main(args: Array<String>) {
  SpringApplication.run(FacilityE2EApplication::class.java)
}
