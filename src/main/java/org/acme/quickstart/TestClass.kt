package org.acme.quickstart

import org.acme.quickstart.service.TestService
import java.util.logging.Logger
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/hello")
class TestClass {

    companion object val LOG: Logger = Logger.getLogger(TestClass::class.java.name)

    @Inject
    lateinit var service: TestService

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "hello"

    @GET
    @Path("/world")
    @Produces(MediaType.APPLICATION_JSON)
    fun echo() : Response {
        try {
            val value = service.serviceFun()
            return Response.ok(value).build()
        } catch (ex: Exception) {
            LOG.severe("SHIT!!!!")
            LOG.severe("SHIT!!!! ${ex.message}")
        }
        return Response.status(500).build()
    }
}