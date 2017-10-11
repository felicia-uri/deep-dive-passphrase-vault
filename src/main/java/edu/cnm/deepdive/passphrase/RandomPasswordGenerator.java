package edu.cnm.deepdive.passphrase;

import edu.cnm.deepdive.passphrase.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomPasswordGenerator extends RandomArtifactGenerator {

  private boolean orderExcluded = Constants.DEFAULT_ORDER_CONFIGURATION;
  private boolean excludesUppercase = Constants.DEFAULT_EXCLUDES_UPPERCASE;
  private boolean excludesLowercase = Constants.DEFAULT_EXCLUDES_LOWERCASE;
  private boolean excludesDigits = Constants.DEFAULT_EXCLUDES_DIGITS;
  private boolean excludesSymbols = Constants.DEFAULT_EXCLUDES_SYMBOLS;
  private boolean excludesAmbiguous = Constants.DEFAULT_EXCLUDES_AMBIGUOUS;

  //TODO - add StringBuilder.setCharAt
  //TODO - make setters for all private constants
  //TODO - set all default values for the fields
  //TODO - add setters to constructor

  public RandomPasswordGenerator() {
    setLength(Constants.DEFAULT_PASSWORD_LENGTH);
  }

  public String generate() {
    List<String> characters = new ArrayList<>();
    while (characters.size() < getLength()) {
      String character = WordList.getRandom(getRng());
      if (isRepeatedAllowed() || !characters.contains(character)) {
        characters.add(character);
      }
    }
    return characters.stream().collect(Collectors.joining(Character.toString(delimiter)));
  }

  public boolean isOrderExcluded() {
    return orderExcluded;
  }

  public void setOrderExcluded(boolean orderExcluded) {
    this.orderExcluded = orderExcluded;
  }

  public boolean isExcludesUppercase() {
    return excludesUppercase;
  }

  public void setExcludesUppercase(boolean excludesUppercase) {
    this.excludesUppercase = excludesUppercase;
  }

  public boolean isExcludesLowercase() {
    return excludesLowercase;
  }

  public void setExcludesLowercase(boolean excludesLowercase) {
    this.excludesLowercase = excludesLowercase;
  }

  public boolean isExcludesDigits() {
    return excludesDigits;
  }

  public void setExcludesDigits(boolean excludesDigits) {
    this.excludesDigits = excludesDigits;
  }

  public boolean isExcludesSymbols() {
    return excludesSymbols;
  }

  public void setExcludesSymbols(boolean excludesSymbols) {
    this.excludesSymbols = excludesSymbols;
  }

  public boolean isExcludesAmbiguous() {
    return excludesAmbiguous;
  }

  public void setExcludesAmbiguous(boolean excludesAmbiguous) {
    this.excludesAmbiguous = excludesAmbiguous;
  }

}

