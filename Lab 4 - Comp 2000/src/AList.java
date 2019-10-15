import java.util.Arrays;

public class AList<T> implements ListInterface<T> {
	
	private T[] list;
	private int numberOfEntries;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10000;
	
	/**
	 * Constructor specifying capacity; if lower than default, sets as default
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public AList(int capacity) {
		this.capacity = (capacity<DEFAULT_CAPACITY? DEFAULT_CAPACITY : capacity);
		numberOfEntries = 0;
		list = (T[]) new Object[this.capacity];
	}
	
	/**
	 * Constructor with no args; uses default capacity for capacity
	 */
	public AList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * If capacity is above max capacity, throws an exception
	 * @param capacity
	 */
	public void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY) {
			System.out.printf("Over max capacity!%n");
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Ensures list is not full
	 */
	public void ensureCapacity() {
		if(isFull()) {
			capacity *= 2;
			checkCapacity(capacity);
			list = (T[]) Arrays.copyOf(list, capacity);
		}
	}
	
	/**
	 * Adds a new entry to the end of the List
	 */
	@Override
	public void add(T newEntry) {
		list[numberOfEntries++] = newEntry;
		ensureCapacity();
	}

	/**
	 * Adds a specific entry to the index givenPosition
	 * @param anEntry
	 * @param givenPosition
	 * @throws IndexOutOfBoundsException if either givenPosition < 0 or givenPosition >= getLength()
	 */
	@Override
	public void add(T newEntry, int givenPosition) {
		checkIndexLocation(givenPosition);
		makeRoom(givenPosition);
		list[givenPosition] = newEntry;
		ensureCapacity();
	}

	/**
	 * Removes entry from specific position
	 * @return removed entry
	 * @throws IndexOutOfBoundsException if givenPosition < 0 or >= NumberOfEntries
	 */
	@Override
	public T remove(int givenPosition) {
		checkIndexLocation(givenPosition);
		T outData = list[givenPosition];
		removeGap(givenPosition);
		return outData;
	}

	/**
	 * Removes specific entry
	 */
	@Override
	public boolean remove(T anEntry) {
		for (int i = 0; i < numberOfEntries; i++) {
			if (anEntry.equals(list[i])) {
				removeGap(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes entries until none are left
	 */
	@Override
	public void clear() {
		while (!isEmpty()) {
			remove(numberOfEntries - 1);
		}
		
	}

	/**
	 * Replaces element in given position with newEntry, returns old entry
	 */
	@Override
	public T replace(int givenPosition, T newEntry) {
		checkIndexLocation(givenPosition);
		T temp = getEntry(givenPosition);
		list[givenPosition] = newEntry;
		return temp;
	}

	/**
	 * Returns element in given position in list
	 */
	@Override
	public T getEntry(int givenPosition) {
		checkIndexLocation(givenPosition);
		return list[givenPosition];
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for (int i = 0; i < numberOfEntries; i++) {
			result[i] = list[i];
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		for (int i = 0; i < numberOfEntries; i++) {
			if (list[i].equals(anEntry)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}
	
	/**
	 * @return true if full; false otherwise
	 */
	public boolean isFull() {
		return (numberOfEntries == capacity);
	}

	/**
	 * Clears up index position to add a new index there
	 * @param position
	 */
	private void makeRoom(int position) {
		for (int i = numberOfEntries; i >= position; i--) {
			list[i] = list[i-1];
		}
	}
	
	/**
	 * Removes element in position, shifts all elements with index > position to the "left" to fill the gap and decrements numberOfEntries
	 * @param position
	 */
	private void removeGap(int position) {
		list[position] = null;
		for (int i = position; i < numberOfEntries - 1; i++) {
			list[i] = list[i+1];
		}
		numberOfEntries--;
	}
	
	/**
	 * For use to check if given position is valid
	 * @param givenPosition
	 */
	private void checkIndexLocation(int givenPosition) {
		if (givenPosition < 0 || givenPosition >= numberOfEntries) {
			throw new IndexOutOfBoundsException();
		}
	}
}
