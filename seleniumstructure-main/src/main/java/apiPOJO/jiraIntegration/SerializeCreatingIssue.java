package apiPOJO.jiraIntegration;

import io.restassured.RestAssured;

public class SerializeCreatingIssue {

    public CreateIssue createJson(String summary, String description, String steps) {
        RestAssured.baseURI = "https://stagingjira.sixsentix.com";

        CreateIssue createIssue = new CreateIssue();
        Fields fields = new Fields();
        Project project = new Project();
        Issuetype issueType = new Issuetype();

        project.setKey("ST"); //ToDo -> set project Key from JIRA
        issueType.setName("Bug"); //ToDo -> set project issue type (ex. Bug)
        fields.setProject(project);
        fields.setIssuetype(issueType);
        fields.setSummary(summary);
        fields.setDescription(steps + "\n" + "Result : \n" + description);
        createIssue.setFields(fields);

        return createIssue;
    }

}
