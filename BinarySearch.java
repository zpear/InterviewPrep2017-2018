
public class BinarySearch {
	
	public boolean binarySearch(int[] arr, int value) {
		if (arr.length == 1)
			return arr[0] == value;
		int mid = arr[arr.length/2];
		int[] half;
		
		if (mid == value)
			return true;
		else if (mid < value) {
			if (arr.length%2 == 0)
				half = new int[arr.length/2 - 1];
			else
				half = new int[arr.length/2];
			System.arraycopy(arr, arr.length/2+1, half, 0, half.length);
		} else {
			half = new int[arr.length/2];
			System.arraycopy(arr, 0, half, 0, half.length);
		}
		return binarySearch(half, value);
	}
	
	public static void main(String[] args) {
		BinarySearch test = new BinarySearch();
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++)
			arr[i] = i;
		System.out.println(test.binarySearch(arr, 88));
		System.out.println(test.binarySearch(arr, 5));
	}
}
