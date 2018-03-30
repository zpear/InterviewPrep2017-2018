
public class RvrsStrRecursive {
  public static String reverseString(String str) {
    if (str.length() > 1) {
    char myChar = str.charAt(0);
    return reverseString(str.substring(1)) + new String("" + myChar);
    } else {
      return str;
    }
  }
  
  public static void main(String[] args) {
    String test1 = "test";
    System.out.println(reverseString(test1));
    String test2 = "REVERSEME";
    System.out.println(reverseString(test2));
  }
}
