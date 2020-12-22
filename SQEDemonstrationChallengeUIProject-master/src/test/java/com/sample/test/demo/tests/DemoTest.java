package com.sample.test.demo.tests;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;

public class DemoTest extends TestBase {

    @Test
    public void getTitle() {
        
    	String title = driver.getTitle();
    	Assert.assertEquals(title, "Pizza Order Form");
    	System.out.println(title);	
    }
    @Test
    public void verifyPizza1Dropdown() {	
     boolean pizzamenu = driver.findElement(By.id("pizza1Pizza")).isEnabled();  	
     assertTrue(pizzamenu);
    }
    
    @Test
    public void verifyToppings1Dropdown() {	
     boolean toppingmenu1 = driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']")).isEnabled();	
     assertTrue(toppingmenu1);
     
    }
    @Test
    public void verifyToppings2Dropdown() {	
     boolean toppingmenu2 = driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']")).isEnabled();	
     assertTrue(toppingmenu2);
     
    }
    @Test
    public void verifyEmptyNameAlert () {
    	
    	driver.findElement(By.id("name")).sendKeys("");
    	driver.findElement(By.id("ccpayment")).click();
    	driver.findElement(By.id("placeOrder")).click();
    	
    	WebElement alerttext = driver.findElement(By.xpath("//*[@id=\"dialog\"]/p"));
    	String text = alerttext.getText();

    	Assert.assertTrue(text.contains("Missing"));
    }
    @Test
    public void verifyEmptyPhoneAlert () {
    	
    	
    	driver.findElement(By.id("phone")).sendKeys("");
    	driver.findElement(By.id("ccpayment")).click();
    	driver.findElement(By.id("placeOrder")).click();
    	
    	WebElement alerttext = driver.findElement(By.xpath("//*[@id=\"dialog\"]/p"));
    	String text = alerttext.getText();

    	Assert.assertTrue(text.contains("phone number"));
    }
    @Test
    public void radio () {
    	
    	 
    	WebElement creditcardElement = driver.findElement(By.id("ccpayment"));
    	creditcardElement.click();
    	WebElement cashpaymentElement = driver.findElement(By.id("cashpayment"));
    	cashpaymentElement.click();
    	
    	if (creditcardElement.isSelected()&& cashpaymentElement.isSelected()) {
			System.out.println("Bug defected");
		}
 	 
    }
   }
