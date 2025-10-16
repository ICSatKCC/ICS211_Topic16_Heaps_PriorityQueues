package heaps;
/**
 * This is a (regular) array-based minheap.
 * @param <T> The type held in the heap.
 * @author Lisa Miller from W Albritton
 * @since 10/15/2025
 */
public class Heap<T extends Comparable<? super T>> {
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
   public Heap() {
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
   * Tests if Heap is empty.
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
   * trickle up the tree, moves child node up if parent is larger.
   * @param indexOfParent is the index of the parent node
   * @param indexOfChild is the index of the child node
   */
   private void trickleUp(int indexOfParent, int indexOfChild) {
      if ((indexOfParent >= 0)
      	  && (compare(array[indexOfChild], array[indexOfParent]) < 0)) {
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
   * @return item at top of the heap (smallest item)
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
 * @return item at the top of the heap (smallest item)
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
 * trickle down the tree, moves parent down if child is smaller.
 * @param indexOfParent is the index of the parent node
 */
   private void trickleDown(int indexOfParent) {
   // calculate index of left and right children
      int indexOfLeftChild = 2 * indexOfParent + 1;
      int indexOfRightChild = 2 * indexOfParent + 2;
      int indexOfSmallestOfThreeNodes = indexOfParent;
   // if only one child, possible switch
      if (indexOfLeftChild <= indexOfLastElement) {
         if (this.compare(array[indexOfLeftChild], array[indexOfParent]) < 0) {
         // if leftChild < parent, smallest = leftChild
            indexOfSmallestOfThreeNodes = indexOfLeftChild;
         }
      // if two children, find the smallest of two children
         if (indexOfRightChild <= indexOfLastElement) {
         // determine smallest child
            if (this.compare(array[indexOfSmallestOfThreeNodes],
            	  array[indexOfRightChild]) > 0) {
            // if smallest > right, then smallest = right
               indexOfSmallestOfThreeNodes = indexOfRightChild;
            }
         }
      // if the smallest child is smaller than the parent, then swap
      // if the indexOfSmallestOfThreeNodes is not the parent, then swap
         if (indexOfSmallestOfThreeNodes != indexOfParent) {
         // if smallest < parent, swap them (minheap)
            T temporary = array[indexOfParent];
            array[indexOfParent] = array[indexOfSmallestOfThreeNodes];
            array[indexOfSmallestOfThreeNodes] = temporary;
         // keep trickling down
            this.trickleDown(indexOfSmallestOfThreeNodes);
         }
      }
   // if parent is a leaf, end of trickle-down, so do nothing
   }

} // end class definition

