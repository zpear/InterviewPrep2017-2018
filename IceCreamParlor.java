import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Each time Sunny and Johnny take a trip to the Ice Cream Parlor, 
 * they pool together  dollars for ice cream. On any given day, 
 * the parlor offers a line of  flavors. Each flavor, , is numbered 
 * sequentially with a unique ID number from  to  and has a cost
 * associated with it. Given the value of  and the cost of each flavor 
 * for t trips to the Ice Cream Parlor, help Sunny and Johnny choose 
 * two distinct flavors such that they spend their entire pool of money 
 * during each visit. For each trip to the parlor, print the ID numbers
 * for the two types of ice cream that Sunny and Johnny purchase as two
 * space-separated integers on a new line. You must print the smaller 
 * ID first and the larger ID second.
 */
public class IceCreamParlor {

  static void solve(int[] arr, int money) {
    // Complete this function
    HashMap<Integer, ArrayList<Integer>> flavors = new HashMap<Integer, ArrayList<Integer>>();
    for (int i = 0; i < arr.length; i++) {
      int cost = arr[i];
      int flavor = i + 1;

      if (!flavors.containsKey(cost)) {
        ArrayList<Integer> cFlavors = new ArrayList<Integer>();
        cFlavors.add(flavor);
        flavors.put(cost, cFlavors);
      } else {
        ArrayList<Integer> cFlavors = flavors.get(cost);
        cFlavors.add(flavor);
        flavors.put(cost, cFlavors);
      }
    }
    for (int i = 0; i < arr.length; i++) {
      int flavor1 = i + 1;
      int cost1 = arr[i];

      if (cost1 < money) {
        int cost2 = money - cost1;
        ArrayList<Integer> flavors2 = flavors.get(cost2);
        if (flavors2 != null) {
          for (int flavor2 : flavors2) {
            // We have found 2 flavors that cost money
            if (flavor2 != flavor1) {
              if (flavor2 < flavor1) {
                System.out.println(flavor2 + " " + flavor1);
              } else {
                System.out.println(flavor1 + " " + flavor2);
              }
              return;
            }
          }
        }
      }
    }

  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int money = in.nextInt();
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int arr_i = 0; arr_i < n; arr_i++) {
        arr[arr_i] = in.nextInt();
      }
      solve(arr, money);
    }
    in.close();
  }
}