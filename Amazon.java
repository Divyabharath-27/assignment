package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		String e=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText().replaceAll("[^\\d]", "");
		int price = Integer.parseInt(e);
		System.out.println("The price of the first product is: "+price);
		
		WebElement b=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none a-spacing-top-micro']//div[@class='a-row a-size-small'])[1]"));
		System.out.println("ratings =" +b.getText());
	
		WebElement link=driver.findElement(By.xpath("(//div[@class='aok-relative']//a)[1]"));
				link.click();
				
				Set<String> windowHandle = driver.getWindowHandles();
				List<String> windowHandle1=new ArrayList<String>(windowHandle);
				driver.switchTo().window(windowHandle1.get(1));
				
				driver.findElement(By.id("add-to-cart-button")).click();
		

                String sub = driver.findElement(By.xpath("(//span[@class='a-price sw-subtotal-amount']//span)[4]")).getText().replaceAll("[^\\d]", "");
                    int  subPrice=Integer.parseInt(sub);
                    
                if (subPrice==price) {
                   System.out.println("Cart subtotal is correct: "+ subPrice);
                } 
                } 



}
	
