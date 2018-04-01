import java.util.ArrayList;

public class FindAllSubsets {
  public static ArrayList<ArrayList<Integer>> findAllSubsets(int[] nums) {
    ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
    recur(nums, 0, allSubsets);
    return allSubsets;
  }
  
  private static void recur(int[] nums, int pos, ArrayList<ArrayList<Integer>> subsets) {
    if (pos == nums.length) {
      subsets.add(new ArrayList<Integer>()); // add empty set
      return;
    }
    System.out.println("d");
    ArrayList<ArrayList<Integer>> newSet = new ArrayList<ArrayList<Integer>>();
    for (ArrayList<Integer> set : subsets) {
      ArrayList<Integer> added = new ArrayList<Integer>();
      added.addAll(set);
      added.add(nums[pos]);
      newSet.add(added);
      //set.add(nums[pos]);
    }
    ArrayList<Integer> newNum = new ArrayList<Integer>();
    newNum.add(nums[pos]);
    newSet.add(newNum);
    subsets.addAll(newSet);
    recur(nums, ++pos, subsets);
  }
  
  public static void printLists(ArrayList<ArrayList<Integer>> subsets) {
    for (ArrayList<Integer> s : subsets) {
      System.out.print("[ ");
      for (Integer i : s) {
        System.out.print(i + " ");
      }
      System.out.println("]");
    }
  }
  
  public static void main(String[] args) {
    int[] test1 = {1,2,3};
    printLists(findAllSubsets(test1));
    
  }
}
