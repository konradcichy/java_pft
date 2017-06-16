package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Konrad on 31/05/2017.
 */
public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoContactsHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contactData = new ContactData("Michael", "Jordan", "MJK", "MJ", "MR", "Own company",
            null, "dwq");
    app.getContactHelper().createContact(contactData);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);
  }

}


