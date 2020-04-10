package org.dfm.facility.boot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["org.dfm.facility"])
class FacilityApplication {
}

fun main(args: Array<String>) {
  SpringApplication.run(FacilityApplication::class.java, *args)
}
