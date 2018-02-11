import java.util.HashSet;

public class LongestUncommonSubstring {
  public int findLUSlength(String[] strs) {
    String subsequence = strs[0];
    int subIndex = 0;
    HashSet<String> badStrings = new HashSet<String>();

    for (int i = 1; i < strs.length; i++) {
      System.out.println(subsequence);
      // current sequence is present in another String
      if (!subsequence.equals("") && strs[i].contains(subsequence)) {
        // current sequence is a subsequence
        if (subsequence.length() < strs[i].length()) {
          badStrings.add(subsequence);
          if (!badStrings.contains(strs[i])) {
            subsequence = strs[i];
            subIndex = i;
            i = 0;
          } else {
            subsequence = "";
          }
          // current sequence is equivalent to another String
        } else {
          if (subIndex != i) {
            badStrings.add(subsequence);
            subsequence = "";
            i = 0;
          }
        }
        // if current sequence is not in this String but is smaller
      } else if (strs[i].length() > subsequence.length() && !badStrings.contains(strs[i])) {
        subsequence = strs[i];
        subIndex = i;
        i = 0;
      }
    }
    System.out.println("final " + subsequence);
    if (subsequence.length() == 0) {
      return -1;
    }
    return subsequence.length();
  }
}