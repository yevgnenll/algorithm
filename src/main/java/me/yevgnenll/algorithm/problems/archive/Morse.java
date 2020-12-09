package me.yevgnenll.algorithm.problems.archive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class Morse {

  private String convertToMore(char c) {
    String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....",
        "..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
        "...","-","..-","...-",".--","-..-","-.--","--.."};
    int index = c - 97;
    System.out.println(String.valueOf(c) + ", index: " + index + ", morse: " + morse[index]);
    return morse[index];
  }

  private String convertCharArrayToMorse(char[] c) {
    String result = "";
    for (int i = 0; i < c.length ; i ++) {
      result += convertToMore(c[i]);
    }
    return result;
  }

  public int uniqueMorseRepresentations(String[] words) {
    Set<String> set = new HashSet<>();
    for (String word : words) {
      String morse = convertCharArrayToMorse(word.toCharArray());
      set.add(morse);
    }
    return set.size();
  }

  @Test
  public void ginToMorse() {
    String[] input = {"gin", "zen", "gig", "msg"};
    assertEquals(2, uniqueMorseRepresentations(input));
  }

}
