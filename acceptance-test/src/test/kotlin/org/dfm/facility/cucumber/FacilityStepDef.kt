package org.dfm.facility.cucumber

import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import io.cucumber.java8.HookNoArgsBody
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.dfm.facility.FacilityE2EApplication
import org.dfm.facility.domain.model.Facility
import org.dfm.facility.domain.model.FacilityInfo
import org.dfm.facility.repository.dao.FacilityDao
import org.dfm.facility.repository.entity.FacilityEntity


@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [FacilityE2EApplication::class], webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = [FacilityE2EApplication::class], loader = SpringBootContextLoader::class)
class FacilityStepDef(restTemplate: TestRestTemplate, facilityDao: FacilityDao) : En {

  companion object {
    private const val LOCALHOST = "http://localhost:"
    private const val API_URI = "/api/v1/facilities"
  }

  @LocalServerPort
  private val port: Int = 0
  private lateinit var responseEntity: ResponseEntity<FacilityInfo>

  init {

    DataTableType { row: Map<String, String> -> Facility(1L, row["description"].toString()) }
    DataTableType { row: Map<String, String> -> FacilityEntity(1L, row["description"].toString()) }

    Before(HookNoArgsBody { facilityDao.deleteAll() })
    After(HookNoArgsBody { facilityDao.deleteAll() })

    Given("the following facilities exists in the library") { dataTable: DataTable ->
      val facilities = dataTable.asList<FacilityEntity>(FacilityEntity::class.java)
      facilityDao.saveAll(facilities)
    }

    When("user requests for all facilities") {
      val url = "$LOCALHOST$port$API_URI"
      responseEntity = restTemplate.getForEntity(url, FacilityInfo::class.java)
    }

    Then("the user gets the following facilities") { dataTable: DataTable ->
      val expectedFacilities = dataTable.asList<Facility>(Facility::class.java)
      assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
      assertThat(responseEntity.body).isNotNull
      assertThat(responseEntity.body.facilities).isNotEmpty.extracting("description")
          .contains(expectedFacilities.map { it.description }[0])
    }
  }
}


