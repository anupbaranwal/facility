package org.dfm.facility.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.dfm.facility.domain.model.FacilityInfo
import org.dfm.facility.domain.port.RequestFacility

@RestController
@RequestMapping("/api/v1/facilities")
class FacilityResource(private val requestFacility: RequestFacility) {

  @GetMapping
  fun getFacilities(): ResponseEntity<FacilityInfo> {
    return ResponseEntity.ok(requestFacility.getFacilities())
  }
}
