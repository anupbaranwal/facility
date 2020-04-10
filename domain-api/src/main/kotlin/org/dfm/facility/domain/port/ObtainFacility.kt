package org.dfm.facility.domain.port

import org.dfm.facility.domain.model.Facility

interface ObtainFacility {

  fun getAllFacilities(): List<Facility> {
    val facility = Facility(1L, "If you could read a leaf or tree\r\nyoud have no need of books.\r\n-- Alistair Cockburn (1987)")
    return listOf(facility)
  }
}
