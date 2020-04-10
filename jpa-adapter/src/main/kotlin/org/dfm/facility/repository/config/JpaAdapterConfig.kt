package org.dfm.facility.repository.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.dfm.facility.domain.port.ObtainFacility
import org.dfm.facility.repository.FacilityRepository
import org.dfm.facility.repository.dao.FacilityDao

@Configuration
@EntityScan("org.dfm.facility.repository.entity")
@EnableJpaRepositories("org.dfm.facility.repository.dao")
class JpaAdapterConfig {

  @Bean
  fun getFacilityRepository(facilityDao: FacilityDao): ObtainFacility {
    return FacilityRepository(facilityDao)
  }
}
