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
    app.wd.findElement(By.linkText("add new")).click();
  }

  private void submitContactCreation() {
    app.wd.findElement(By.cssSelector("input[name='submit']")).click();
  }

  private void fillContactForm(ContactData contactData) {
    app.wd.findElement(By.name("firstname")).click();
    app.wd.findElement(By.name("firstname")).clear();
    app.wd.findElement(By.name("firstname")).sendKeys(contactData.getName());
    app.wd.findElement(By.name("middlename")).click();
    app.wd.findElement(By.name("middlename")).clear();
    app.wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
    app.wd.findElement(By.name("lastname")).click();
    app.wd.findElement(By.name("lastname")).clear();
    app.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    app.wd.findElement(By.name("nickname")).click();
    app.wd.findElement(By.name("nickname")).clear();
    app.wd.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
    app.wd.findElement(By.name("title")).click();
    app.wd.findElement(By.name("title")).clear();
    app.wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
    app.wd.findElement(By.name("company")).click();
    app.wd.findElement(By.name("company")).clear();
    app.wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    app.wd.findElement(By.name("address")).click();
    app.wd.findElement(By.name("address")).clear();
    app.wd.findElement(By.name("address")).sendKeys(contactData.getAddress());


  }


}
