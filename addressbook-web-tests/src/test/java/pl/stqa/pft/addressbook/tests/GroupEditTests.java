package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Konrad on 03/06/2017.
 */
public class GroupEditTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.group().list().size() ==0) {
      app.group().create(new GroupData("test1", null, null));
    }
  }

  @Test(enabled = true)
  public void testGroupEdit() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "test1", "newtest2", "newtest3");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());


    before.remove(before.size() - 1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
