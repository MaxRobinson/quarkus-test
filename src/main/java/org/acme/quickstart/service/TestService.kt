package org.acme.quickstart.service

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.acme.common.MyInfo
import org.acme.totallydifferentpackage.MyData
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TestService {


    fun serviceFun() : String {

        // Try to load a class via the SystemClassLoader
        // THIS WILL FAIL when running `mvn compile quarkus:dev`
        ClassLoader.getSystemClassLoader().loadClass(MyInfo::class.java.name)

        return "Passed Class Loading!"
    }

    fun serviceLoadResource(): String {
        val mapper = YAMLMapper()
        mapper.registerKotlinModule()

        val resource = TestService::class.java.getResource("test.yaml")
        mapper.readValue<MyData>(resource)
        return "Loaded Yaml File"
    }
}