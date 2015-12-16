import java.io.BufferedReader;
import java.io.FileReader;

public class A5 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("a5.txt"));
			String line;
			
			int nice = 0;
			while ((line = br.readLine()) != null) {
				if (!containIllegalPair(line)) {
					if (validateVowelAndDouble(line)) {
						nice++;
					}
				}
			}
			
			System.out.println(nice);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean containIllegalPair(String line) {
		return line.contains("ab") || line.contains("cd") || line.contains("pq") || line.contains("xy");
	}
	
	public static boolean validateVowelAndDouble(String line) {
		boolean valid = false;
		int vowel = 0;
		boolean d = false;
		char cbefore = '@';
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			// Check vowel
			if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u')) {
				vowel++;
			}
			
			// Check for double
			if (c == cbefore) {
				d = true;
			}
			
			// End condition
			if (d && vowel >= 3) {
				return true;
			}
			
			cbefore = c;
		}
		return valid;
	}

}
