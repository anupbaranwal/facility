package org.dfm.facility.repository.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.dfm.facility.repository.entity.FacilityEntity

@Repository
interface FacilityDao : JpaRepository<FacilityEntity, Long>
