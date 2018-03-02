import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TrackMedian {

  // higher values kept in min heap
  // lower values kept in max heap
  public static class MedianTracker {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public static class MaxComparator implements Comparator<Integer> {
      public int compare(Integer x, Integer y) {
        return y - x;
      }
    }

    public MedianTracker() {
      maxHeap = new PriorityQueue<Integer>(11, new MaxComparator());
      minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int n) {
      PriorityQueue<Integer> heap;
      if (minHeap.size() == 0 || n <= minHeap.peek()) {
        heap = maxHeap;
      } else {
        heap = minHeap;
      }
      heap.add(n);

      // resize heaps to maintain median
      int diff = minHeap.size() - maxHeap.size();
      if (Math.abs(diff) > 1) {
        if (minHeap.size() > maxHeap.size()) {
          maxHeap.add(minHeap.poll());
        } else {
          minHeap.add(maxHeap.poll());
        }
      }
    }

    public double getMedian() {
      if (maxHeap.size() == minHeap.size()) {
        return ((double) maxHeap.peek() + minHeap.peek()) / 2;
      } else {
        if (maxHeap.size() > minHeap.size()) {
          return maxHeap.peek();
        } else {
          return minHeap.peek();
        }
      }
    }
  }

  public static void main(String[] args) {
    MedianTracker tracker = new MedianTracker();
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
      tracker.addNum(a[a_i]);
      System.out.println(tracker.getMedian());
    }
  }
}
