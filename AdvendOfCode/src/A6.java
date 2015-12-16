import java.io.BufferedReader;
import java.io.FileReader;

public class A6 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("a6.txt"));
			String line;
			
			int lit = 0;
			boolean[][] lights = new boolean[1000][1000];
			
			while ((line = br.readLine()) != null) {
				
				// Get coords
				String[] split = line.split(" ");
				String[] from;
				String[] to;
				
				if (line.startsWith("turn")) {
					from = split[2].split(",");
					to = split[4].split(",");
				} else {
					from = split[1].split(",");
					to = split[3].split(",");
				}
				
				int fromX = Integer.parseInt(from[0]);
				int fromY = Integer.parseInt(from[1]);
				
				int toX = Integer.parseInt(to[0]);
				int toY = Integer.parseInt(to[1]);
				
				// Do action
				if (line.startsWith("turn on")) {	
					for (int x = fromX; x <= toX; x++) {
						for (int y = fromY; y <= toY; y++) {
							if (lights[x][y] == false) {
								lights[x][y] = true;
								lit++;
							}
						}
					}
				}
				else if (line.startsWith("turn off")) {
					for (int x = fromX; x <= toX; x++) {
						for (int y = fromY; y <= toY; y++) {
							if (lights[x][y] == true) {
								lights[x][y] = false;
								lit--;
							}
						}
					}
				}
				else if (line.startsWith("toggle")) {
					for (int x = fromX; x <= toX; x++) {
						for (int y = fromY; y <= toY; y++) {
							if (lights[x][y] == false) {
								lights[x][y] = true;
								lit++;
							} else {
								lights[x][y] = false;
								lit--;
							}
						}
					}
				}
			}
			
			System.out.println(lit);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
