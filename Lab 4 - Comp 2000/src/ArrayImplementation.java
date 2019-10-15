import java.io.File;
import java.util.Scanner; 

public class ArrayImplementation {

	public static void main(String[] args) {
		try {
		File file = new File("foxandcat.txt");
		AList<String> list = toList(file);
		} catch (Exception e) {
			System.out.println("Exception in location 1");
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
			toReturn.add(s.next());
		}		
		return toReturn;
	}

}
