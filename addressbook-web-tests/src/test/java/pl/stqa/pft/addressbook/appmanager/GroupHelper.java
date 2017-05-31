package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Konrad on 31/05/2017.
 */
public class GroupHelper extends HelperBase {


  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    wd.findElement(By.linkText("groups"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }


  public void fillGroupForm(GroupData groupData) {

    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }


  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }
}
