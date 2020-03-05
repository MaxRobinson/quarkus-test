package org.acme.quickstart.service

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.acme.totallydifferentpackage.Hello
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TestService {
    val mapper = YAMLMapper()

    fun serviceFun() : Hello {
        val resource = TestService::class.java.getResource("test.yaml")
        return mapper.readValue(resource)
    }
}