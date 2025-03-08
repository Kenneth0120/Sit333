package sit707_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import java.time.Duration;

/**
 * @author Ahsan Habib
 */
public class SeleniumOperations {
	
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public static void open_chrome_and_close() {
		// Step 1: Locate chrome driver folder (chromium browser) in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/Blade/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		// Sleep a while
		sleep(5);

		// close chrome driver
		driver.close();
	}

	
	public static void open_chrome_maximize_close() {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/Blade/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(5);

		// Maximize chrome driver
		driver.manage().window().maximize();

		// Sleep a while
		sleep(5);

		// Close chrome driver
		driver.close();
	}

	
	public static void load_web_page_close() {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/Blade/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(5);

		// Open the URL in chromium browser.
		driver.get("https://www.google.com/");

		// Sleep a while
		sleep(5);

		// Close chrome driver
		driver.close();
	}

	
	/*
	 * You have to complete this function.
	 */
	public static void open_chrome_loadpage_resize_close() {
		// Fill your personal information.
		System.out.println("Hello from S222575621, Kin Ho Fung");

		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/Blade/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(2);

		/*
		 * Load google page.
		 */
		driver.get("https://www.google.com/");

		// Add WebDriverWait to ensure page load success
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Google"));

		/*
		 * Set window size manually to 640x480 and wait 2 seconds.
		 * Hint: Explore Selenium window functions to select one which allows to pass
		 * window size in WxH.
		 */
		driver.manage().window().setSize(new Dimension(640, 480));
		sleep(2);

		/*
		 * Double window size manually to 1280x960 and wait 2 seconds.
		 */
		driver.manage().window().setSize(new Dimension(1280, 960));
		sleep(2);

		// Sleep a while
		sleep(2);

		// Close chrome driver
		driver.close();
	}
}
