package heaps;
/**
 * This is a maxheap.
 * The only difference is the order in compare
 * method call in trickleUp/trickleDown.
 *
 * Gives "unsafe" operations compiler warning
 * because of generics in array.
 * @param <T> The type held in the heap
 *
 * @author Lisa Miller from W Albritton
 * @since 4/12/2018
 */
public class MaxHeap<T extends Comparable<? super T>> {
  // data fields
   /** Maximum allowed size.
   * This code doesn't do resizing
   */ 
   private final int maxSize = 100;
   /** Location for next add. */
   private int indexOfLastElement = -1;
   /** Array where everything is stored. */
   @SuppressWarnings("unchecked")
   private T[] array = (T[]) new Comparable[maxSize];

   /** Constructor. */
   public MaxHeap() {
   // data fields already initialized
   }

/**
 * Automatically called by println() or print().
 * @return a String of the MaxHeap contents ordered by array indicies
 */
   public String toString() {
      String string = "";
      for (int i = 0; i <= indexOfLastElement; i++) {
         string = string + "array[" + i + "] = " + array[i] + "\n";
      }
      return string;
   }

/**
 * Tests if MaxHeap is empty.
 * @return true/false if empty/not empty
 */
   public boolean empty() {
      return (indexOfLastElement == -1);
   }

/**
 * adds an item to the heap.
 * @param item is the object to be added
 */
   public void add(T item) {
   // add the new item at the end of the array
      indexOfLastElement++;
      array[indexOfLastElement] = item;
   // current item is child
      int indexOfChild = indexOfLastElement;
   // calculate index of parent
      int indexOfParent = (indexOfChild - 1) / 2;
   // "trickle up" the tree
      this.trickleUp(indexOfParent, indexOfChild);
   }

/**
 * trickle up the tree, moves child node up if parent is smaller.
 * @param indexOfParent is the index of the parent node
 * @param indexOfChild is the index of the child node
 */
   private void trickleUp(int indexOfParent, int indexOfChild) {
      if ((indexOfParent >= 0)
      	  && (compare(array[indexOfParent], array[indexOfChild]) < 0)) {
      // if parent < child, swap them (maxheap)
         T temporary = array[indexOfParent];
         array[indexOfParent] = array[indexOfChild];
         array[indexOfChild] = temporary;
      // "trickle-up" heap
         indexOfChild = indexOfParent;
         indexOfParent = (indexOfChild - 1) / 2;
         this.trickleUp(indexOfParent, indexOfChild);
      }
   // if no more swapping, stop recursion
   }

/**
 * Since arrays as a whole cannot be cast to java.lang.Comparable 
 * each element being compared is individually cast to java.lang.Comparable. 
 * @param item1 is the 1st element to be compared 
 * @param item2 is the 2nd element to be compared
 * @return compareTo result.
 */
   
   private int compare(T item1, T item2) {
      return item1.compareTo(item2);
   }

/**
 * gets an item from the top of the heap.
 * @exception HeapException if heap is empty
 * @return item at top of the heap (largest item)
 */
   public T get() throws HeapException {
   // if empty, throw exception
      if (this.empty()) {
         throw new HeapException("Cannot get(), because heap is empty!");
      }
   // get a reference to the root
      T root = array[0];
      return root;
   }

/**
 * removes and returns an item from the heap. 
 * @exception HeapException if heap is empty
 * @return item at the top of the heap (largest item)
 */
   public T remove() throws HeapException {
   // if empty, throw exception
      if (this.empty()) {
         throw new HeapException("Cannot remove(), because heap is empty!");
      }
   // save a reference to the root
      T root = array[0];
   // last item in tree assigned to root
      array[0] = array[indexOfLastElement];
   // "delete" last item by decrementing indexOfLastElement
      indexOfLastElement--;
   // trickle down the tree, so the node is in the correct position
      this.trickleDown(0);
   // return the root
      return root;
   }

/**
 * trickle down the tree, moves parent down if child is larger.
 * @param indexOfParent is the index of the parent node
 */
   private void trickleDown(int indexOfParent) {
   // calculate index of left and right children
      int indexOfLeftChild = 2 * indexOfParent + 1;
      int indexOfRightChild = 2 * indexOfParent + 2;
      int indexOfLargestOfThreeNodes = indexOfParent;
   // if only one child, possible switch
      if (indexOfLeftChild <= indexOfLastElement) {
         if (this.compare(array[indexOfLeftChild], array[indexOfParent]) > 0) {
         // if leftChild > parent, largest = leftChild
            indexOfLargestOfThreeNodes = indexOfLeftChild;
         }
      // if two children, find the largest of two children
         if (indexOfRightChild <= indexOfLastElement) {
         // determine largest child
            if (this.compare(array[indexOfLargestOfThreeNodes],
            	  array[indexOfRightChild]) < 0) {
            // if largest < right, then largest = right
               indexOfLargestOfThreeNodes = indexOfRightChild;
            }
         }
      // if the largest child is larger than the parent, then swap
      // if the indexOfLargestOfThreeNodes is not the parent, then swap
         if (indexOfLargestOfThreeNodes != indexOfParent) {
         // if largest > parent, swap them (maxheap)
            T temporary = array[indexOfParent];
            array[indexOfParent] = array[indexOfLargestOfThreeNodes];
            array[indexOfLargestOfThreeNodes] = temporary;
         // keep trickling down
            this.trickleDown(indexOfLargestOfThreeNodes);
         }
      }
   // if parent is a leaf, end of trickle-down, so do nothing
   }

} // end class definition

