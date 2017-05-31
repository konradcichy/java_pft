package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.stqa.pft.addressbook.appmanager.ApplicationManager;

/**
 * Created by Konrad on 31/05/2017.
 */
public class TestBase {


  protected  ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
