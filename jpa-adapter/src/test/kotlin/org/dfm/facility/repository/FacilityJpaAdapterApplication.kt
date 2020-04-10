package org.dfm.facility.repository

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.dfm.facility.domain.port.ObtainFacility
import org.dfm.facility.repository.dao.FacilityDao

@SpringBootApplication
class FacilityJpaAdapterApplication {

  fun main(args: Array<String>) {
    SpringApplication.run(FacilityJpaAdapterApplication::class.java, *args)
  }

  @TestConfiguration
  class FacilityJpaTestConfig {
    @Bean
    fun getObtainFacilityRepository(facilityDao: FacilityDao): ObtainFacility {
      return FacilityRepository(facilityDao)
    }
  }
}
