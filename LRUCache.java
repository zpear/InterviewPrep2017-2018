import java.util.HashMap;
/*
 * Design and implement a data structure for a Least Recently Used cache.
 * It should have functions for get() and put().
 */
class LRUCache {
    private LLNode head;
    private LLNode tail;
    private HashMap<Integer, LLNode> map;
    private int cap;
    private int size;
    
    public static class LLNode {
        int val;
        int key;
        LLNode next;
        LLNode prev;
    }
        
    public LRUCache(int capacity) {
        cap = capacity;
        size = 0;
        head = new LLNode();
        tail = new LLNode();
        head.next = tail;
        tail.prev = head;
        
        map = new HashMap<Integer, LLNode>();
    }
    
    public int get(int key) {
        LLNode cNode = map.get(key);
        if (cNode == null) {
            return -1;
        }
        updateUse(cNode);
        
        return cNode.val;
    }
    private void updateUse(LLNode cNode) {
        
        if (cNode.prev != head) {
            // Cut out of old position in list
            cNode.next.prev = cNode.prev;
            cNode.prev.next = cNode.next;
        
            // Place into new position in list
            cNode.next = head.next;
            cNode.prev = head;
            head.next = cNode;
            cNode.next.prev = cNode;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LLNode cNode = map.get(key);
            cNode.val = value;
            updateUse(cNode);
            return;
        }
        
        size++;
        
        if (size > cap) {
            LLNode newLast = tail.prev.prev;
            LLNode toDelete = tail.prev;
            newLast.next = tail;
            tail.prev = newLast;            
            map.remove(toDelete.key);
            size--;
        }
     
        LLNode temp = new LLNode();
        temp.val = value;
        temp.key = key;
        
        temp.next = head.next;
        temp.prev = head;
        head.next.prev = temp;
        head.next = temp;
        
        map.put(key, temp);
    }
}
