// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// 2 - abc
// 3 - def
// 4 - ghi
// 5 - jkl
// 6 - mno
// 7 - pqrs
// 8 - tuv
// 9 - wxyz

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class PhoneToLetter {

  private static char[][] keyboard = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
      { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

  private static void printStrings(String num, String prefix) {
    if (num.equals("")) {
      System.out.println(prefix);
      return;
    }
    int digit = (int) num.charAt(0) - '0';
    char[] letters = keyboard[digit];
    if (num.length() == 1) {
      num = "";
    } else {
      num = num.substring(1);
    }
    for (char x : letters) {
      printStrings(num, prefix + Character.toString(x));
    }
  }

  public static void main(String[] args) {
    String num = "84437";
    printStrings(num, "");
  }
}
