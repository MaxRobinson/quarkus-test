# Purpose is to reproduce a specific behavior in Quarkus
There appears to be a difference in behavior between `mvn compile quarkus:dev` 
and running the runner jar `java -jar target/kotlin-test-1.0-SNAPSHOT-runner.jar`


To see the difference in behavior: 
* Package the application `mvn package`
* run in either dev mode or as jar
    * `java -jar target/kotlin-test-1.0-SNAPSHOT-runner.jar`
    * `mvn compile quarkus:dev`
* go to `localhost:8080/hello/failsDevMode`
    * if running the jar you should see `{"hello":"Passed Class Loading!"}`
    * if running in dev mode, you should see an error in your terminal
        * ```
          java.lang.ClassNotFoundException: org.acme.common.MyInfo
           	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
           	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
           	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
           	at org.acme.quickstart.service.TestService.serviceFun(TestService.kt:18)
           	at org.acme.quickstart.service.TestService_ClientProxy.serviceFun(TestService_ClientProxy.zig:219)
           	at org.acme.quickstart.TestResource.echo(TestResource.kt:31)
            ...
          ```
## Platform Specifics
* Kotlin:   1.3.61
* Java:     openJDK-11
* Maven:    3.6.3
* OS:       ubuntu 18.04

 


# kotlin-test project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `kotlin-test-1.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/kotlin-test-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/kotlin-test-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .