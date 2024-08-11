package com.rubensgomes.springstruts

import org.springframework.boot.SpringApplication
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test
import kotlin.test.assertNotNull

@SpringBootTest
class StrutsAppTest {
    @Test
    fun `ensure spring context loads`() {
        val context = SpringApplication.run(StrutsApp::class.java)
        assertNotNull(context)
    }
}
