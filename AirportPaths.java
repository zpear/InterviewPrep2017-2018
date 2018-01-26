import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/*
 * Create a graph of airports connected to each other.
 * Print all unique paths from A to C like A->B->C
 */
public class AirportPaths {
	private HashMap<String, LinkedList<String>> map;
	
	public AirportPaths () {
		map = new HashMap<String, LinkedList<String>>();
	}
	
	public void addToMap(String a, String b) {
		LinkedList<String> adjacent;
		if (!map.containsKey(a)) {
			 adjacent = new LinkedList<String>();
		} else {
			adjacent = map.get(a);
		}
		adjacent.add(b);
		map.put(a, adjacent);
		
		if (!map.containsKey(b)) {
			map.put(b, new LinkedList<String>());
		}
	}
	
	public void printAllPaths(String a, String b) {
		Stack<String> q = new Stack<String>();
		HashSet<String> visitedInPath = new HashSet<String>();
		HashSet<String> visited = new HashSet<String>();
		q.add(a);
		
		String currentPath = "";
		
		while (!q.isEmpty()) {
			
			String current = q.pop();
			currentPath += current;
			
			if (!current.equals(b)) {
				visitedInPath.add(current);
				currentPath += "->";
			}
			
			LinkedList<String> adjacent = map.get(current);
			for (String n : adjacent) {
				if (!visitedInPath.contains(n)) {
					q.add(n);
				}
			}
			
			if (current.equals(b)) {
				System.out.println(currentPath);
				currentPath = a + "->";				 
			} else if (adjacent.size() == 0) {
				currentPath = a + "->";
			}
			
		}
	}
	
	public static void main(String[] args) {
		AirportPaths test = new AirportPaths();
		test.addToMap("A", "B");
		test.addToMap("A", "C");
		test.addToMap("B", "D");
		test.addToMap("C", "D");
		test.addToMap("A", "D");
		test.addToMap("B", "C");
		test.addToMap("C", "B");
		/*
		 * 		   _____
		 * 		 /		 \
		 * 		A -> B -> D
		 * 		|	 ^	  ^
		 * 		v	 |	  |
		 * 		C <__|	  |
		 * 		|_________|
		 */
		
		test.printAllPaths("A", "D");
	}
	
}
