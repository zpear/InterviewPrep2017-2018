import java.util.LinkedList;

public class SubArrProduct {
  
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

}
