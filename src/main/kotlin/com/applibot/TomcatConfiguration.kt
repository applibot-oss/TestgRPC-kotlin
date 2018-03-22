package com.applibot

import org.apache.catalina.connector.Connector
import org.apache.coyote.AbstractProtocol
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties
class TomcatConfiguration {

    private fun createHTTP1Connector(): Connector {
        val connector = Connector("HTTP/1.1")
        connector.port = 7000
        return connector
    }

    @Bean
    fun servletWebServer(): ConfigurableServletWebServerFactory {
        val factory = TomcatServletWebServerFactory()
        factory.addAdditionalTomcatConnectors(createHTTP1Connector())
        factory.addConnectorCustomizers(
                TomcatConnectorCustomizer { connector ->
                    connector.enableLookups = false
                    connector.useBodyEncodingForURI = true
                    val protocol = connector.protocolHandler as AbstractProtocol<*>
                    protocol.maxThreads = 512
                    protocol.minSpareThreads = 25
                    protocol.connectionTimeout = 300 * 1000
                }
        )
        return factory
    }


}