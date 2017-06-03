package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Konrad on 03/06/2017.
 */
public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoContactsHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
  }

}
