
public interface ListInterface<T> {
	
	/**
	 * Adds a specific entry to the end of the List
	 * @param anEntry
	 */
	public void add(T newEntry);
	
	/**
	 * Adds a specific entry to the index givenPosition
	 * @param anEntry
	 * @param givenPosition
	 * @throws IndexOutOfBoundsException if either givenPosition < 0 or givenPosition >= getLength()
	 */
	public void add (T newEntry, int givenPosition);
	
	/**
	 * Removes an entry at given position
	 * @param givenPosition
	 * @return the removed entry
	 * @throws IndexOutOfBoundsException if either givenPosition < 0 or givenPosition >= getLength()
	 */
	public T remove(int givenPosition);
	
	/**
	 * 
	 * @param anEntry
	 * @return true if the entry was in the list; false otherwise
	 */
	public boolean remove(T anEntry);
	
	/**
	 * Removes all entries
	 */
	public void clear();
	
	/**
	 * Replaces an entry at given position with a new one
	 * @param givenPosition
	 * @param newEntry
	 * @return the replaced entry
	 * @throws IndexOutOfBoundsException if either givenPosition < 0 or givenPosition >= getLength()
	 */
	public T replace(int givenPosition, T newEntry);
	
	/**
	 * Retrieves an entry at given position
	 * @param givenPosition
	 * @return entry at given position
	 * @throws IndexOutOfBoundsException if either givenPosition < 0 or givenPosition >= getLength()
	 */
	public T getEntry(int givenPosition);
	
	/**
	 * Retrieves all entries that are in this list in the order they occur in the list.
	 * @return a newly allocated array of all the entries in the list
	 * If list is empty, returned array is empty
	 */
	public Object[] toArray();
	
	/**
	 * Sees if list contains given entry
	 * @param anEntry
	 * @return true if found, false if not found
	 */
	public boolean contains(T anEntry);
	
	/**
	 * Gets length of interface (amount of elements in list)
	 * @return
	 */
	public int getLength();
	
	/**
	 * Checks if list is empty
	 * @return true if empty; false of otherwise
	 */
	public boolean isEmpty();

}
