package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Konrad on 03/06/2017.
 */
public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().goToContactsPage();
    if(! app.getContactHelper().isContactExist()){
      app.getContactHelper().createContact(new ContactData("Michael", "Jordan", "MJK", "MJ", "MR", "Own company",
              "null", "test1"), true);
    }
    app.getNavigationHelper().gotoContactsHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
  }

}
