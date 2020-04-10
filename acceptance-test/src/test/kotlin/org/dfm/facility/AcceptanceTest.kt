package org.dfm.facility

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.dfm.facility.domain.FacilityDomain
import org.dfm.facility.domain.model.Facility
import org.dfm.facility.domain.port.ObtainFacility

@ExtendWith(MockitoExtension::class)
@RunWith(JUnitPlatform::class)
class AcceptanceTest {

  @Test
  fun `should be able to get facilities when asked for facilities from hard coded facilities`() {
    /*
      RequestFacility    - left side port
      FacilityDomain     - hexagon (domain)
      ObtainFacility     - right side port
    */
    val requestFacility = FacilityDomain() // the poem is hard coded
    val facilityInfo = requestFacility.getFacilities()
    assertThat(facilityInfo).isNotNull
    assertThat(facilityInfo.facilities).isNotEmpty.extracting("description")
        .contains("If you could read a leaf or tree\r\nyoud have no need of books.\r\n-- Alistair Cockburn (1987)")
  }

  @Test
  fun `should be able to get facilities when asked for facilities from stub`(@Mock obtainFacility: ObtainFacility) {
    // Stub
    val facility = Facility(1L, "I want to sleep\r\nSwat the flies\r\nSoftly, please.\r\n\r\n-- Masaoka Shiki (1867-1902)")
    Mockito.lenient().`when`(obtainFacility.getAllFacilities()).thenReturn(listOf(facility))
    // hexagon
    val requestFacility = FacilityDomain(obtainFacility)
    val facilityInfo = requestFacility.getFacilities()
    assertThat(facilityInfo).isNotNull
    assertThat(facilityInfo.facilities).isNotEmpty.extracting("description")
        .contains("I want to sleep\r\nSwat the flies\r\nSoftly, please.\r\n\r\n-- Masaoka Shiki (1867-1902)")
  }
}
