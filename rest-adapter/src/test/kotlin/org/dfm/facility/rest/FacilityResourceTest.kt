package org.dfm.facility.rest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.dfm.facility.domain.model.Facility
import org.dfm.facility.domain.model.FacilityInfo
import org.dfm.facility.domain.port.RequestFacility

@ExtendWith(MockitoExtension::class)
@SpringBootTest(classes = [FacilityPoetryRestAdapterApplication::class], webEnvironment = RANDOM_PORT)
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class])
class FacilityResourceTest {
  companion object {
    private const val LOCALHOST = "http://localhost:"
    private const val API_URI = "/api/v1/facilities"
  }

  @LocalServerPort
  private val port: Int = 0
  @Autowired
  private lateinit var restTemplate: TestRestTemplate
  @Autowired
  private lateinit var requestFacility: RequestFacility

  @Test
  fun `should start the rest adapter application`() {
    assertThat(java.lang.Boolean.TRUE).isTrue()
  }

  @Test
  fun `should give facilities when asked for facilities with the support of domain stub`() {
    // Given
    Mockito.lenient().`when`(requestFacility.getFacilities()).thenReturn(mockFacilityInfo())
    // When
    val url = "$LOCALHOST$port$API_URI"
    val responseEntity = restTemplate.getForEntity(url, FacilityInfo::class.java)
    // Then
    assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
    assertThat(responseEntity.body).isNotNull
    assertThat(responseEntity.body.facilities).isNotEmpty.extracting("description").contains("Johnny Johnny Yes Papa !!")
  }

  private fun mockFacility(id: Long, description: String): Facility {
    return Facility(id, description)
  }

  private fun mockFacilityInfo(): FacilityInfo {
    return FacilityInfo(listOf(mockFacility(1L, "Johnny Johnny Yes Papa !!")))
  }
}
