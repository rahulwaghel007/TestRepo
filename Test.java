import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import javax.xml.bind.JAXBContext;

public class Test {

    private String status;

    @PostConstruct
    public void init() {
        status = "initialized";
    }

    @GET
    @Path("/hello")
    public Response hello() {
        return Response.ok("Hello").build();
    }

    public void testServlet(HttpServletRequest request) {
        assertNotNull(request);
    }

    public void validate(@Valid @NotNull String input) {
        assertNotNull(input);
    }

    public void testJaxb() throws Exception {
        JAXBContext.newInstance(String.class);
    }

    @Test
    public void simpleTest() {
        assertNotNull(status);
    }

    @PreDestroy
    public void cleanup() {
        status = null;
    }
}