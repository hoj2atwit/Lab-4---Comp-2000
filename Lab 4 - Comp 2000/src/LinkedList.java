
public class LinkedList<T> implements ListInterface<T> {
	
	private Node<T> firstNode;
	private int numberOfEntries;
	
	/**
	 * Default constructor with no params; initializes a null node
	 */
	public LinkedList() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	/**
	 * Makes a List with entry node as first node
	 * @param entryNode
	 */
	public LinkedList(Node<T> entryNode) {
		firstNode = entryNode;
		numberOfEntries = 0;
		Node<T> temp = firstNode;
		while (temp.getData() != null) {
			numberOfEntries++;
			temp = temp.getNext();
		}
	}

	/**
	 * Makes a List with entered data as first node's data
	 * @param entry
	 */
	public LinkedList(T entry) {
		firstNode = new Node<T>(entry);
		numberOfEntries = 1;
	}
	
	/**
	 * Adds a node with data newEntry to the end of the List
	 */
	@Override
	public void add(T newEntry) {
		numberOfEntries++;
		Node<T> toInsert = new Node<T>(newEntry);
		if (isEmpty()) {
			firstNode = toInsert;
		} else {
			Node<T> curr = getLast();
			curr.setNext(toInsert);
		}
	}

	/**
	 * Adds a node in given position. If position is greater than number of entries, doesn't allow
	 * @throws IndexOutOfBoundsException: When trying to add element to position > numberOfEntries
	 */
	@Override
	public void add(T newEntry, int givenPosition) {
		if (givenPosition < 0 || givenPosition > numberOfEntries) {
			throw new IndexOutOfBoundsException();
		}		
		numberOfEntries++;
		Node<T> toInsert = new Node<T>(newEntry);
		// Case of given position is 0
		if (givenPosition == 0) {
			toInsert.setNext(firstNode);
			firstNode = toInsert;
		} else if (givenPosition == numberOfEntries - 1) {		// Case of given position is at end of List
			getLast().setNext(toInsert);
		} else {											// Case of given position is between start and end
			// Node before the index givenPosition
			Node<T> before = getNodeAt(givenPosition - 1);		
			assert (before != null);
			// Current node in index givenPosition; Future node in givenPosition + 1 (Next Node of insertion node)
			Node<T> after = before.getNext();
			before.setNext(toInsert);
			toInsert.setNext(after);
		}
		
	}

	/**
	 * Removes entry at element givenPosition; returns NullPointerException if list is empty
	 */
	@Override
	public T remove(int givenPosition) {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		numberOfEntries--;
		Node<T> before = getNodeAt(givenPosition - 1);
		Node<T> toRemove = before.getNext();
		assert (toRemove != null);
		before.setNext(toRemove.getNext());
		return toRemove.getData();
	}

	/**
	 * Removes a node with specific entry anEntry
	 */
	@Override
	public boolean remove(T anEntry) {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		numberOfEntries--;
		Node<T> cur = firstNode;
		Node<T> before = null;
		//if (numberOfEntries == 0 && firstNode.getData().equals(anEntry)) {
		//	firstNode = null;
		//	return true;
		//} else {
			while (cur != null) {
				if (cur.getData().equals(anEntry)) {
					if (before != null) {
						before.setNext(cur.getNext());
					} else {
						firstNode = cur.getNext();
					}
					return true;
				} else {
					before = cur;
					cur = cur.getNext();
				}
			}
		//}
		return false;
	}

	/**
	 * Removes all nodes; removes entry at position 0 until list is empty
	 */
	@Override
	public void clear() {
		while (!isEmpty()) {
			remove(0);
		}		
	}

	/**
	 * Replaces data of node at givenposition with newEntry; returns old data
	 */
	@Override
	public T replace(int givenPosition, T newEntry) {
		Node<T> replace = getNodeAt(givenPosition);
		T temp = replace.getData();
		replace.setData(newEntry);
		return temp;
	}

	/**
	 * Returns data of node at given position
	 */
	@Override
	public T getEntry(int givenPosition) {
		return getNodeAt(givenPosition).getData();
	}

	/**
	 * Enters all data of list into an array and returns array
	 */
	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[numberOfEntries];
		Node<T> cur = firstNode;
		for (int i = 0; i < numberOfEntries; i++) {
			temp[i] = cur.getData();
			cur = cur.getNext();
		}
		return temp;
	}

	/**
	 * Returns if list has a node with data anEntry
	 */
	@Override
	public boolean contains(T anEntry) {
		Node<T> cur = firstNode;
		while (cur != null) {
			if (cur.getData().equals(anEntry)) {
				return true;
			}
			cur = cur.getNext();
		}
		return false;
	}

	/**
	 * Returns number of entries in list
	 */
	@Override
	public int getLength() {
		return numberOfEntries;
	}

	/**
	 * Returns if list is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}

	/**
	 * Returns last node with data
	 * @return
	 */
	public Node<T> getLast() {
		Node<T> curr = firstNode;
		if (!isEmpty()) {
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
		}
		return curr;
	}
	
	/**
	 * Returns node at index value [input]
	 * @param index
	 * @return
	 */
	public Node<T> getNodeAt(int index) {
		int count = 0;
		Node<T> curr = firstNode;
		while (count < index) {
			curr = curr.getNext();
			count++;
		}
		return curr;
	}

}
