package org.dfm.facility.repository

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.dfm.facility.domain.port.ObtainFacility

@ExtendWith(SpringExtension::class)
@DataJpaTest
class FacilityJpaTest {

  @Autowired
  private lateinit var obtainFacility: ObtainFacility

  @Test
  fun `should start the application`() {
    assertThat(java.lang.Boolean.TRUE).isTrue()
  }

  @Sql(scripts = ["/sql/data.sql"])
  @Test
  fun `should give me facilities when asked for facilities from database`() {
    // Given from @Sql
    // When
    val facilities = obtainFacility.getAllFacilities()
    // Then
    assertThat(facilities).isNotNull.extracting("description").contains("Twinkle twinkle little star")
  }
}
