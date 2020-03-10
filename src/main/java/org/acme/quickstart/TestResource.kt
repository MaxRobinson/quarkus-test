package org.acme.quickstart

import org.acme.quickstart.service.TestService
import java.util.logging.Logger
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/hello")
class TestResource {

    companion object val LOG: Logger = Logger.getLogger(TestResource::class.java.name)

    @Inject
    @field: Default
    lateinit var service: TestService

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "hello"

    @GET
    @Path("/failsDevMode")
    @Produces(MediaType.APPLICATION_JSON)
    fun echo() : Response {
        try {
            val value = service.serviceFun()
            val resp = HashMap<String, String>()
            resp["hello"] = value
            return Response.ok(resp).build()
        } catch (ex: Exception) {
            LOG.severe("Exception Occurred: ${ex.message}")
            ex.printStackTrace()
        }
        return Response.status(500).build()
    }

    @GET
    @Path("/passes")
    @Produces(MediaType.APPLICATION_JSON)
    fun fails(): Response{
        try {
            val value = service.serviceLoadResource()
            val resp = HashMap<String, String>()
            resp["hello"] = value
            return Response.ok(resp).build()
        } catch (ex: Exception) {
            LOG.severe("Exception Occurred: ${ex.message}")
            ex.printStackTrace()
        }
        return Response.status(500).build()
    }
}