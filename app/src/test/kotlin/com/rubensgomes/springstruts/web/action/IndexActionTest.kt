package com.rubensgomes.springstruts.web.action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionProxy
import org.apache.struts2.junit.StrutsSpringTestCase
import kotlin.test.BeforeTest
import kotlin.test.Test

class IndexActionTest : StrutsSpringTestCase() {
    @BeforeTest
    fun setup() {
        // must call super.setup() to initialize web mock objects
        super.setUp()
    }

    @Test
    fun `ensure execute method returns SUCCESS`() {
        val actionProxy: ActionProxy = getActionProxy("/index.do")
        val result = actionProxy.execute()
        kotlin.test.assertEquals(Action.SUCCESS, result)
    }
}
