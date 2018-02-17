
/*
 * Your are given an array of positive integers nums.
 * Count and print the number of (contiguous) subarrays
 * where the product of all the elements in the subarray 
 * is less than k.
 */
import java.util.LinkedList;

public class SubArrProduct {

  public int goodTimeComplexity(int[] nums, int k) {
    int numSums = 0;
    int left = 0;
    int right = 0;
    int currentSum = 1;

    while (right < nums.length) {
      // Resize window if needed
      currentSum *= nums[right];
      while (currentSum >= k && left <= right) {
        currentSum /= nums[left];
        left++;
      }
      if (currentSum < k) {
        numSums += right - left + 1;
      }
      right++;
    }
    return numSums;
  }

  public int badTimeComplexity(int[] nums, int k) {
    LinkedList<Integer>[] sums = new LinkedList[nums.length];
    int sumCount = 0;

    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      if (current < k) {
        LinkedList<Integer> cSums = new LinkedList<Integer>();
        cSums.add(current);
        sumCount++;

        int prevIndex = i - 1;
        if (prevIndex >= 0 && sums[prevIndex] != null) {
          for (Integer y : sums[prevIndex]) {
            int product = y * current;
            if (product < k) {
              cSums.add(product);
              sumCount++;
            }
          }
        }
        // System.out.println(cSums.size());
        sums[i] = cSums;
      }
    }
    return sumCount;
  }

  public static void main(String[] args) {
    SubArrProduct test = new SubArrProduct();
    int[] tArr = {1,1,1};
    System.out.println(test.goodTimeComplexity(tArr, 2));
  }
}
