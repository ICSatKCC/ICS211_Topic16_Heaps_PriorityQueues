package heaps;
/**
 * Represents a grocery item
 * 
 * @author William McDaniel Albritton
 */
public class Item {

	// initialize data fields to default values
	// this usually saves time later when debugging
	private String name = new String("name");
	private Integer number = Integer.valueOf(-1);

	/**
	 * Initializes respective data fields
	 * 
	 * @param itemName
	 *            is the item's name
	 * @param itemNumber
	 *            is the item's number
	 * @exception ItemException
	 *                if itemNumber is less than 1 (one)
	 */
	public Item(String itemName, Integer itemNumber) throws ItemException {
		// cannot have 0 or negative number of items
		if (itemNumber < 1) {
			throw new ItemException("Cannot have less than 1 item.");
		}
		// initialize data fields
		name = itemName;
		number = itemNumber;
	}

	/**
	 * Automatically called by println() or print()
	 * 
	 * @return two data fields separted by a comma (,) for CSV (comma separated
	 *         values) file
	 */
	public String toString() {
		// create string for CSV file
		String csvFormat = name + ", " + number;
		return csvFormat;
	}

	/**
	 * This Is A "Mutator" Method - Used To Set A Data Field.
	 * 
	 * @param itemNumber
	 *            is the item's number
	 * @exception ItemException
	 *                if itemNumber is less than 1 (one)
	 */
	public void setNumber(Integer itemNumber) throws ItemException {
		// cannot have 0 or negative number of items
		if (itemNumber < 1) {
			throw new ItemException("Cannot have less than 1 item.");
		}
		// change data field
		number = itemNumber;
	}

	/**
	 * This Is An "Accessor" Method - Used To Get A Data Field.
	 * 
	 * @return the name of item
	 */
	public String getName() {
		return name;
	}

	/**
	 * This Is An "Accessor" Method - Used To Get A Data Field.
	 * 
	 * @return the number of items
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Method main is used as a driver to test the class
	 * 
	 * @param args
	 *            Not used
	 */
	public static void main(String[] args) {
		// test constructors and toString() method
		Item item = new Item("bag of rice", 81);
		System.out.println(item.toString());
		item = new Item("bananas", 10);
		// automatically calls toSTring()
		System.out.println(item);

		// test setNumber() method
		item.setNumber(999);
		// automatically calls toSTring()
		System.out.println(item);

		// test exceptions
		try {
			item = new Item("shiitake", -10);
		} catch (ItemException exception) {
			System.out.println(exception);
			System.out.println(item);
		}

		// test exceptions
		try {
			item.setNumber(0);
		} catch (ItemException exception) {
			System.out.println(exception);
			System.out.println(item);
		}
	}// end of main

}// end of class

// *************************************************************************

/**
 * Used for all Item exceptions
 */
class ItemException extends RuntimeException {
	/**
	 * @param message
	 *            describes the exact cause of the error.
	 */
	public ItemException(String message) {
		super(message);
	}// end of constructor
}// end of class

// *************************************************************************

/*
 * PROGRAM OUTPUT: 
bag of rice, 81
bananas, 10
bananas, 999
ItemException: Cannot have less than 1 item.
bananas, 999
ItemException: Cannot have less than 1 item.
bananas, 999
 */