package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Konrad on 25/07/2017.
 */
public class DetailedContactViewTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName(app.properties.getProperty("group.defaultName")));
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().contactHomePage();
      app.contact().create(new ContactData().withFirstName(app.properties.getProperty("contact.defaultFirstname"))
              .withLastName(app.properties.getProperty("contact.defaultLastname"))
              .withAddress(app.properties.getProperty("contact.defaultAddress"))
              .withEmail(app.properties.getProperty("contact.defaultEmail"))
              .withHomePhone(app.properties.getProperty("contact.defaultHomePhone"))
              .withMobilePhone(app.properties.getProperty("contact.defaultMobilePhone"))
              .withWorkPhone(app.properties.getProperty("contact.defaultWorkPhone"))
              .withEmail(app.properties.getProperty("contact.defaultEmail"))
              .withEmail2(app.properties.getProperty("contact.defaultEmail2"))
              .withEmail3(app.properties.getProperty("contact.defaultEmail3"))
              .withGroup(app.properties.getProperty("group.defaultName")),true);

    }
  }

  @Test
  public void testContactView() {
    app.goTo().contactHomePage();
    Contacts contacts = app.db().contacts();
    ContactData contact = contacts.iterator().next();
    ContactData contactInfoFromViewForm = app.contact().infoFromViewForm(contact);

    assertThat(contact.getFirstname(), equalTo(contactInfoFromViewForm.getFirstname()));
    assertThat(contact.getLastname(), equalTo(contactInfoFromViewForm.getLastname()));
    assertThat(contact.getAddress(), equalTo(contactInfoFromViewForm.getAddress()));
    assertThat(contact.getHomePhone(), equalTo(contactInfoFromViewForm.getHomePhone()));
    assertThat(contact.getMobilePhone(), equalTo(contactInfoFromViewForm.getMobilePhone()));
    assertThat(contact.getWorkPhone(), equalTo(contactInfoFromViewForm.getWorkPhone()));
    assertThat(contact.getEmail(), equalTo(contactInfoFromViewForm.getEmail()));
    assertThat(contact.getEmail2(), equalTo(contactInfoFromViewForm.getEmail2()));
    assertThat(contact.getEmail3(), equalTo(contactInfoFromViewForm.getEmail3()));
  }


}
