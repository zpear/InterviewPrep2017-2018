import java.util.HashMap;
import java.util.HashSet;

// Amazon question
// Given an array S of n integers, are there elements a, b, c in S 
// such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note: The solution set must not contain duplicate triplets.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    HashMap<Integer, Integer> positive = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> negative = new HashMap<Integer, Integer>();
    int numZeros = 0;

    // Place numbers into maps
    for (int x : nums) {
      if (x != 0) {
        HashMap<Integer, Integer> set;
        if (x >= 0) {
          set = positive;
        } else {
          set = negative;
        }
        Integer y = set.get(x);
        // System.out.print("key: " + x);

        if (y == null) {
          set.put(x, 1);
        } else {
          set.put(x, ++y);
        }
        // System.out.println(" updated value: " + set.get(x));
      } else {
        numZeros++;
      }
    }

    // Calculate sums
    List<List<Integer>> sums = new LinkedList<List<Integer>>();
    HashSet<Integer> lookedAt = new HashSet<Integer>();

    for (int y : nums) {
      List<Integer> sumZero = new LinkedList<Integer>();
      HashMap<Integer, Integer> set;

      if (lookedAt.contains(y)) {
        continue;
      } else {
        lookedAt.add(y);
      }

      if (y <= 0) {
        set = positive;
      } else {
        set = negative;
      }
      // check with opposite sign numbers
      // Iterate over unique values in opposite sign set
      if (y != 0) {
        for (int z : set.keySet()) {
          int numNeeded = -(y + z);

          if (numNeeded == z) {
            // Check if z appears multiple times
            int numOccur = set.get(z);
            System.out.println(numNeeded + " " + y + " " + z);
            System.out.println(numOccur);
            if (numOccur > 1) {
              sumZero.add(y);
              sumZero.add(z);
              sumZero.add(z);
            }
          } else {
            if (set.containsKey(numNeeded)) {
              sumZero.add(y);
              sumZero.add(z);
              sumZero.add(numNeeded);
            }
          }
        }

        // check with zero
        if (y < 0 && numZeros > 0) {
          int needed = -y;

          if (set != null && set.containsKey(-y)) {
            sumZero.add(y);
            sumZero.add(-y);
            sumZero.add(0);
          }
        }
      }
      if (sumZero.size() != 0) {
        sums.add(sumZero);
      }
    }

    return sums;
  }
}