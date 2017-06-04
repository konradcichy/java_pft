package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void GroupDeletionTests() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isGroupExist()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().deleteSelectedGroups();
      app.getGroupHelper().returnToGroupPage();

  }
}
