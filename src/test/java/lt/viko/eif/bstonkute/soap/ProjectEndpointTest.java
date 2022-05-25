package lt.viko.eif.bstonkute.soap;

import static org.junit.jupiter.api.Assertions.*;
import io.spring.guides.gs_producing_web_service.GetProjectRequest;
import io.spring.guides.gs_producing_web_service.GetProjectResponse;
import io.spring.guides.gs_producing_web_service.Project;
import io.spring.guides.gs_producing_web_service.ProjectList;
import org.junit.jupiter.api.Test;

class ProjectEndpointTest {

    @Test
    void getProject() {
        ProjectRepository repository = new ProjectRepository();
        Project project1 = new Project();
        project1.setCharacter("test1");
        project1.setSource("source1");
        project1.setDueDate("2021-01-01");
        project1.setStartDate("2022-02-02");
        project1.setFinishDate("2023-03-03");
        project1.setBudget(100f);
        Project project2 = new Project();
        project2.setCharacter("test2");
        project2.setSource("source2");
        project2.setDueDate("2000-01-01");
        project2.setStartDate("2000-02-02");
        project2.setFinishDate("2000-03-03");
        project2.setBudget(200f);
        ProjectList projectList = new ProjectList();
        projectList.getProject().add(project1);
        projectList.getProject().add(project2);
        repository.setProjects(projectList);
        ProjectEndpoint endpoint = new ProjectEndpoint(repository);
        GetProjectRequest request = new GetProjectRequest();
        request.setName("test1");
        GetProjectResponse response = new GetProjectResponse();
        response.setProject(repository.findProject(request.getName()));
        GetProjectResponse responseTest = endpoint.getProject(request);
        assertNotNull(responseTest);
        assertNotNull(responseTest.getProject());
        assertEquals(response.getProject(), responseTest.getProject());
        assertEquals(project1, responseTest.getProject());
    }
}