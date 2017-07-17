package pl.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.mantis.appmanager.ApplicationManager;

/**
 * Created by Konrad on 31/05/2017.
 */
public class TestBase {


  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();

  }


}


