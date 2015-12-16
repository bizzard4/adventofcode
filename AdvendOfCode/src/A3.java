import java.io.FileReader;
import java.util.Hashtable;

public class A3 {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("a3.txt");
			int c = fr.read();
			
			Hashtable<String, Integer> map = new Hashtable<>();
			
			// First gift
			int house = 1;
			String position = "100-100";
			map.put(position, 1);
			
			while (c != -1) {
				char direction = (char)c;
				position = updatePosition(position, direction);
				
				// Update map
				if (map.get(position) == null) {
					house++;
					map.put(position, 1);
				}
				else
				{
					map.put(position, map.get(position)+1);
				}
				
				c = fr.read();
			}
			
			System.out.println(house);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String updatePosition(String position, char direction) {
		String[] split = position.split("-");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		
		if (direction == '<') {
			x--;
		}
		else if (direction == '^') {
			y--;
		}
		else if (direction == 'v') {
			y++;
		}
		else if (direction == '>') {
			x++;
		}
		
		return x + "-" + y;
	}

}
