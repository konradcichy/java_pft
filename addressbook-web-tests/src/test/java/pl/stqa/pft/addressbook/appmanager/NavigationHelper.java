package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Konrad on 31/05/2017.
 */
public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if ((isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups"))
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));

  }

  public void contactPage() {
    if(isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")){
      return;
    }
    wd.findElement(By.linkText("add new")).click();
  }

  public void contactHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    wd.findElement(By.linkText("home")).click();
  }

}
