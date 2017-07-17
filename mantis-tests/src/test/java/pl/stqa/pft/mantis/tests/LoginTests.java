package pl.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Konrad on 17/07/2017.
 */
public class LoginTests extends TestBase {

  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSesssion();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));

  }


}
