package com.tenreiro.daniel;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }

    /**
     *
     */
    @Bean
    public EmbeddedServletContainerCustomizer servletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {

            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
                tomcat.addConnectorCustomizers(getBasicTomcatConnectorCustomizer());
            }
        };
    }

    /**
     * Tomcat Customizer
     * This method implements the method customize from the callback interface TomcatConnectorCustomizer.
     *
     * This allow us to customize a new Tomcat with the configuration of the "application.yml file".
     *
     * @return A implementation of the TomcatConnectorCustomizer interface
     */
    private TomcatConnectorCustomizer getBasicTomcatConnectorCustomizer() {

        return new TomcatConnectorCustomizer() {

            @Override
            public void customize(Connector connector) {
                connector.setRedirectPort(443);
                connector.setURIEncoding("UTF-8");
                connector.setProtocol("org.apache.coyote.http11.Http11Nio2Protocol");
                connector.setProperty("acceptorThreadCount", "2");
                connector.setProperty("connectionTimeout", "30000");
            }
        };
    }
}
