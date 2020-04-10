package org.dfm.facility.repository

import org.dfm.facility.domain.model.Facility
import org.dfm.facility.domain.port.ObtainFacility
import org.dfm.facility.repository.dao.FacilityDao

class FacilityRepository(private val facilityDao: FacilityDao) : ObtainFacility {

  override fun getAllFacilities(): List<Facility> {
    return facilityDao.findAll().map { it.toModel() }
  }
}
