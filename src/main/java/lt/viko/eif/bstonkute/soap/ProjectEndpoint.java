package lt.viko.eif.bstonkute.soap;

import io.spring.guides.gs_producing_web_service.GetProjectRequest;
import io.spring.guides.gs_producing_web_service.GetProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Web service endpoint class.
 *
 * @author Brigita Stonkutė
 */
@Endpoint
public class ProjectEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private ProjectRepository projectRepository;

    /**
     * Class constructor.
     *
     * @param projectRepository project data repository
     */
    @Autowired
    public ProjectEndpoint(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Returns the requested project data.
     *
     * @param request message request for a project
     * @return message response with project data
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProjectRequest")
    @ResponsePayload
    public GetProjectResponse getProject(@RequestPayload GetProjectRequest request) {
        GetProjectResponse response = new GetProjectResponse();
        response.setProject(projectRepository.findProject(request.getName()));
        return response;
    }
}