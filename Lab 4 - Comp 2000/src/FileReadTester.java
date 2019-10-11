import java.io.File; 
import java.util.Scanner; 

public class FileReadTester {

	public static void main(String[] args) throws Exception {
		File file = new File("foxandcat.txt");
		Scanner s = new Scanner(file);
		while (s.hasNext()) {
			System.out.println(s.next());
		}

	}

}
