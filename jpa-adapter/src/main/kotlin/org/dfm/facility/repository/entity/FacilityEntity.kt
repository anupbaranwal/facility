package org.dfm.facility.repository.entity

import org.dfm.facility.domain.model.Facility
import javax.persistence.*
import javax.persistence.GenerationType.AUTO

@Table(name = "T_FACILITY")
@Entity
data class FacilityEntity(
    @Id
    @GeneratedValue(strategy = AUTO)
    private val id: Long? = null,
    @Column(name = "DESCRIPTION")
    private val description: String) {
  fun toModel(): Facility {
    return Facility(id, description)
  }
}
