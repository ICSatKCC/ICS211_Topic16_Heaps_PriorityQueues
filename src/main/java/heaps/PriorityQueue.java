package heaps;
/**
 * A PriorityQueue class roughly based on Java API's PriorityQueue class.
 * @param <T> The type of object held.
 * @author Lisa Miller from W Albritton
 * @since 4/12/2018
 */
public class PriorityQueue<T extends java.lang.Comparable<T>> 
    implements QueueInterface<T> {
	// data fields
  /** Uses Heap.java minheap class. */
	protected Heap<T> heap = new Heap<T>(); 

	/** constructor. */
	public PriorityQueue() {
      // data fields already initialized
	}

	/**
	 * Tests if the Queue is empty.
	 * @return true/false if empty/not empty
	 */
	public boolean empty() {
		return heap.empty();
	}

	/**
	 * offers an element to the PriorityQueue.
	 * @param element is offered to the PriorityQueue
	 * @return true if success, else false
	 */
	public boolean offer(T element) {
		try {
			heap.add(element);
		} catch (HeapException exception) {
			return false;
		}
		return true;
	}

	/**
	 * Retrieves and removes the from the top of PriorityQueue, 
   * or null if PriorityQueue is empty.
	 * @return the top of PriorityQueue, or null if PriorityQueue is empty
	 */
	public T poll() {
		try {
			return heap.remove();
		} catch (HeapException exception) {
			return null;
		}
	}

	/**
	 * Retrieves, but does not remove, from the top of PriorityQueue, 
   * or null if PriorityQueue is empty.
	 * @return the top of PriorityQueue, or null if PriorityQueue is empty
	 */
	public T peek() {
		try {
			return heap.get();
		} catch (HeapException exception) {
			return null;
		}
	}
} // end class definition

