package pl.stqa.pft.mantis.model;

/**
 * Created by Konrad on 20/07/2017.
 */
public class MailMessage {
  public String to;
  public String text;

  public MailMessage(String to, String text){
    this.to = to;
    this.text = text;
  }
}
