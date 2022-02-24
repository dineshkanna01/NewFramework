package Utility;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {
	
	public JiraClient jira;
	public String project;
	
	
	
	public JiraServiceProvider(String jiraUrl, String username, String password, String project) {
		BasicCredentials cred=new BasicCredentials(username, password);
		jira = new JiraClient(jiraUrl, cred);
		this.project=project;
	}
	
	public void createJiraTicket(String issueType, String summary, String description, String reporterName) {
		try {
			FluentCreate createIssue = jira.createIssue(project, issueType);
			createIssue.field(Field.SUMMARY, summary);
			createIssue.field(Field.DESCRIPTION, description);
			Issue execute = createIssue.execute();
			System.out.println("New Jira ID: "+execute);
		} catch (JiraException e) {
			e.printStackTrace();
		}
	}
}
