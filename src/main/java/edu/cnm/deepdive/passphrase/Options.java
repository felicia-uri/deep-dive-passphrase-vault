package edu.cnm.deepdive.passphrase;


import edu.cnm.deepdive.passphrase.util.Constants;
import edu.cnm.deepdive.passphrase.util.UsageStrings;
import java.util.ResourceBundle;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;

public class Options {

  public static void main(String[] args) {
    try {
      org.apache.commons.cli.Options options = buildOptions();
      CommandLineParser parser = new DefaultParser();
      org.apache.commons.cli.CommandLine cmdLine = parser.parse(options, args);

      if(cmdLine.hasOption("l")) {
        System.out.println(Constants.LENGTH_OPTION);
      }

      if(cmdLine.hasOption("d")) {
        System.out.println(Constants.DELIMITER_OPTION);
      }

      if(cmdLine.hasOption("?")) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java " + Options.class.getName(), options);
      }
      if(cmdLine.hasOption("")) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java " + Options.class.getName(), options);
      }
    } catch (UnrecognizedOptionException e) {
      System.out.println("Retry: \nPlease type \"-?\" or \"--help\" for command list!");
    } catch (MissingOptionException e) {
      System.out.println("Please type \"-?\" or \"--help\" for command list!");
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  // defines my options
  private static org.apache.commons.cli.Options buildOptions() {
    //returns a builder      //this list of options can be in any order I want
    ResourceBundle bundle = UsageStrings.getBundle();
    Option repeatOpt =         Option.builder("r").hasArg(false)
                                                       .required(false)
                                                       .longOpt(Constants.NO_REPEAT_OPTION)
                                                       .desc(bundle.getString(Constants.EXCLUDES_REPEAT))
                                                       .build();
    Option uppercaseOpt =      Option.builder("u").hasArg(false)
                                                       .required(false)
                                                       .longOpt(Constants.NO_UPPER_OPTION)
                                                       .desc(bundle.getString(Constants.EXCLUDES_UPPERCASE))
                                                       .build();
    Option lowercaseOpt =      Option.builder("w").hasArg(false)
                                                       .required(false)
                                                       .longOpt(Constants.NO_LOWER_OPTION)
                                                       .desc(bundle.getString(Constants.EXCLUDES_LOWERCASE))
                                                       .build();
    Option digitsOpt =         Option.builder("g").hasArg(false)
                                                       .required(false)
                                                       .longOpt(Constants.NO_DIGITS_OPTION)
                                                       .desc(bundle.getString(Constants.EXCLUDES_DIGITS))
                                                       .build();
    Option ambiguousOpt =      Option.builder("a").hasArg(false)
                                                       .required(false)
                                                       .longOpt(
                                                           Constants.NO_AMBIGUOUS_CHARACTERS_OPTION)
                                                       .desc(bundle.getString(Constants.EXCLUDES_AMBIGUOUS))
                                                       .build();
    Option orderOpt =          Option.builder()        .hasArg(false)
                                                       .required(false)
                                                       .longOpt(Constants.EXCLUDES_ORDER_OPTION)
                                                       .desc(bundle.getString(Constants.EXCLUDES_ORDER))
                                                       .build();
    Option symbolsOpt =        Option.builder("s").hasArg(true)
                                                       .required(false)
                                                       .optionalArg(true)
                                                       .numberOfArgs(1)
                                                       .longOpt(Constants.EXCLUDES_SYMBOLS_OPTION)
                                                       .desc(bundle.getString(Constants.EXCLUDES_SYMBOLS))
                                                       .type(String.class)
                                                       .build();
    Option lengthOpt =         Option.builder("l").argName("value") // set its arg name
                                                       .optionalArg(false) // mark the builder object as an optional option
                                                       .hasArg(true)
                                                       .numberOfArgs(1)
                                                       .longOpt(Constants.LENGTH_OPTION)
                                                       .desc(bundle.getString(Constants.SPECIFY_LENGTH))
                                                       .required()
                                                       .type(Number.class)
                                                       .build(); // returns an option
    Option delimiterOpt =      Option.builder("d").argName("value") // set its arg name
                                                       .optionalArg(false) // mark the builder object as an optional option
                                                       .hasArg(true)
                                                       .numberOfArgs(1)
                                                       .longOpt(Constants.DELIMITER_OPTION)
                                                       .desc(bundle.getString(Constants.SPECIFY_DELIMITER))
                                                       .required(false)
                                                       .type(Character.class)
                                                       .build();
    Option helpOpt =           Option.builder("?").longOpt(Constants.HELP_OPTION)
                                                       .required(false)
                                                       .hasArg(false)
                                                       .desc(Constants.HELP_MSG)
                                                       .build();
    Option modeOpt =           Option.builder("x").hasArg(false)
                                                       .required(false)
                                                       .longOpt(Constants.PASSWORD_MODE_OPTION)
                                                       .desc(bundle.getString(Constants.MODE_SWITCH))
                                                       .build();

    org.apache.commons.cli.Options options = new org.apache.commons.cli.Options();
    options.addOption(repeatOpt);
    options.addOption(uppercaseOpt);
    options.addOption(lowercaseOpt);
    options.addOption(digitsOpt);
    options.addOption(symbolsOpt);
    options.addOption(lengthOpt);
    options.addOption(delimiterOpt);
    options.addOption(ambiguousOpt);
    options.addOption(orderOpt);
    options.addOption(modeOpt);
    options.addOption(helpOpt);
    return options;
  }

}
