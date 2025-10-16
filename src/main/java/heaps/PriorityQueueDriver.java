package heaps;
/**
 * A driver program to test the PriorityQueue class 
 * roughly based on Java API's PriorityQueue.
 * @author Lisa Miller from W Albritton
 */
public class PriorityQueueDriver {
   
	/**
	 * Driver code to test class.
	 * @param arguments Commandline arguments not used
	 */
   public static void main(String[] arguments) {
   	// create Priority Queue of integers
      QueueInterface<Integer> queue = new PriorityQueue<Integer>();
   	// test empty
      System.out.print("Is queue empty? ");
      System.out.println(queue.empty());
   	// test offer
   
      System.out.println("Offering 3");
      queue.offer(3);
      System.out.println("Offering 6");
      queue.offer(6);
      System.out.println("Offering 7");
      queue.offer(7);
      System.out.println("Offering 5");
      queue.offer(5);
      System.out.println("Offering 4");
      queue.offer(4);
      System.out.println("Offering 8");
      queue.offer(8);
      System.out.println("Offering 2");
      queue.offer(2);
      System.out.println("Offering 9");
      queue.offer(9);
      System.out.println("Offering 1");
      queue.offer(1);
   	// test peek
    
      System.out.println("\nItem at front of queue (peek): ");
      System.out.println(queue.peek());
   	// test empty
      System.out.print("\nIs queue empty? ");
      System.out.println(queue.empty());
   	// test poll
      for (Integer i = 0; i < 4; i++) {
         Integer x = queue.poll();
         System.out.println("\nItem removed from front of queue (poll): ");
         System.out.println(x);
      }
      
      // test exception handling of PQ
      System.out.println("\nTry to remove from empty queue:");
      for (int i = 0; i < 10; i++) {
         Integer x = queue.poll();
         System.out.println("\nItem removed from front of queue (poll): ");
         System.out.println(x);
      }
      
      System.out.print("\nIs queue empty? ");
      System.out.println(queue.empty());
   } //end main
   
} // end class
