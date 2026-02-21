package hackethon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidationCheck {
	public void invalidEmail(WebDriver driver){
//		Launch the MoRent website
//		https://morent-car.archisacademy.com/
		driver.get("https://morent-car.archisacademy.com/");
//		Wait for the Home page to load completely.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains(driver.getTitle()));
//		Navigate to the registration page
		driver.navigate().to("https://ethical-lizard-51.accounts.dev/sign-up?redirect_url=https%3A%2F%2Fmorent-car.archisacademy.com%2F");
		wait.until(ExpectedConditions.urlContains("sign-up"));
		
		WebElement firstName=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#firstName-field")));
		firstName.sendKeys("John");
		
		WebElement secondName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lastName-field\"]")));
		secondName.sendKeys("Doe");
		
		WebElement email=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"emailAddress-field\"]")));
		email.sendKeys("user.com");
		
		WebElement password=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password-field\"]")));
		password.sendKeys("Password@12345");
		
		WebElement submit=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/div/div/div[1]/div[2]/form/div[2]/div[2]/button")));
		submit.click();
		
		
	}
	public String invalidPassword(WebDriver driver){
//		Launch the MoRent website
//		https://morent-car.archisacademy.com/
		driver.get("https://morent-car.archisacademy.com/");
//		Wait for the Home page to load completely.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains(driver.getTitle()));
//		Navigate to the registration page
		driver.navigate().to("https://ethical-lizard-51.accounts.dev/sign-up?redirect_url=https%3A%2F%2Fmorent-car.archisacademy.com%2F");
		wait.until(ExpectedConditions.urlContains("sign-up"));
		
		WebElement firstName=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#firstName-field")));
		firstName.sendKeys("John");
		
		WebElement secondName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lastName-field\"]")));
		secondName.sendKeys("Doe");
		
		WebElement email=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"emailAddress-field\"]")));
		email.sendKeys("morent+clerk_test@example.com");
		
		WebElement password=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password-field\"]")));
		password.sendKeys("Pas");
		WebElement errorMessage= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password-info-feedback\"]")));
		String errorMsg=errorMessage.getText();
		
		WebElement submit=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/div/div/div[1]/div[2]/form/div[2]/div[2]/button")));
		submit.click();
		
		return errorMsg;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		ValidationCheck ob =new ValidationCheck();
		ob.invalidEmail(driver);
		String passwordMessage=ob.invalidPassword(driver);
		System.out.println("Passowrd error message :"+passwordMessage);
		

	}

}
