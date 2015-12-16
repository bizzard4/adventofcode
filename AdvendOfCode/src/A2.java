import java.io.BufferedReader;
import java.io.FileReader;

public class A2 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("a2.txt"));
			String line;
			int paper = 0;
			while ((line = br.readLine()) != null) {
				// 0 : l
				// 1 : w
				// 2 : h
				int[] dims = getDimm(line);
				
				// Calculate surface
				int side1 = dims[0]*dims[1];
				int side2 = dims[1]*dims[2];
				int side3 = dims[2]*dims[0];
				int surface = side1*2 + side2*2 + side3*2;
				
				// Get smallest size
				int extra = Math.min(side1, Math.min(side2, side3));
				
				// Total paper required.
				paper += extra + surface;
			}
			
			System.out.println(paper);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int[] getDimm(String line) {
		int[] dims = new int[3];
		String[] split = line.split("x");
		
		dims[0] = Integer.parseInt(split[0]);
		dims[1] = Integer.parseInt(split[1]);
		dims[2] = Integer.parseInt(split[2]);
		
		return dims;
	}

}
