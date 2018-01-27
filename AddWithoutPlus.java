/*
 * Write a function that adds two numbers. You should
 * not use + or any arithmetic operators.
 */
public class AddWithoutPlus {
	
  public int add(int a, int b) {
    int xor = a ^ b; 
    int and = a & b;
    and = and<<1;
    int temp;
    while ((temp = xor & and) != 0) {
      and = temp;
      xor = xor ^ and;
      and = and<<1;
    }
    return and ^ xor;
  }

  public static void main(String[] args) {
    AddWithoutPlus test = new AddWithoutPlus();
    System.out.println(test.add(1, 2));
    System.out.println(test.add(1, 5));
    System.out.println(test.add(1, 9));
    System.out.println(test.add(1, 4));
    System.out.println(test.add(3, 3));
  }
}
