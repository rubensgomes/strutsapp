package com.rubensgomes.springstruts.web.action

import org.apache.struts2.ActionProxy
import org.apache.struts2.ActionSupport
import org.apache.struts2.junit.StrutsSpringTestCase
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class IndexActionTest : StrutsSpringTestCase() {
    @BeforeEach
    fun setup() {
        // must call super.setup() to initialize web mock objects
        super.setUp()
    }

    @Test
    fun `ensure execute method returns SUCCESS`() {
        val actionProxy: ActionProxy = getActionProxy("/index.do")
        val result = actionProxy.execute()
        Assert.assertEquals(ActionSupport.SUCCESS, result)
    }
}
