package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Konrad on 03/06/2017.
 */
public class GroupEditTests extends TestBase {

  @Test
  public void testGroupEdit() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    if (! app.getGroupHelper().isGroupExist()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().clickEditGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("newtest1", "newtest2", "newtest3"));
    app.getGroupHelper().clickUpdateGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
