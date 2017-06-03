package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Konrad on 31/05/2017.
 */

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String pass, String user) {
    type(By.name("user"), user);
    type(By.name("pass"), pass);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }


}
