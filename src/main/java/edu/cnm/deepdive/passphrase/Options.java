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
        System.out.println("length");
      }

      if(cmdLine.hasOption("d")) {
        System.out.println("delimiter");
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
  //TODO - Make this non-static, invoked from a constructor.
  private static org.apache.commons.cli.Options buildOptions() {
    //returns a builder      //this list of options can be in any order I want
    ResourceBundle bundle = UsageStrings.getBundle();
    Option repeatOpt =          Option.builder("r").hasArg(false)
                                                        .required(false)
                                                        .longOpt(Constants.NO_REPEAT_OPTION)
                                                        .desc(bundle.getString(Constants.EXCLUDES_REPEAT))
                                                        .build();
    Option uppercaseOpt =       Option.builder("u").hasArg(false)
                                                        .required(false)
                                                        .longOpt(Constants.EXCLUDES_UPPERCASE)
                                                        .desc("excludes uppercase letters")
                                                        .build();
    Option lowercaseOpt =       Option.builder("w").hasArg(false)
                                                        .required(false)
                                                        .longOpt(Constants.EXCLUDES_LOWERCASE)
                                                        .desc("excludes lowercase")
                                                        .build();
    Option digitsOpt =          Option.builder("g").hasArg(false)
                                                        .required(false)
                                                        .longOpt(Constants.EXCLUDES_DIGITS)
                                                        .desc("excludes digits(numbers)")
                                                        .build();
    Option ambiguousOpt =       Option.builder("a").hasArg(false)
                                                        .required(false)
                                                        .longOpt("no-ambiguous-characters")
                                                        .desc("exclude 0, O, o, L, l")
                                                        .build();
    Option orderOpt =                   Option.builder().hasArg(false)
                                                        .required(false)
                                                        .longOpt("exclude-order")
                                                        .desc("excludes consecutive characters")
                                                        .build();
    Option symbolsOpt =         Option.builder("s").hasArg(true)
                                                        .required(false)
                                                        .optionalArg(true)
                                                        .numberOfArgs(1)
                                                        .longOpt("exclude-symbols")
                                                        .desc("excludes specified symbols")
                                                        .type(String.class)
                                                        .build();
    Option lengthOpt =          Option.builder("l").argName("value") // set its arg name
                                                        .optionalArg(false) // mark the builder object as an optional option
                                                        .hasArg(true)
                                                        .numberOfArgs(1)
                                                        .longOpt("length")
                                                        .desc("requested length of generated artifact (default = %d)")
                                                        .required(false)
                                                        .type(Number.class)
                                                        .build(); // returns an option
    Option delimiterOpt =       Option.builder("d").argName("value") // set its arg name
                                                        .optionalArg(false) // mark the builder object as an optional option
                                                        .hasArg(true)
                                                        .numberOfArgs(1)
                                                        .longOpt("delimiter")
                                                        .desc("space between words(*, -, _, |) (default = space)")
                                                        .required(false)
                                                        .type(Character.class)
                                                        .build();
    Option helpOpt =            Option.builder("?").longOpt("help")
                                                        .required(false)
                                                        .hasArg(false)
                                                        .desc("Displays options and description")
                                                        .build();
    Option modeOpt =            Option.builder("x").hasArg(false)
                                                        .required(false)
                                                        .longOpt("password-mode")
                                                        .desc("generates password (vs. passphrase default")
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
