package com.rubensgomes.springstruts

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StrutsApp

private val log: Logger = LoggerFactory.getLogger(StrutsApp::class.java)

fun main(args: Array<String>) {
    log.trace("Starting application")
    runApplication<StrutsApp>(*args)
}
