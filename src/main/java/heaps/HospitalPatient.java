package heaps;
/**
 * A comparable shopping item.
 * 
 * @author William McDaniel Albritton
 * @author Edoardo Biagionii 
 */
public class HospitalPatient implements Comparable<HospitalPatient> {
	/** data fields */
    private String name = new String("name");
	private Integer priority = 0;  


	/**
	 * Initializes respective data fields.
	 * 
	 * @param name
	 *            is the person's name
	 * @param priority
	 *            is the person's priority
	 */
	public HospitalPatient(String name, Integer priority) {
		this.name = name;
		this.priority = priority;       
	}   

    /** getPriority() returns the priority of the HospitalPatient. */
    public Integer getPriority() {
        return priority;
    }
	/**
	 * Compares a HospitalPatient to another HospitalPatient.
	 * 
	 * @param item
	 *            A second HospitalPatient object to be compared to this one.
    * @return A negative integer, zero, or a positive integer if this 
    *    object is less than, equal to, or greater than the specified object.

	 */
	public int compareTo(HospitalPatient item) {
		// convert names to lowercase
		// "this" is used to reference HospitalPatient object's address
		Integer priority1 = this.getPriority();
		Integer priority2 = item.getPriority();
		// compare the two names (String has its own compareTo() method)
		int result = priority1.compareTo(priority2);
		return result;
	}

	/** toString() returns a string representation of the HospitalPatient. */
	public String toString() {
		return "Patient Name: " + name + ", Priority: " + priority;
	}

} // end class definition


