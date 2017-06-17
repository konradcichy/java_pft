package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Konrad on 03/06/2017.
 */
public class ContactEditTests extends TestBase {

  @Test
  public void testContactEdit() {
    app.getGroupHelper().ensureGroupExisting();
    app.getNavigationHelper().gotoContactsHomePage();
    if (!app.getContactHelper().isContactExist()) {
      app.getNavigationHelper().goToContactsPage();
      app.getContactHelper().createContact(new ContactData("Mike", "Janovsky", "Los Angeles 11th Avenue", "home", null, null,
              "emailmike@gmail.com", "test1"));
    }
    app.getNavigationHelper().gotoContactsHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().clickEditContact();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Mike2", "Janovsky2", "Los Angeles 11th Avenue2", "home2", null, null,
            "emailmike@gmail.com2", "test1");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().clickUpdateContact();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());


    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }
}
