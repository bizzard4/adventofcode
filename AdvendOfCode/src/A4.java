import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class A4 {

	public static void main(String[] args) {
		try
		{
			// Key
			String input = "iwrupvqb";
			
			int i = 1;
			boolean found = false;
			
			// Bruteforce search
			while (!found) {
				String toHash = input + i;
				String md5 = getMD5(toHash);
				
				// Win condition
				if (md5.startsWith("000000")) {
					found = true;
					System.out.println(toHash);
				}
				
				// Flow tracer
				if ((i % 1000) == 0) {
					System.out.println(i);
				}
				
				i++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getMD5(String s) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			return (new HexBinaryAdapter()).marshal(md5.digest(s.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
