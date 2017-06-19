package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Konrad on 03/06/2017.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.group().ensureGroupExisting();
    app.goTo().contactHomePage();
    if (app.contact().list().size() == 0) {
      app.goTo().contactPage();
      ContactData contact = new ContactData("Mike", "Janovsky", "Los Angeles 11th Avenue", "home", null, null,
              "emailmike@gmail.com", "test1");
      app.contact().createContact(contact);

    }
  }

  @Test(enabled = true)
  public void ContactModificationTest() {
    app.goTo().contactHomePage();
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(), "Mike2", "Janovsky2", "Los Angeles 11th Avenue2", "home2", null, null,
            "emailmike@gmail.com2", "test1");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(before.size(), after.size());


    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }


}
