
import com.mycompany.selenium.SeleniumWebDriver;
import static org.junit.Assert.assertFalse;


import org.junit.Test;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Binh
 */
public class ListDoesNotContainsNameTreyTest {

   

    @Test
    public void ListShouldNotContainNameTrey() {
       SeleniumWebDriver seleniumWebDriver = new SeleniumWebDriver();
        seleniumWebDriver.initHubMainPage();
        seleniumWebDriver.clickFirst10Topic();
        seleniumWebDriver.getFirst10AuthorsForEveryTopic();

        assertFalse("The list contains name: trey", seleniumWebDriver.getNameList().contains("trey"));
        
    }
}
