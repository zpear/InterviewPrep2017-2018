import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes
 */
public class GTOne {
	
	public static class Graph {
		Node head;
		
		public Graph() {
			head = new Node();
		}
		
		public boolean isRoute(String a, String b) {
			Queue<Node> toSearch = new LinkedList<Node>();
			HashSet<Node> searched = new HashSet<Node>();
			toSearch.add(head);
			
			String foundFirst = (head.id.equals(a) || head.id.equals(b)) ? head.id : "";
			
			while (!toSearch.isEmpty()) {
				Node temp = toSearch.poll();

				for (Node t : temp.neighbors) {
					// to ensure no loops
					if (!searched.contains(t)) {
						searched.add(temp);
						toSearch.add(t);
						if (a.equals(t.id) || b.equals(t.id)) {
							// Begin searching from first found node for the other
							if (foundFirst.equals("")) {
								foundFirst = t.id;
								toSearch.clear();
								toSearch.add(t);
							// If the other node is found after searching from the first,
							} else if (!t.id.equals(foundFirst)) {
								return true;
							}
						}
					}
				}
			}
			return false;
		}
	}
	
	public static class Node {
		LinkedList<Node> neighbors;
		String id;
		
		public Node() {
			neighbors = new LinkedList<Node>();
		}
		public Node(String id) {
			this.id = id;
			neighbors = new LinkedList<Node>();
		}
	}
	
	public static void main(String[] args) {
		Graph g1 = new Graph();
		Node t = g1.head;
		t.id = "A";
		t.neighbors.add(new Node("B"));
		t = t.neighbors.get(0);
		t.neighbors.add(new Node("C"));
		System.out.println(g1.isRoute("A", "C"));
		System.out.println(g1.isRoute("C", "B"));
		System.out.println(g1.isRoute("D", "B"));
		
		/*
		 *   A --> B --> C
		 */
	}
	
}
	
	


