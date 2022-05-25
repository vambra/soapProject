package lt.viko.eif.bstonkute.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Web service configuration class.
 *
 * @author Brigita Stonkutė
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    /**
     * Context to register the web service as a servlet.
     *
     * @param applicationContext application context and configuration data
     * @return servlet registration bean
     */
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    /**
     * Creates the {@link DefaultWsdl11Definition}.
     *
     * @param projectsSchema projects' web service XSD schema
     * @return WSDL11 definition
     */
    @Bean(name = "projects")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema projectsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProjectsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
        wsdl11Definition.setSchema(projectsSchema);
        return wsdl11Definition;
    }

    /**
     * Creates the XSD schema from the XSD file.
     *
     * @return xsd schema
     */
    @Bean
    public XsdSchema projectsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("projectData.xsd"));
    }
}