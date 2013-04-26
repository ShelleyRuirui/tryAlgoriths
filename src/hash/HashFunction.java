package hash;

public class HashFunction {
	
	MD5CheckSum md5=new MD5CheckSum();

	public int hash(String content) {
		String hash1="";
		try {
			hash1 = md5.getMD5Checksum(content);
			return hashToInt(hash1);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return -1;
	}
	
	public int hashToInt(String str){
		//BKDR hash
		int seed=131;
		int hash=0;
		for(int i=0;i<str.length();i++){
			hash=hash*seed+str.charAt(i);
		}
		return (hash & 0x7ffffff);
	}
}
