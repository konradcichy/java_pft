package pl.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Konrad on 08/07/2017.
 */
public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  Random generator = new Random();


  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();


  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals(("csv"))) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }


  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
              .withFirstName(String.format("Firstname %s", i))
              .withLastName(String.format("Lastname %s", i))
              .withAddress(String.format("Address %s", i))
              .withHomePhone(String.format(" %s" + generator.nextInt(1000000000), i))
              .withMobilePhone(String.format(" %s" + generator.nextInt(1000000000), i))
              .withWorkPhone(String.format(" %s" + generator.nextInt(1000000000), i))
              .withEmail(String.format("1st_email %s@yahoo.com", i))
              .withEmail2(String.format("2nd_email %s@yahoo.com", i))
              .withEmail3(String.format("3rd_email %s@yahoo.com", i))
              .withGroup(String.format("Test1")));

    }
    return contacts;
  }



  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }
  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s,%s;%s;%s,%s;%s;%s,%s\n"
              , contact.getFirstname()
              , contact.getLastname()
              , contact.getAddress()
              , contact.getHomePhone()
              , contact.getMobilePhone()
              , contact.getWorkPhone()
              , contact.getEmail()
              , contact.getEmail2()
              , contact.getEmail3()
              , contact.getGroup()));
    }
    writer.close();
  }

}
