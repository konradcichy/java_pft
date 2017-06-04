package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Konrad on 31/05/2017.
 */
public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToContactsPage();
    app.getContactHelper().fillContactForm(new ContactData("Michael", "Jordan", "MJK", "MJ", "MR", "Own company",
            "null", "test1"), true);
    app.getContactHelper().submitContactCreation();
  }

}


