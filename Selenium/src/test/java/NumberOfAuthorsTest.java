
import com.mycompany.selenium.SeleniumWebDriver;
import static org.junit.Assert.assertTrue;


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
public class NumberOfAuthorsTest {

    

    @Test
    public void NumberOfAuthorsShouldBeBetween10And100() {
       SeleniumWebDriver seleniumWebDriver = new SeleniumWebDriver();
        seleniumWebDriver.initHubMainPage();
        seleniumWebDriver.clickFirst10Topic();
        seleniumWebDriver.getFirst10AuthorsForEveryTopic();
        int numberOfAuthors = seleniumWebDriver.getNameList().size();
        int upperLimit = 100;
        int lowerLimit = 10;
        assertTrue("Error, number of authors is too high", upperLimit >= numberOfAuthors);
        assertTrue("Error, number of authors low", lowerLimit <= numberOfAuthors);
    }
}
