package listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.JiraPolicy;
import Utility.JiraServiceProvider;

public class JiraListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unused")
	public void onTestFailure(ITestResult result) {
		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean ticketReady = jiraPolicy.logTicketReady();
		JiraServiceProvider jirasp=new JiraServiceProvider("https://dkanna.atlassian.net/", "sekardineshkanna@gmail.com", "Disser01", "FW");
		String issueSummary=result.getMethod().getConstructorOrMethod().getMethod().getName() +"failed due to issue or exception";
		String issueDescription = result.getThrowable().getMessage();
		issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
		jirasp.createJiraTicket("Bug", issueSummary, issueDescription, "Dineshkanna");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
