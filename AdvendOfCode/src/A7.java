import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.annotation.Documented;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

public class A7 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("a7.txt"));
			String line;
			
			Hashtable<String, Short> signals = new Hashtable<>();
			List<String> instructions = new LinkedList<>();
			
			while ((line = br.readLine()) != null) {
				instructions.add(line);
			}
			
			// Execute instruction until all done.
			int iterationCount = 0;
			while (!instructions.isEmpty()) {
				// Go throught all left instructions
				for (String s : instructions) {
					// Check if it is possible to execute operation
					boolean doneInstruction = false;
					String[] split = s.split(" ");
					
					// Format 1
					if (split.length == 3) { // 10 -> a or a -> b format
						//System.out.println(s);
						
						try
						{
							// 10 -> a format
							Short signal = Short.parseShort(split[0]);
							signals.put(split[2], signal);
							
							System.out.println(s);
							instructions.remove(s);
							doneInstruction = true;
							break;
						}
						catch (NumberFormatException num) { 
							// a -> b format
							Short signal = signals.get(split[0]);
							if (signal != null) {
								signals.put(split[2], signal);
								
								System.out.println(s);
								instructions.remove(s);
								doneInstruction = true;
								break;
							}
						}
					}
					
					// Format 2
					if (split.length == 4) { // NOT a -> a format
						//System.out.println(s);
						
						Short signal = signals.get(split[1]);
						if (signal != null) {
							signals.put(split[3], (short)(~signal));
							
							System.out.println(s);
							instructions.remove(s);
							doneInstruction = true;
							break;
						}
					}
					
					// Format 3
					if (split.length > 4) { // a OP b -> c format
						String op = split[1];
						Short sa;
						Short sb;
						
						// Format 1 OP b -> c
						try {
							sa = Short.parseShort(split[0]);
							sb = signals.get(split[2]);
						} catch (NumberFormatException num) {
							// Format a OP 1 -> c
							try
							{
								sb = Short.parseShort(split[2]);
								sa = signals.get(split[0]);
							} catch (NumberFormatException num2) {
								// Format a OP a -> c
								sa = signals.get(split[0]);
								sb = signals.get(split[2]);
							}
						}
						
						if ((sa != null) && (sb != null)) {
							Short signal = null;
							if (op.equals("AND")) {
								signal = (short)(sa & sb);
							} else if (op.equals("OR")) {
								signal = (short)(sa | sb);
							} else if (op.equals("LSHIFT")) {
								signal = (short)(sa << sb);
							} else if (op.equals("RSHIFT")) {
								signal = (short)(sa >> sb);
							}
							if (signal != null) {
								signals.put(split[4], signal);
								
								System.out.println(s);
								instructions.remove(s);
								doneInstruction = true;
								break;
							}
						}
					}
				}
				
				// Increment interation count.
				iterationCount++;
				System.out.println("Iteration count: " + iterationCount + ". " + instructions.size() + " left.");
			}
			
			System.out.println(signals.get("a"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
