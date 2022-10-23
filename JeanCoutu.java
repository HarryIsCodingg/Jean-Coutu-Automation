import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.*;

public class JeanCoutu {
	static {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Program Files (x86)\\Eclipse\\Sellenium\\web drivers\\geckodriver.exe");

	}
	static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) throws InterruptedException {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(
					new FileOutputStream("C:\\Users\\harry\\File.txt"));
			driver.get("https://www.jeancoutu.com/en/shopping/health/");
			int countExter = 0;
			driver.findElement(By.xpath("//*[@id=\"searchLandingPosition\"]/div/div[3]/div/div/div[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"searchLandingPosition\"]/div/div[3]/div/div/div[2]/ul/li[5]/a")).click();
			while (countExter <= 64) {

				int counterInt = 1;

				while (counterInt <= 60) {
					String name = driver
							.findElement(By.xpath("/html/body/main/div[2]/div/div[2]/div[2]/div[3]/div/div[1]/div["
									+ counterInt + "]/div/div/div[1]/div[1]"))
							.getText();
					String description = driver
							.findElement(By.xpath("html/body/main/div[2]/div/div[2]/div[2]/div[3]/div/div[1]/div["
									+ counterInt + "]/div/div/div[1]/div[2]"))
							.getText();
					String price = driver
							.findElement(By.xpath("html/body/main/div[2]/div/div[2]/div[2]/div[3]/div/div[1]/div["
									+ counterInt + "]/div/div/div[2]/div/div"))
							.getText();
					
																
					String address=driver.findElement(By.xpath("/html/body/main/div[2]/div/div[2]/div[2]/div[3]/div/div[1]/div["+counterInt+"]/div/div/a/img")).getAttribute("data-src");
					writer.println(name + ";" + description + ";" + price + ";" + 0+";"+address);
					counterInt++;
				}
				
				driver.findElement(By.xpath(
						"/html/body/main/div[2]/div/div[2]/div[2]/div[3]/div/div[2]/div[1]/div/nav/ul[3]/li[1]/span"))
						.click();
				countExter++;
				Thread.sleep(4000);
		}
		}catch (IOException e) {
			System.out.println("Error in writting to file \n"+e.getMessage());
		}
		catch(Exception e) {
			System.out.println("General error has occured \n"+e.getMessage());
		}
		finally {
			System.out.println("File has been closed successfully. ");
			writer.close();
		}
	

	}
}
