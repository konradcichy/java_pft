package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
              .withAddress("Los Angeles 11th Avenue").withHomePhone("111").withMobilePhone("3333")
              .withWorkPhone("4444").withEmail("emailmike@gmail.com").withGroup("Test1");
      app.contact().create(contact);

    }
  }

  @Test(enabled = true)
  public void ContactModificationTest() {
    app.goTo().contactHomePage();
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Mike2")
            .withLastName("Janovsky2").withAddress("Los Angeles 11th Avenue2").withHomePhone("home2")
            .withWorkPhone(null).withMobilePhone(null)
            .withEmail("emailmike@gmail.com2").withGroup("Test1");
    app.contact().modify(contact);
    assertThat(app.contact().Count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));


  }


}
