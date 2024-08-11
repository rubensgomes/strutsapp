package com.rubensgomes.springstruts.config

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered

/**
 * Class responsible to register Servlet Filters.
 *
 * @author Rubens Gomes
 */
@Configuration
class WebFilterConfig {
    @Bean
    fun struts2Filter(): FilterRegistrationBean<StrutsPrepareAndExecuteFilter> {
        log.trace("registering strutsPrepareAndExecuteFilter")
        val registration = FilterRegistrationBean<StrutsPrepareAndExecuteFilter>()
        registration.filter = StrutsPrepareAndExecuteFilter()
        registration.order = Ordered.LOWEST_PRECEDENCE
        registration.addUrlPatterns("*.do")
        registration.setName("StrutsFilter")
        return registration
    }

    internal companion object {
        private val log: Logger =
            LoggerFactory.getLogger(WebFilterConfig::class.java)
    }
}
