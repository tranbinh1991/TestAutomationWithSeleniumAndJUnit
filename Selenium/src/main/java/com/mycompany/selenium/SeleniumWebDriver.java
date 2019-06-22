/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.selenium;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Binh
 */
public class SeleniumWebDriver {

    private List<String> nameList = new ArrayList<>();

    private WebDriver driver;

    public void initHubMainPage() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.navigate().to("https://hup.hu/");
        driver.manage().window().maximize();
    }

    public void clickFirst10Topic() {
        String SelectLinkNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);

        for (int i = 1; i <= 10; i++) {

            String a = driver.findElement(By.
                    xpath("//*[@id=\"block-block-16\"]/div/table/tbody/tr[" + i + "]/td[" + 2 + "]")).getText();
            driver.findElement(By.linkText(a)).sendKeys(SelectLinkNewTab);

        }
    }

    public void getFirst10AuthorsForEveryTopic() {

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        for (int i = tabs.size() - 1; i > 0; i--) {
            driver.switchTo().window(tabs.get(i));
            try {
                int count = 1;
                for (int j = 1; count <= 10; j++) {

                    WebElement element = driver.findElement(By.
                            xpath("//*[@id=\"comments\"]/div[" + j + "]"));

                    if (element.getAttribute("class").equals("comment")) {

                        String textOfElement = driver.findElement(By.
                                xpath("//*[@id=\"comments\"]/div[" + j + "]/div[1]")).getText();
                        String authorName = textOfElement.substring(textOfElement.indexOf(" ")+1, textOfElement.indexOf(" ", 3));

                        if (!nameList.contains(authorName)) {
                            nameList.add(authorName);
                            count++;
                        }
                    }

                }

            } catch (NoSuchElementException e) {

            }
        }
    }

    public void printAllAuthors() {
        Collections.sort(nameList, String.CASE_INSENSITIVE_ORDER);
        for (String string : nameList) {
            System.out.println(string);
        }
    }



    public List<String> getNameList() {
        return nameList;
    }

    public WebDriver getDriver() {
        return driver;
    }
    
    
    
}
