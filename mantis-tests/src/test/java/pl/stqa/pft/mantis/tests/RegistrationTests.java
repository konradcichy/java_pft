package pl.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Konrad on 19/07/2017.
 */
public class RegistrationTests extends TestBase{

  @Test
  public void testRegistration(){
    app.registration().start("user1", "user1@localhost.localdomain");

  }
}
