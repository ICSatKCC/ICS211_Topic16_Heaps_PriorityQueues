package heaps;
/**
 * A comparable shopping item.
 * 
 * @author William McDaniel Albritton
 * @author Edoardo Biagionii 
 */
public class ComparableItem extends Item implements Comparable<ComparableItem> {
	/*
	 * Explanation of above line of code: As well as being derived from Item,
	 * ComparableItem also implements the Comparable interface. The Comparable
	 * interface is parametrized on the type of objects to be compared:
	 * interface Comparable<T> { int compareTo(T object); } In this case, the
	 * objects to be compared to are of type ComparableItem, so the class name
	 * is used to parametrize the interface that this class implements. This is
	 * not confusing if you remember the parameter to the Comparable interface
	 * simply indicates the class of objects to be given to the compareTo method
	 */

	/**
	 * Initializes respective data fields.
	 * 
	 * @param name
	 *            is the item's name
	 * @param count
	 *            is the item's count
	 */
	public ComparableItem(String name, Integer count) {
		super(name, count); // calls Item's constructor
	}

	/**
	 * Compares a ComparableItem to another ComparableItem.
	 * 
	 * @param item
	 *            A second ComparableItem
    * @return A negative integer, zero, or a positive integer if this 
    *    object is less than, equal to, or greater than the specified object.

	 */
	public int compareTo(ComparableItem item) {
		// convert names to lowercase
		// "this" is used to reference ComparableItem object's address
		String name1 = this.getName().toLowerCase();
		String name2 = item.getName().toLowerCase();
		// compare the two names (String has its own compareTo() method)
		int result = name1.compareTo(name2);
		return result;
	}
   
   
   public static void main(String[] args) {
      ComparableItem item1 = new ComparableItem("papaya", 2);
      ComparableItem item2 = new ComparableItem("apple", 7);
      
      System.out.println(item1.compareTo(item2));
      System.out.println(item2.compareTo(item1));
      System.out.println(item1.compareTo(item1));
   
   }

} // end class definition


