import java.util.Scanner;

public class SwapToEven {
  private static String swapPositions(String s, int i, int j) {
    char[] chars = s.toCharArray();
    char one = chars[i];
    chars[i] = chars[j];
    chars[j] = one;
    return new String(chars);
  }

  public static String swapToEven(String num) {
    int oddNum = (int) num.charAt(num.length() - 1) - '0';
    int cIndex = -1;
    for (int i = 0; i < num.length() - 2; i++) {
      int currentNum = (int) num.charAt(i) - '0';
      if (currentNum % 2 == 0) {
        cIndex = i;
        int diff = oddNum - currentNum;
        if (diff > 0) {
          return swapPositions(num, i, num.length() - 1);
        }
      }
    }
    // this means there are only negative diffs or no even nums
    if (cIndex >= 0) {
      // swap with cIndex
      return swapPositions(num, cIndex, num.length() - 1);
    } else {
      return num;
    }

  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    for (int i = 0; i < n; i++) {
      String s = scan.nextLine();
      System.out.println(swapToEven(s));
    }
  }
}