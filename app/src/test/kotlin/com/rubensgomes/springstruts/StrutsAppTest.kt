package com.rubensgomes.springstruts

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.springframework.boot.SpringApplication
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StrutsAppTest {
    @Test
    fun `ensure spring context loads`() {
        val context = SpringApplication.run(StrutsApp::class.java)
        assertNotNull(context)
    }
}
