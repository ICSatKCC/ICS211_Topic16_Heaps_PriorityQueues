package heaps;
/**
 * A driver program to test class MaxHeap. 
 * @author Lisa Miller from W Albritton
 * @since 4/12/2018
 */
public class MaxHeapDriver {
 
/**
 * Driver code to test class MaxHeap.java.
 * @param arguments Commandline arguments not used
 */
   public static void main(String[] arguments) {
   // create heap of integers
      MaxHeap<Integer> heap = new MaxHeap<Integer>();
      // test empty
      System.out.print("Is heap empty? ");
      System.out.println(heap.empty());
      // test add
      System.out.println("Adding 8");
      heap.add(8);
      System.out.println(heap.toString());
      System.out.println("Adding 6");
      heap.add(6);
      System.out.println(heap.toString());
      System.out.println("Adding 7");
      heap.add(7);
      System.out.println(heap.toString());
      System.out.println("Adding 9");
      heap.add(9);
      System.out.println(heap.toString());
      System.out.println("Adding 4");
      heap.add(4);
      System.out.println(heap.toString());
      System.out.println("Adding 3");
      heap.add(3);
      System.out.println(heap.toString());
      System.out.println("Adding 2");
      heap.add(2);
      System.out.println(heap.toString());
      System.out.println("Adding 5");
      heap.add(5);
      System.out.println(heap.toString());
      System.out.println("Adding 1");
      heap.add(1);
      System.out.println(heap.toString());
   
      // test get
   
      System.out.print("\nget method returns: ");
      System.out.println(heap.get());
      System.out.println("Heap unchanged by get:");
      System.out.println(heap.toString());
      
      // test remove
      System.out.println("\nRemoving 4 items");   
      for (int i = 0; i < 4; i++) {
         int x = heap.remove();
         System.out.println(x);
         System.out.println(heap.toString());
      }
      // test exception
      System.out.println("\nTry to remove from empty heap:");
      try {
         for (int i = 0; i < 10; i++) {
            int x = heap.remove();
            System.out.println(x);
            System.out.println(heap.toString());
         }
      } catch (HeapException exception) {
         System.out.println(exception);
      }
   }
} // end class  

