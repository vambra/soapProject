package lt.viko.eif.bstonkute.soap;

import io.spring.guides.gs_producing_web_service.Project;
import io.spring.guides.gs_producing_web_service.ProjectList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectRepositoryTest {

    private ProjectRepository repository;
    private ProjectList projectList;

    @BeforeEach
    void setUp(){
        repository = new ProjectRepository();
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
        projectList = new ProjectList();
        projectList.getProject().add(project1);
        projectList.getProject().add(project2);
    }

    @Test
    void findProject() {
        repository.setProjects(projectList);
        assertNotNull(repository.findProject("test1"));
        assertNotNull(repository.findProject("test2"));
        assertNull(repository.findProject("not found"));
    }

    @Test
    void setProjects() {
        assertNotNull(projectList);
        repository.setProjects(projectList);
        assertNotNull(repository.findProject("test1"));
        assertNotNull(repository.findProject("test2"));
    }
}