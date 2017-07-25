package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Konrad on 03/06/2017.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create((new GroupData().withName("Test1")));
    }

    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      ContactData contact = new ContactData()
              .withFirstName("Mike")
              .withLastName("Janovsky")
              .withAddress("Los Angeles 11th Avenue")
              .withHomePhone("111").withMobilePhone("3333")
              .withWorkPhone("4444")
              .withEmail("emailmike@gmail.com")
              .withGroup("Test1");
      app.contact().create(contact,true);

    }
  }

  @Test(enabled = true)
  public void ContactModificationTest() {
    app.goTo().contactHomePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstName("Mike2")
            .withLastName("Janovsky2")
            .withAddress("Los Angeles 11th Avenue2")
            .withHomePhone("home2")
            .withWorkPhone("1111-2222-3333")
            .withMobilePhone("1111-2222-3333")
            .withMobilePhone("11132423423-22")
            .withEmail("emailmike@gmail.com2")
            .withEmail2("newemail@wp.com")
            .withEmail3("newnwnenwnewEMail@gmail.com");
    app.contact().modify(contact);
    assertThat(app.contact().Count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();


  }




}
