
public class LinkedListTester {

	public static void main(String[] args) {
		LinkedList<String> test = new LinkedList();
		String temp;
		// Adding 0 - 24 to list
		for (int i = 0; i < 25; i++) {
			test.add(String.format("%d", i));
		}
		// Printing out list
		for (int i = 0; i < 25; i++) {
			System.out.println(test.getEntry(i));
		}
		// Removing numbers divisible by 2 and printing out list
		for (int i = 0; i < test.getLength(); i++) {
			temp = test.getEntry(i);
			if (temp.charAt(0) == 49) {
				test.remove(i);
				i--;
			}
		}
		for (int i = 0; i < test.getLength(); i++) {
			System.out.println(test.getEntry(i));
		}
		test.add("HELLOOOOO",5);
		for (int i = 0; i < test.getLength(); i++) {
			System.out.println(test.getEntry(i));
		}
		// Removing 23 specifically
		System.out.println(test.getLength());
		test.remove("23");
		System.out.println(test.getLength());
		test.remove(1);
		for (int i = 0; i < test.getLength(); i++) {
			System.out.println(test.getEntry(i));
		}
		// ERROR FROM HERE
		System.out.println("ERROR FROM HERE");
		test.clear();
		for (int i = 0; i < test.getLength(); i++) {
			System.out.println(test.getEntry(i));
		}

		// Attempting to add more than 10,000 elements
		for (int i = 0; i < 10005; i++) {
			test.add(String.format("%d", i));
		}

	}

}
