package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Konrad on 31/05/2017.
 */
public class NavigationHelper extends HelperBase {


  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }
}
