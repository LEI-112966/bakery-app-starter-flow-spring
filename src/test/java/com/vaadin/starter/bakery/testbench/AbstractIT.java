package com.vaadin.starter.bakery.testbench;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;

import com.vaadin.starter.bakery.testbench.elements.ui.LoginViewElement;
import com.vaadin.starter.bakery.ui.utils.BakeryConst;
import com.vaadin.testbench.IPAddress;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchDriverProxy;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.parallel.ParallelTest;

/**
 * Abstract base class for integration tests using TestBench.
 * Provides setup and utility methods for browser-based UI tests.
 *
 * @param <E> the type of TestBenchElement for the view under test
 */
public abstract class AbstractIT<E extends TestBenchElement> extends ParallelTest {
	/**
	 * The base URL of the application under test.
	 */
	public String APP_URL = "http://localhost:8080/";

	static {
		// Let notifications persist longer during tests
		BakeryConst.NOTIFICATION_DURATION = 10000;
	}

	/**
	 * Rule for taking screenshots on test failure.
	 */
	@Rule
	public ScreenshotOnFailureRule screenshotOnFailure = new ScreenshotOnFailureRule(this, true);

	/**
	 * Sets up the test environment, including browser configuration.
	 * @throws Exception if setup fails
	 */
	@Override
	public void setup() throws Exception {
		if (getDesiredCapabilities().getBrowserName().equals(Browser.CHROME.browserName())
				&& Boolean.getBoolean("headless")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(true);
			setDriver(new ChromeDriver(chromeOptions));
		} else {
			super.setup();
		}
		if (getRunLocallyBrowser() == null) {
			APP_URL = "http://" + IPAddress.findSiteLocalAddress() + ":8080/";
		}
	}

	/**
	 * Returns the TestBench WebDriver proxy.
	 * @return TestBenchDriverProxy instance
	 */
	@Override
	public TestBenchDriverProxy getDriver() {
		return (TestBenchDriverProxy) super.getDriver();
	}

	/**
	 * Opens the Login view using the current driver and app URL.
	 * @return LoginViewElement instance
	 */
	protected LoginViewElement openLoginView() {
		return openLoginView(getDriver(), APP_URL);
	}

	protected LoginViewElement openLoginView(WebDriver driver, String url) {
		driver.get(url);
		return $(LoginViewElement.class).waitForFirst();
	}

	protected abstract E openView();

}
