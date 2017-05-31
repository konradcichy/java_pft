package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Konrad on 31/05/2017.
 */
public class ApplicationManager {

  public FirefoxDriver wd;

  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;


  public void init() {
    FirefoxBinary binary = new FirefoxBinary(new File("/Applications/FirefoxESR.app/Contents/MacOS/firefox-bin"));
    FirefoxProfile profile = new FirefoxProfile();
    wd = new FirefoxDriver(binary, profile);
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("secret", "admin");
  }


  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void goToGroupPage() {
    navigationHelper.goToGroupPage();
  }
}
