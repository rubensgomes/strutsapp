package com.rubensgomes.springstruts.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Class responsible to configure Spring Web MVC objects.
 *
 * @author Rubens Gomes
 */
@Configuration
class WebMvcConfig : WebMvcConfigurer {
    override fun addViewControllers(registry: ViewControllerRegistry) {
        log.debug("configuring URL root path / to redirect to $INDEX_PAGE_URL")
        registry.addRedirectViewController("/", INDEX_PAGE_URL)
    }

    internal companion object {
        private const val INDEX_PAGE_URL = "/index.do"
        private val log: Logger =
            LoggerFactory.getLogger(WebMvcConfig::class.java)
    }
}
