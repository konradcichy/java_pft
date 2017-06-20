package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

/**
 * Created by Konrad on 31/05/2017.
 */
public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.group().ensureGroupExisting();
    app.goTo().contactHomePage();
    Set<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstName("Mike").withLastName("Janovsky")
            .withAddress("Los Angeles 11th Avenue").withHomePhone("home").withMobilePhone(null).withWorkPhone(null)
            .withEmail("emailmike@gmail.com").withGroup("test1");
    app.contact().createContact(contact);
    Set<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}


