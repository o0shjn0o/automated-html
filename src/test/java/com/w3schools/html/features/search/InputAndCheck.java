package com.w3schools.html.features.search;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputAndCheck {
	
	
	public void Input() {
		System.setProperty("webdriver.chrome.driver", ".\\Webdrivers\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		//open website
		wd.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		
		//switch to frame result
		wd.switchTo().frame("iframeResult");
		WebElement name;
		
		//input data
		//first name
		name = wd.findElement(By.name("firstname"));
		name.clear();
		name.sendKeys("Long");
		
		//lastname
		name = wd.findElement(By.name("lastname"));
		name.clear();
		name.sendKeys("Le"); 
		
		//click button
		WebElement clickBtn = wd.findElement(By.xpath("//input[@type='submit']"));
		clickBtn.click();
		
		//get message
		WebElement msg = wd.findElement(By.xpath("//div[@class='w3-container w3-large w3-border']"));
		String contentMsg = msg.getText();
		
		//assert message
		Assert.assertEquals(contentMsg, "firstname=Long&lastname=Le ");
		
		
		wd.quit();
	}

}
