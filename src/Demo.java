import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {
	static String url = "https://www.google.com/";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shaq5\\eclipse-workspace\\Project\\target\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.xpath("//input[@title='Search']"));
		search.sendKeys("RTS Labs");
		search.submit();
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
		driver.findElement(By.xpath("//h3[text()=\"RTS Labs\"]")).click();

		System.out.println(driver.getTitle());
		String actualTitle = driver.getTitle();
		String expectedTitle = "Custom Software Development, Data Analytics, Salesforce Consulting";

		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
		driver.close();
		driver.quit();
	}

}
