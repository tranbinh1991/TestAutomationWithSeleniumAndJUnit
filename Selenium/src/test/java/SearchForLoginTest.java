
import com.mycompany.selenium.SeleniumWebDriver;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Binh
 */
public class SearchForLoginTest {

    

    @Test
    public void HomePageShouldHaveLogin() {
        SeleniumWebDriver seleniumWebDriver = new SeleniumWebDriver();
        seleniumWebDriver.initHubMainPage();

        try {
            seleniumWebDriver.getDriver().findElement(By.xpath("//*[contains(@id, 'login')]"));
            seleniumWebDriver.getDriver().findElement(By.xpath("//input[contains(@type, 'text')]"));
            seleniumWebDriver.getDriver().findElement(By.xpath("//input[contains(@type, 'password')]"));

            Assertions.assertTrue(true);

        }catch(NoSuchElementException elementException){
             Assertions.assertTrue(false, "Login not found");
        }
    }
}
