package org.dfm.facility.boot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.dfm.facility.domain.FacilityDomain
import org.dfm.facility.domain.port.ObtainFacility
import org.dfm.facility.domain.port.RequestFacility
import org.dfm.facility.repository.config.JpaAdapterConfig

@Configuration
@Import(JpaAdapterConfig::class)
class BootstrapConfig {

  @Bean
  fun getRequestFacility(obtainFacility: ObtainFacility): RequestFacility {
    return FacilityDomain(obtainFacility)
  }
}
