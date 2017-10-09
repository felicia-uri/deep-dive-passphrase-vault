package edu.cnm.deepdive.passphrase;

import edu.cnm.deepdive.passphrase.util.Constants;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class WordList {
  private final String[] words;

  private static class Singleton {
    private static final WordList INSTANCE = new WordList();
  }
  private WordList() {
    ResourceBundle bundle = ResourceBundle.getBundle(Constants.WORDS_BUNDLE);
    List<String> wordList = new LinkedList<>();
    for (Enumeration<String> e = bundle.getKeys(); e.hasMoreElements();) {
      wordList.add(bundle.getString(e.nextElement()));
    }
    words = wordList.toArray(new String[wordList.size()]);
  }

  public static String getRandom(Random rng) {
    return Singleton.INSTANCE.words[rng.nextInt(Singleton.INSTANCE.words.length)];
  }

}


