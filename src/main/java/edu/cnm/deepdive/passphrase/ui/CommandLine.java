package edu.cnm.deepdive.passphrase.ui;

import edu.cnm.deepdive.passphrase.util.Constants;
import edu.cnm.deepdive.passphrase.Options;
import java.util.HashMap;
import java.util.Map;

//TODO - Write main method as a test rig for Options class.

public class CommandLine {

  public static void main(String[] args) {

    try {
      Options options = new Options(args);
      Map<String, Object> map = options.map;

      for (Map.Entry<String, Object> entry : map.entrySet()) {
        System.out.printf("%s = %s%n", entry.getKey(), entry.getValue());
      }
      boolean passwordMode = map.containsKey(Constants.PASSWORD_MODE_OPTION);
      if (passwordMode) {
        for (String key : map.keySet()) {
          switch (key) {
            // TODO - invoke setters on password generator
            case Constants.EXCLUDES_REPEAT:
              System.out.println("User specified no repeat characters.");
              break;
            case Constants.EXCLUDES_UPPERCASE:
              System.out.println("User specified no uppercase.");
              break;
            case Constants.EXCLUDES_LOWERCASE:
              System.out.println("User specified no lowercase.");
              break;
            case Constants.EXCLUDES_DIGITS:
              System.out.println("User specified no digits.");
              break;
            case Constants.EXCLUDES_AMBIGUOUS:
              System.out.println("User specified no ambiguous characters.");
              break;
            case Constants.EXCLUDES_ORDER:
              System.out.println("User specified no order characters.");
              break;
            case Constants.EXCLUDES_SYMBOLS:
              System.out.println("User specified no symbols.");
              break;
            case Constants.SPECIFY_LENGTH:
              System.out.println("User specified length.");
              break;
            case Constants.SPECIFY_DELIMITER:
              System.out.println("User specified delimiter.");
              break;
            case Constants.HELP_OPTION:
              System.out.println("User specified help.");
              break;
          }

        }
      } else {
        //passphrase mode
        for (String key : map.keySet()) {
          switch (key) {
            // TODO - invoke setters on password generator
            case Constants.NO_REPEAT_OPTION:
              System.out.println("User specified no repeat words.");
              break;
            case Constants.EXCLUDES_ORDER:
              System.out.println("User specified no order words.");
              break;
            case Constants.SPECIFY_LENGTH:
              System.out.println("User specified length.");
              break;
            case Constants.SPECIFY_DELIMITER:
              System.out.println("User specified delimiter.");
              break;
          }
        }
      }
    } catch (Exception ex) {
      System.exit(-1);
    }


  }
}
