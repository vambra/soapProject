package lt.viko.eif.bstonkute.soap;

import org.junit.jupiter.api.Test;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;

import static org.junit.jupiter.api.Assertions.*;

class WebServiceConfigTest {

    @Test
    void defaultWsdl11Definition() {
        WebServiceConfig webServiceConfig = new WebServiceConfig();
        DefaultWsdl11Definition TestWsdl11Definition = webServiceConfig.defaultWsdl11Definition(webServiceConfig.projectsSchema());
        assertNotNull(TestWsdl11Definition);
    }

    @Test
    void projectsSchema() {
        WebServiceConfig webServiceConfig = new WebServiceConfig();
        XsdSchema xsdSchema = webServiceConfig.projectsSchema();
        assertNotNull(xsdSchema);
    }
}