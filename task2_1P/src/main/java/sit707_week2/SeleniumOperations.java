package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/Blade/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		// Add implicit wait for better element visibility
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Ahsan");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Locate and fill in Last Name
		WebElement lastName = driver.findElement(By.id("lastname"));
		lastName.sendKeys("Fung");

		// Locate and fill in Email
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("testemail@gmail.com");

		// Locate and fill in Phone Number
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phoneNumber")));
		phone.sendKeys("0412345678");

		// Locate and fill in Password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Test@123"); // Ensure this fails the password requirement deliberately

		// Locate and fill in Confirm Password
		WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
		confirmPassword.sendKeys("Test@123"); // Match the password field

		// Locate 'Create account' button using its 'data-testid' attribute
		WebElement createAccountButton = driver.findElement(By.cssSelector("button[data-testid='account-action-btn']"));
		createAccountButton.click();
		
		/*
		 * Take screenshot using selenium API.
		 */
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshot, new File("officeworks_registration_screenshot.png"));
		    System.out.println("Screenshot saved successfully!");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	public static void supercheapauto_registration_page(String url) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Blade/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		System.out.println("Driver info: " + driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		// Locate and fill in Email
		WebElement email = driver.findElement(By.id("dwfrm_profile_customer_email"));
		email.sendKeys("testemail@gmail.com");

		// Locate and fill in Confirm Email
		WebElement confirmEmail = driver.findElement(By.id("dwfrm_profile_customer_emailconfirm"));
		confirmEmail.sendKeys("testemail@gmail.com");

		// Locate and fill in Password
		WebElement password = driver.findElement(By.cssSelector("input[type='password'][id^='dwfrm_profile_login_password']"));
		password.sendKeys("Test123456");

		// Locate and fill in Confirm Password
		WebElement confirmPassword = driver.findElement(By.cssSelector("input[type='password'][id^='dwfrm_profile_login_passwordconfirm']"));
		confirmPassword.sendKeys("Test123456");

		// Locate and fill in First Name
		WebElement firstName = driver.findElement(By.id("dwfrm_profile_customer_firstname"));
		firstName.sendKeys("Ahsan");

		// Locate and fill in Last Name
		WebElement lastName = driver.findElement(By.id("dwfrm_profile_customer_lastname"));
		lastName.sendKeys("Fung");

		// Locate and fill in Mobile Number
		WebElement mobileNumber = driver.findElement(By.id("dwfrm_profile_addressregistration_registrationphone"));
		mobileNumber.sendKeys("0412345678");

		// Locate and click the Terms & Conditions checkbox
		WebElement termsCheckbox = driver.findElement(By.cssSelector("label[for='dwfrm_profile_customer_termsandconditions']"));
		termsCheckbox.click();

		// Add a short wait to ensure the button is enabled
		sleep(2);

		// Locate 'Join For Free' button using 'name' attribute
		WebElement joinButton = driver.findElement(By.cssSelector("button[name='dwfrm_profile_confirm']"));

		// Ensure the button is enabled before clicking
		if (joinButton.isEnabled()) {
			joinButton.click();
			System.out.println("Join For Free button clicked successfully.");
		} else {
			System.out.println("Join For Free button is still disabled.");
		}

		// Take a screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshot, new File("supercheapauto_registration_screenshot.png"));
			System.out.println("Screenshot saved successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		sleep(2);
		driver.close();
	}
}