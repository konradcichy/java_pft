package pl.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Konrad on 31/05/2017.
 */
public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    goToContactsPage();
    fillContactForm(new ContactData("Michael", "Jordan", "MJK", "MJ", "MR", "Own company", "Chicago"));
    submitContactCreation();
  }

  private void goToContactsPage() {
    app.getGroupHelper().wd.findElement(By.linkText("add new")).click();
  }

  private void submitContactCreation() {
    app.getGroupHelper().wd.findElement(By.cssSelector("input[name='submit']")).click();
  }

  private void fillContactForm(ContactData contactData) {
    app.getGroupHelper().wd.findElement(By.name("firstname")).click();
    app.getGroupHelper().wd.findElement(By.name("firstname")).clear();
    app.getGroupHelper().wd.findElement(By.name("firstname")).sendKeys(contactData.getName());
    app.getGroupHelper().wd.findElement(By.name("middlename")).click();
    app.getGroupHelper().wd.findElement(By.name("middlename")).clear();
    app.getGroupHelper().wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
    app.getGroupHelper().wd.findElement(By.name("lastname")).click();
    app.getGroupHelper().wd.findElement(By.name("lastname")).clear();
    app.getGroupHelper().wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    app.getGroupHelper().wd.findElement(By.name("nickname")).click();
    app.getGroupHelper().wd.findElement(By.name("nickname")).clear();
    app.getGroupHelper().wd.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
    app.getGroupHelper().wd.findElement(By.name("title")).click();
    app.getGroupHelper().wd.findElement(By.name("title")).clear();
    app.getGroupHelper().wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
    app.getGroupHelper().wd.findElement(By.name("company")).click();
    app.getGroupHelper().wd.findElement(By.name("company")).clear();
    app.getGroupHelper().wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    app.getGroupHelper().wd.findElement(By.name("address")).click();
    app.getGroupHelper().wd.findElement(By.name("address")).clear();
    app.getGroupHelper().wd.findElement(By.name("address")).sendKeys(contactData.getAddress());


  }


}
