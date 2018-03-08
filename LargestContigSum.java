
public class LargestContigSum {
  public static int findSum(int[] arr) {
    int left = 0;
    int cSum = arr[0];
    int max = cSum;

    for (int right = 1; right < arr.length; right++) {
      if (cSum < 0) {
        cSum -= arr[left];
        left++;
      }
      cSum += arr[right];
      if (cSum > max)
        max = cSum;
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    int[] nums2 = { -1, -2, -3 };
    int[] nums3 = { 5, -1, 2 };

    System.out.println(findSum(nums));
    System.out.println(findSum(nums2));
    System.out.println(findSum(nums3));
  }
}
