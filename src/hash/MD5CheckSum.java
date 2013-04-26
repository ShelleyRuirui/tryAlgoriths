package hash;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class MD5CheckSum {

	public static byte[] createChecksum(String content) throws Exception {
//	       InputStream fis =  new FileInputStream(filename);

//	       byte[] buffer = new byte[1024];
		   byte[] contentBytes=content.getBytes();
	       MessageDigest complete = MessageDigest.getInstance("MD5");
	       byte[] thedigest = complete.digest(contentBytes);
//	       int numRead;

//	       do {
//	           numRead = fis.read(buffer);
//	           if (numRead > 0) {
//	               complete.update(buffer, 0, numRead);
//	           }
//	       } while (numRead != -1);
//
//	       fis.close();
	       return thedigest;
	   }
	
	 public static String getMD5Checksum(String content) throws Exception {
	       byte[] b = createChecksum(content);
	       String result = "";

	       for (int i=0; i < b.length; i++) {
	           result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
	       }
	       return result;
	   }
	 
	 public static void main(String[] args) throws Exception {
		System.out.println(getMD5Checksum("Hello"));
	}
}
