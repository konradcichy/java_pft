package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by Konrad on 03/06/2017.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.group().ensureGroupExisting();
    app.goTo().contactHomePage();
    if (app.contact().all().size() == 0) {
      app.goTo().contactPage();
      ContactData contact = new ContactData().withFirstName("Mike").withLastName("Janovsky")
              .withAddress("Los Angeles 11th Avenue").withHomePhone("home").withWorkPhone(null)
              .withMobilePhone(null)
              .withEmail("emailmike@gmail.com").withGroup("test1");
      app.contact().createContact(contact);

    }
  }

  @Test(enabled = true)
  public void ContactModificationTest() {
    app.goTo().contactHomePage();
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Mike2")
            .withLastName("Janovsky2").withAddress("Los Angeles 11th Avenue2").withHomePhone("home2")
            .withWorkPhone(null).withMobilePhone(null)
            .withEmail("emailmike@gmail.com2").withGroup("test1");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(before.size(), after.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);


  }


}
