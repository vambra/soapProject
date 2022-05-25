package lt.viko.eif.bstonkute.soap;

import io.spring.guides.gs_producing_web_service.*;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Data repository class. Holds information about the projects.
 *
 * @author Brigita Stonkutė
 */
@Component
public class ProjectRepository {
    private static final Map<String, Project> projects = new HashMap<>();

    /**
     * Fills the repository with initial data.
     */
    @PostConstruct
    public void initData() {
        Project project1 = new Project();
        project1.setCharacter("Watcher");
        project1.setSource("Horizon");
        project1.setDueDate("2021-01-01");
        project1.setStartDate("2020-02-02");
        project1.setFinishDate("2021-03-03");
        project1.setBudget(300f);
        ConventionList conventionList1 = new ConventionList();
        Convention convention11 = new Convention();
        convention11.setName("UniCon");
        convention11.setDate("2021-06-06");
        conventionList1.getConvention().add(convention11);
        Convention convention12 = new Convention();
        convention12.setName("GameOn");
        convention12.setDate("2022-07-07");
        conventionList1.getConvention().add(convention12);
        Competition competition11 = new Competition();
        competition11.setAward("2nd");
        competition11.setCategory("Duo");
        competition11.setPrize("merchandise");
        CompetitionList competitionList1 = new CompetitionList();
        competitionList1.getCompetition().add(competition11);
        convention12.setCompetitionList(competitionList1);
        project1.setConventionList(conventionList1);
        io.spring.guides.gs_producing_web_service.Component component11 = new io.spring.guides.gs_producing_web_service.Component();
        component11.setName("Head");
        component11.setCost(40f);
        Task task111 = new Task();
        task111.setName("Blueprint");
        task111.setProgress(100);
        task111.setTimeElapsedHours(BigInteger.valueOf(6));
        task111.setTimeElapsedMinutes(30);
        Task task112 = new Task();
        task112.setName("Frame");
        task112.setProgress(90);
        task112.setTimeElapsedHours(BigInteger.valueOf(13));
        task112.setTimeElapsedMinutes(45);
        TaskList taskList11 = new TaskList();
        taskList11.getTask().add(task111);
        taskList11.getTask().add(task112);
        component11.setTaskList(taskList11);
        io.spring.guides.gs_producing_web_service.Component component12 = new io.spring.guides.gs_producing_web_service.Component();
        component12.setName("Neck");
        component12.setCost(30f);
        Task task121 = new Task();
        task121.setName("Blueprint");
        task121.setProgress(100);
        task121.setTimeElapsedHours(BigInteger.valueOf(6));
        task121.setTimeElapsedMinutes(30);
        Task task122 = new Task();
        task122.setName("Frame");
        task122.setProgress(100);
        task122.setTimeElapsedHours(BigInteger.valueOf(13));
        task122.setTimeElapsedMinutes(45);
        TaskList taskList12 = new TaskList();
        taskList12.getTask().add(task121);
        taskList12.getTask().add(task122);
        component12.setTaskList(taskList12);
        io.spring.guides.gs_producing_web_service.Component component13 = new io.spring.guides.gs_producing_web_service.Component();
        component13.setName("Torso");
        component13.setCost(50f);
        component12.setName("Neck");
        component12.setCost(30f);
        Task task131 = new Task();
        task131.setName("Blueprint");
        task131.setProgress(100);
        task131.setTimeElapsedHours(BigInteger.valueOf(6));
        task131.setTimeElapsedMinutes(30);
        Task task132 = new Task();
        task132.setName("Frame");
        task132.setProgress(100);
        task132.setTimeElapsedHours(BigInteger.valueOf(13));
        task132.setTimeElapsedMinutes(45);
        TaskList taskList13 = new TaskList();
        taskList13.getTask().add(task131);
        taskList13.getTask().add(task132);
        component13.setTaskList(taskList13);
        ComponentList componentList1 = new ComponentList();
        componentList1.getComponent().add(component11);
        componentList1.getComponent().add(component12);
        componentList1.getComponent().add(component13);
        project1.setComponentList(componentList1);
        projects.put(project1.getCharacter(), project1);

        Project project2 = new Project();
        project2.setCharacter("Abyss Mage");
        project2.setSource("Genshin Impact");
        project2.setDueDate("2022-01-01");
        project2.setStartDate("2020-02-02");
        project2.setBudget(200f);
        projects.put(project2.getCharacter(), project2);
    }

    /**
     * Finds and returns a project by character name.
     *
     * @param name character name
     * @return retrieved project
     */
    public io.spring.guides.gs_producing_web_service.Project findProject(String name) {
        Assert.notNull(name, "The project's name must not be null");
        return projects.get(name);
    }

    /**
     * Sets the repository data.
     *
     * @param projectList list of projects
     */
    public void setProjects(ProjectList projectList) {
        projects.clear();
        for (Project project : projectList.getProject()) {
            projects.put(project.getCharacter(), project);
        }
    }
}
