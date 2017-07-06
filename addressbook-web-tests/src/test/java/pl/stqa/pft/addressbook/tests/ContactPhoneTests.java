package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Konrad on 05/07/2017.
 */
public class ContactPhoneTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.group().ensureGroupExisting();
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      ContactData contact = new ContactData().withFirstName("Mike").withLastName("Janovsky")
              .withAddress("Los Angeles 11th Avenue").withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
              .withEmail("emailmike@gmail.com").withEmail2("hackme@gmail.com").withEmail3("hackmetoo@gmail.com")
              .withGroup("test1");
      app.contact().createContact(contact);
    }
  }


  @Test
  public void testContactPhones() {
    app.goTo().contactHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(),equalTo(mergeEmails(contactInfoFromEditForm)));


  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s -> !s.equals("")))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));

  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s -> !s.equals("")))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
