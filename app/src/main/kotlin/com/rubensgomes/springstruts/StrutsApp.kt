package com.rubensgomes.springstruts

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

/**
 * Spring Boot does not support JSP pages packaged as a jar. Since we are
 * redering JSP pages on this webapp we MUST package the webapp as a WAR
 * instead.
 *
 * @author Rubens Gomes
 */
@SpringBootApplication
class StrutsApp : SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        logger.debug("Starting application  in a WAR container. ")
        return application.sources(StrutsApp::class.java)
    }
}

private val log: Logger = LoggerFactory.getLogger(StrutsApp::class.java)

/*
 * The main function is declared inside package com.rubensgomes.springstruts,
 * and it is compiled into static method of a Java class named StrutsAppKt
 */
fun main(args: Array<String>) {
    log.trace("Starting application")
    runApplication<StrutsApp>(*args)
}
