package heaps;
/**
 * A Queue interface roughly based on Java API's Queue interface.
 * @param <T> the type of Object held in Queue
 * @author Lisa Miller from W Albritton
 * @since 4/12/2018
 */
public interface QueueInterface<T> {

   //interface method specifications default to public
   //not needed in listings.
   
	/**
	 * Tests if the Queue is empty.
	 * 
	 * @return true/false if empty/not empty
	 */
   boolean empty();

	/**
	 * Adds an element to the end of the Queue.
	 * 
	 * @param element
	 *            is added to the end of the Queue
	 * @return true if it was possible to add the element to Queue, else false
	 */
   boolean offer(T element);

	/**
	 * Retrieves and removes the from the front of Queue, or null if Queue is
	 * empty.
	 * 
	 * @return the front of Queue, or null if Queue is empty
	 */
   T poll();

	/**
	 * Retrieves, but does not remove, from the front of Queue, or null if Queue
	 * is empty.
	 * 
	 * @return the front of Queue, or null if Queue is empty
	 */
   T peek();

} // end interface

