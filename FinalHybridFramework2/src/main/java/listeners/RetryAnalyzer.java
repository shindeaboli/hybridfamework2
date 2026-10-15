package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 101;
	int maxCounter = 104;

	@Override
	public boolean retry(ITestResult result) {

		if (counter < maxCounter) {
			
			counter++;
			
			return true;
		}

		return false;
	}

}
