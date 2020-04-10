package org.dfm.facility.domain

import org.dfm.facility.domain.model.FacilityInfo
import org.dfm.facility.domain.port.ObtainFacility
import org.dfm.facility.domain.port.RequestFacility

class FacilityDomain(private val obtainFacility: ObtainFacility) : RequestFacility {

  constructor() : this(object : ObtainFacility {})

  override fun getFacilities(): FacilityInfo {
    return FacilityInfo(obtainFacility.getAllFacilities())
  }
}
