import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner; 

public class AListImplementation {

	public static void main(String[] args) {
		try {
			File file = new File("foxandcat.txt");
			AList<String> list = toList(file);							// Creates an AList of words in file
			String temp;
			
			filterWords(list);											// filters words starting w/ 'a' and 'A', replaces "fox" with "elephant", replaces "Fox" with "Elephant"
						
			for (int i = 0; i < list.getLength(); i++) {				// Prints out "to" and "be"
				temp = list.getEntry(i);
				if (temp.equals("to") || temp.equals("be")) {
					System.out.println(temp);
				}
			}
						
			File writeTo = new File("foxandcat(AList).txt");			// Creates file for the list to be written to
			PrintWriter writer = new PrintWriter(writeTo);

			for (int i = 0; i < list.getLength(); i++) {				// Writes all words onto the file, line per word
				writer.println(list.getEntry(i));
			}
			writer.close();
			
			list.clear();
			for (int i = 0; i < list.getLength(); i++) {				// Prints out any remaining elements; there should be none
				System.out.println(list.getEntry(i));
			}
			
		} catch (Exception e) {
			System.out.println("Exception");
			System.exit(0);
		}

	}
	
	/**
	 * Method that takes in a file and outputs an AList with words from the file
	 * @param file
	 * @return
	 */
	public static AList<String> toList(File file) throws Exception{
		AList<String> toReturn = new AList();
		Scanner s = new Scanner(file);
		while (s.hasNext()) {
			toReturn.add(removePunctuationMark(s.next()));
		}		
		s.close();
		return toReturn;
	}
	
	/**
	 * Takes in a string, and removes punctuation marks from it.
	 * @param input
	 * @return
	 */
	public static String removePunctuationMark(String input) {
		String temp = "";
		char tempChar;
		for (int i = 0; i < input.length(); i++) {
			tempChar = input.charAt(i);
			if ((tempChar >= 65 && tempChar <= 90) || (tempChar <= 122 && tempChar >= 97)) {
				temp += tempChar;
			}
		}
		return temp;
	}

	/**
	 * Removes words starting with 'a' or 'A', replaces "fox" with "elephant", replaces "Fox" with "Elephant"
	 * @param list
	 */
	public static void filterWords(AList<String> list) {
		String temp;
		for (int i = 0; i < list.getLength(); i++) {
			temp = list.getEntry(i);
			if (temp.charAt(0) == 'a'|| temp.charAt(0) == 'A') {
				list.remove(i);
				i--;
			} else if (temp.equals("fox")) {
				list.replace(i, "elephant");
			} else if (temp.equals("Fox")) {
				list.replace(i, "Elephant");
			}
		}
	}
}
