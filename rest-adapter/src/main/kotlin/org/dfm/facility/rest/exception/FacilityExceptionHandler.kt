package org.dfm.facility.rest.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import org.dfm.facility.domain.exception.FacilityNotFoundException

@RestControllerAdvice(basePackages = ["org.dfm.facility"])
class FacilityExceptionHandler {

  @ExceptionHandler(value = [FacilityNotFoundException::class])
  fun handleFacilityNotFoundException(request: WebRequest): ResponseEntity<FacilityExceptionResponse> {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FacilityExceptionResponse("Facility not found", (request as ServletWebRequest).request.requestURI))
  }
}
