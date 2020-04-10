package org.dfm.facility.domain.port

import org.dfm.facility.domain.model.FacilityInfo

interface RequestFacility {
  fun getFacilities(): FacilityInfo
}
