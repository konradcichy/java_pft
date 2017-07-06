package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Konrad on 31/05/2017.
 */
public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.group().ensureGroupExisting();
    app.goTo().contactHomePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/Small-mario.png");
    ContactData contact = new ContactData().withFirstName("Mike").withLastName("Janovsky")
            .withAddress("Los Angeles 11th Avenue").withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
            .withEmail("emailmike@gmail.com").withPhoto(photo).withGroup("test1");
    app.contact().createContact(contact);
    assertThat(app.contact().Count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testCurrentDir(){
    File currectDir = new File(".");
    System.out.println(currectDir.getAbsolutePath());
    File photo = new File("src/test/resources/Small-mario.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }
}

