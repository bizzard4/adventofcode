import java.io.FileReader;

public class A1 {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("a1.txt");
			int c = fr.read();
			int accumulator = 0;
			while (c != -1) {
				char character = (char)c;
				
				if (character == '(') {
					accumulator++;
				}
				else
				{
					accumulator--;
				}
				c = fr.read();
			}
			
			System.out.println(accumulator);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
