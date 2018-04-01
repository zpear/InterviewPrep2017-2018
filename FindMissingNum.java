
public class FindMissingNum {
  public static int findMissingNum(int[] arr) {
    return findMissingNumRecur(arr, 0, arr.length - 1);
  }
  private static int findMissingNumRecur(int[] arr, int start, int end) {
    // edge cases (assume input is not an empty array)
    // also assume every input array will have a missing number
    if (start == 0 && arr[start] != 1)
      return 1;
    else if (start == end - 1) {
      if (arr[start] != start + 1)
        return start + 1;
      else
        return end+1;
    }
    
    int middle = (start + end) / 2;
    if (arr[middle] != middle + 1) {
      // Check if this is the first misshift
      if (arr[middle-1] == middle) {
        return middle+1;
      } else {
        // look to the left
        return findMissingNumRecur(arr, start, middle);
      }
    } else {
      // left subarray is normal, look to the right
      return findMissingNumRecur(arr, middle, end);
    }
    
  }
  
  public static void main(String[] args) {
    int[] test1 = {1,2,3,5,6,7,8,9};
    System.out.println(findMissingNum(test1));
    int[] test2 = {2,3,4,5};
    System.out.println(findMissingNum(test2));
    int[] test3 = {1,2,3,4,6,7,8};
    System.out.println(findMissingNum(test3));
    int[] test4 = {2};
    System.out.println(findMissingNum(test4));
    int[] test5 = {1,2,3,4,5,6,8};
    System.out.println(findMissingNum(test5));
    
  }
}
