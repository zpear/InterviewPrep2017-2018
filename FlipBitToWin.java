/*
 * You have an integer and you can flip exactly one 
 * bit from a 0 to a 1. Write code to find the 
 * length of the longest sequence of 1s you could create.
 */
public class FlipBitToWin {

  /*
   * returns -1 if no bit should be flipped. Otherwise returns
   * an int from 0 to 31, 0 being the rightmost bit and 31 being
   * the leftmost bit, that should be flipped to form the longest
   * string of 1s
   */
  public int findBitToFlip(int num) {
    int count;
    if (num < 0) {
      count = 1;
    } else {
      count = 0;
    }
    
    int firstHalf = 0;
    int connectingBit = -1;
    int longestChain = 0;
    int bitToFlip = -1;
    for (int i = 31; i >= 0; i--) {  
      if (num < 0) {
    	  count++;
      } else {
    	  if (firstHalf == 0) {
    		  firstHalf = count;
    		  connectingBit = i;
    	  } else {
    		  if (longestChain < count + firstHalf) {
    			  longestChain = count + firstHalf;
    			  bitToFlip = connectingBit;
    		  } else {
    			  firstHalf = 0;
    			  count = 0;
    		  }
    	  }
      }
      num = num<<1;
    }
    return bitToFlip;
  }
  public static void main(String[] args) {
    FlipBitToWin test = new FlipBitToWin();
    System.out.println(test.findBitToFlip(7)); // 00111
    System.out.println(test.findBitToFlip(10)); // 01010
    System.out.println(test.findBitToFlip(237)); // 11101101
    
  }
}
