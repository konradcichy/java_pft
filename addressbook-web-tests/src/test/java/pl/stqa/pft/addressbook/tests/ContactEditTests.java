package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Konrad on 03/06/2017.
 */
public class ContactEditTests extends TestBase {

  @Test
  public void testContactEdit() {
    app.getNavigationHelper().gotoContactsHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().clickEditContact();
    app.getContactHelper().fillContactForm(new ContactData("Christiano", "Ronaldo", "CR7", "CR7", "CR7", "CR Company", "Barcelona", null),false);
    app.getContactHelper().clickUpdateContact();

  }
}
