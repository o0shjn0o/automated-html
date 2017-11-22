package com.w3schools.html.features.search;


import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.IsEqual;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.hamcrest.text.IsEqualIgnoringWhiteSpace;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CheckXpath {
	@Test
	public void Check() {
		System.setProperty("webdriver.chrome.driver", ".\\Webdrivers\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		// open website
		wd.get("http://demoqa.com/");
		
		// check number of tabs 
		int number;
		number = wd.findElements(By.xpath("//div[@id='tabs222']/ul/child::li")).size();
		Assert.assertEquals(number, 5);
		
		// check tab 4 is focus
		WebElement tab4;
		tab4 = wd.findElement(By.xpath("//div[@id='tabs222']/ul/li[4]"));
		tab4.click();
		assertThat(tab4.getAttribute("class"), containsString("ui-state-focus ui-tabs-active ui-state-active"));
		
		
		wd.navigate().to("http://demoqa.com/registration/");
		
		//
		WebElement clickbtn;
		wd.findElement(By.xpath("//input[@name='pie_submit']")).click();
		
		String checkError;
		// check error for tab name
		checkError = wd.findElement(By.xpath("//input[@id='name_3_lastname']/parent::*/following-sibling::*/span")).getText();
		assertThat(checkError, equalTo("* This field is required"));
		
		// check error for hobby
		checkError = wd.findElement(By.xpath("//input[@value='dance']/parent::*/following-sibling::*/span")).getText();
		assertThat(checkError, equalTo("* This field is required"));
		
		// check error for phone
		checkError = wd.findElement(By.xpath("//input[@id='phone_9']//following-sibling::*/span")).getText();
		assertThat(checkError, equalTo("* This field is required"));
		
		// check error for username
		checkError = wd.findElement(By.xpath("//input[@id='username']/following-sibling::*/span")).getText();
		assertThat(checkError, equalTo("* This field is required"));
		
		// check error for email
		checkError = wd.findElement(By.xpath("//input[@id='email_1']/following-sibling::*/span")).getText();
		assertThat(checkError, equalTo("* This field is required"));
		
		// check error for password
		checkError = wd.findElement(By.xpath("//input[@id='password_2']/following-sibling::*/span")).getText();
		assertThat(checkError, equalTo("* This field is required"));
		
		// check error for confirm password
		checkError = wd.findElement(By.xpath("//input[@id='confirm_password_password_2']/following-sibling::*/span")).getText();
		assertThat(checkError, equalTo("* This field is required"));
		
		wd.quit();
	}
	
	

}
