package org.json.junit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JunitApplication

fun main(args: Array<String>) {
    runApplication<JunitApplication>(*args)
}
