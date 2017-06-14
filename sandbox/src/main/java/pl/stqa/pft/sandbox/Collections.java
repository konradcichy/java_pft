package pl.stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Konrad on 14/06/2017.
 */
public class Collections {

  public static void main(String[] args) {

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
    String[] langs = {"Java", "C#", "Python", "PHP"};

    for (int i = 0; i < langs.length; i++) {
      System.out.println(" TAB fori" + " : I wanna learn " + langs[i]);
    }

    /*foreach */
    for (String l : langs) {
      System.out.println("TAB foreach : " + "I wanna learn " + l);

    }

    for (int i = 0; i < languages.size(); i++) {
      System.out.println("List languages : " + languages.get(i));

    }
    /*foreach list */
    for (String l : languages) {
      System.out.println("List foreach " + "I wanna learn " + l);

    }

  }

}



