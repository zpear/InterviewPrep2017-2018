import java.util.Scanner;

/*
 * Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  
 * All the children sit in a line (their positions are fixed), and each  of them has a rating 
 * score according to his or her performance in the class.  Alice wants to give at least 1 candy 
 * to each child. If two children sit next to each other, then the one with the higher rating 
 * must get more candies. Alice wants to save money, so she needs to minimize the total number
 * of candies given to the children.
 */
public class MinimizeChocolates {

  static long candies(int n, int[] arr) {
    int[] numCandies = new int[n];
    for (int i = 0; i < n; i++)
      numCandies[i] = 1;
    for (int i = 0; i < n - 1; i++) {
      if (arr[i] > arr[i + 1] && numCandies[i] <= numCandies[i + 1]) {
        numCandies[i] = numCandies[i + 1] + 1;
      } else if (arr[i] < arr[i + 1] && numCandies[i] >= numCandies[i + 1]) {
        numCandies[i + 1] = numCandies[i] + 1;
      }
    }
    for (int i = n - 1; i > 0; i--) {
      if (arr[i] > arr[i - 1] && numCandies[i] <= numCandies[i - 1]) {
        numCandies[i] = numCandies[i - 1] + 1;
      } else if (arr[i] < arr[i - 1] && numCandies[i] >= numCandies[i - 1]) {
        numCandies[i - 1] = numCandies[i] + 1;
      }
    }
    long sum = 0;
    for (int x : numCandies) {
      sum += x;
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }
    long result = candies(n, arr);
    System.out.println(result);
    in.close();
  }
}
