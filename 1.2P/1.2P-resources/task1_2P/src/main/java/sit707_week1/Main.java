package sit707_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

public class Main {

	/*
	 * Main entry point of a Java program.
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

	    SeleniumOperations.sleep(2);


	    /*
	     * Load google page.
	     */
	    driver.get("https://www.google.com");

	    /*
	     * Set window size manually to 640x480 and wait 2 seconds.
	     */
	    driver.manage().window().setSize(new Dimension(640, 480));
	    SeleniumOperations.sleep(2);


	    /*
	     * Double window size manually to 1280x960 and wait 2 seconds.
	     */
	    driver.manage().window().setSize(new Dimension(1280, 960));
	    SeleniumOperations.sleep(2);


	    // Sleep a while
	    SeleniumOperations.sleep(2);


	    // Close chrome driver. You can comment this line to keep the browser opened.
	    driver.close();    
	}
	
	public static void main(String[] args) {

		int choice = 4;

		switch (choice) {
		case 1:
			SeleniumOperations.open_chrome_and_close();
			break;
		case 2:
			SeleniumOperations.open_chrome_maximize_close();
			break;
		case 3:
			SeleniumOperations.load_web_page_close();
			break;
		case 4:
			SeleniumOperations.open_chrome_loadpage_resize_close();
			break;
		default:
			System.out.println("Invalid choice.");
			break;
		}
	}
}
