package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by Konrad on 03/06/2017.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.group().ensureGroupExisting();
    app.goTo().contactPage();
    if (app.contact().list().size() == 0) {
      ContactData contact = new ContactData().withFirstName("Mike").withLastName("Janovsky")
              .withAddress("Los Angeles 11th Avenue").withHomePhone("home").withMobilePhone(null).withWorkPhone(null)
              .withEmail("emailmike@gmail.com").withGroup("test1");
      app.contact().createContact(contact);
    }
  }


  @Test(enabled = false)
  public void testContactDeletion() {
    app.goTo().contactHomePage();
    Set<ContactData> before = app.contact().list();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }



}


