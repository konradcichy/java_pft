package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 03/06/2017.
 */
public class ContactHelper extends HelperBase {

  ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.cssSelector("input[value='Delete']"));
    wd.switchTo().alert().accept();

  }

  public void submitContactCreation() {
    wd.findElement(By.cssSelector("input[name='submit']")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {


    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void createContact(ContactData contact) {

    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToHomePage();

  }
  public void returnToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void clickEditContact() {
    click(By.cssSelector("img[title='Edit']"));
  }

  public void clickUpdateContact() {
    click(By.cssSelector("input[value='Update']"));
  }

  public boolean isContactExist() {
    return isElementPresent(By.name("selected[]"));
  }


  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("#maintable tr[name='entry']"));
    for (WebElement element : elements) {
      String firstname = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstname, lastname, null, null, null, null, null, null);
      contacts.add(contact);

    }


    return contacts;
  }

}










