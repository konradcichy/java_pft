package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Konrad on 03/06/2017.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.group().ensureGroupExisting();
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      ContactData contact = new ContactData().withFirstName("Mike").withLastName("Janovsky")
              .withAddress("Los Angeles 11th Avenue").withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
              .withEmail("emailmike@gmail.com").withGroup("test1");
      app.contact().create(contact);
    }
  }


  @Test(enabled = true)
  public void testContactDeletion() {
    app.goTo().contactHomePage();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().Count(),equalTo(before.size()-1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }


}


