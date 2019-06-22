/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Binh
 */
public class TestRunner {
      public static void main(String[] args) {
      Result result = JUnitCore.runClasses(SearchForLoginTest.class);
      Result result2 = JUnitCore.runClasses(NumberOfAuthorsTest.class);
      Result result3 = JUnitCore.runClasses(ListDoesNotContainsNameTreyTest.class);	
      
      System.out.println(result.wasSuccessful());
      System.out.println(result2.wasSuccessful());
      System.out.println(result3.wasSuccessful());
		

   }
}
