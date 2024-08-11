package com.rubensgomes.springstruts.web.struts2.action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionSupport
import org.apache.struts2.convention.annotation.Namespace
import org.apache.struts2.convention.annotation.Result
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Responsible to handle web requests to the index page.
 *
 * @author Rubens Gomes
 */
@Result(
    name = [Action.SUCCESS],
    location = "/WEB-INF/content/index.jsp",
    type = "dispatcher",
)
@Namespace("/")
class IndexAction : ActionSupport() {
    override fun execute(): String {
        log.trace("execute index action")
        return SUCCESS
    }

    internal companion object {
        private val log: Logger =
            LoggerFactory.getLogger(IndexAction::class.java)
    }
}
