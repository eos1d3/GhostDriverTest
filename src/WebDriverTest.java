import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverTest {
	final static String twitterName = "replace_with_yours";
	final static String twitterPassword = "replace_with_yours";
	
	private static void test211() {
		WebDriver driver;
		DesiredCapabilities caps = new DesiredCapabilities();
		String[] phantomArgs = new  String[] {
				//			    "--webdriver-loglevel=NONE"
				"--load-images=false",
		};

		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_PATH_PROPERTY, "/Volumes/Macintosh Data/Users/andy/Desktop/ghostdriver-master/src/main.js");
		driver = new PhantomJSDriver(caps);

		try {
			System.out.println("Login");
			driver.get("https://auth.cbox.naver.com/oauth/login/twitter?redirectUrl=http%3A%2F%2Fentertain.naver.com%2Fread%3Foid%3D213%26aid%3D0000929636");
			if (!driver.getTitle().equals("Twitter / Authorize an application")) {
				System.out.println("   Bad Login Page : " + driver.getTitle());
				System.exit(0);
			}
			System.out.println("Name:");
			driver.findElement(By.id("username_or_email")).sendKeys(twitterName);
			System.out.println("Password");
			driver.findElement(By.id("password")).sendKeys(twitterPassword);
			System.out.println("Click");
			driver.findElement(By.id("allow")).click();

			
			for ( org.openqa.selenium.Cookie c : driver.manage().getCookies())
				System.out.println("Cookies: " + c.getName() + "," +c.getValue());

			System.out.println("URL: " + driver.getCurrentUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.close();
		System.out.println("Done");
	}
	
	private static void test198() {
		WebDriver driver;
		DesiredCapabilities caps = new DesiredCapabilities();
		String[] phantomArgs = new  String[] {
				//			    "--webdriver-loglevel=NONE"
				"--load-images=false",
		};

		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
//		caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_PATH_PROPERTY, "/Volumes/Macintosh Data/Users/andy/Desktop/ghostdriver-master/src/main.js");
				caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs-1.9.8");    
		driver = new PhantomJSDriver(caps);

		try {
			System.out.println("Login");
			driver.get("https://auth.cbox.naver.com/oauth/login/twitter?redirectUrl=http%3A%2F%2Fentertain.naver.com%2Fread%3Foid%3D213%26aid%3D0000929636");
			if (!driver.getTitle().equals("Twitter / Authorize an application")) {
				System.out.println("   Bad Login Page : " + driver.getTitle());
				System.exit(0);
			}
			System.out.println("Name:");
			driver.findElement(By.id("username_or_email")).sendKeys(twitterName);
			System.out.println("Password");
			driver.findElement(By.id("password")).sendKeys(twitterPassword);
			System.out.println("Click");
			driver.findElement(By.id("allow")).click();

			for ( org.openqa.selenium.Cookie c : driver.manage().getCookies())
				System.out.println("Cookies: " + c.getName() + "," +c.getValue());

			System.out.println("URL: " + driver.getCurrentUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.close();
		System.out.println("Done");
	}
	
	public static void main(String[] args) {
		test198();
		test211();
	}

}
