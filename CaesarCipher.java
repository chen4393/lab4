public class CaesarCipher {
	private int key;
	public CaesarCipher(int key) {	this.key = key;}
	public String encrypt(String message) {
		StringBuilder sb = new StringBuilder(message);
		for (int i = 0; i < message.length(); i++) {
			int temp = (int)sb.charAt(i);
			int origin = 0;
			if (temp >= 97)
				origin = 97;
			else
				origin = 65;
			//System.out.println(temp);
			temp = origin + (temp - origin + key) % 26;
			sb.setCharAt(i, (char)temp);
		}
		return sb.toString();
	}
	public String decrypt(String message) {
		StringBuilder sb = new StringBuilder(message);
		for (int i = 0; i < message.length(); i++) {
			int temp = (int)sb.charAt(i);
			int origin = 0;
			if (temp >= 97)
				origin = 97;
			else
				origin = 65;
			//System.out.println(temp);
			int a = (temp - origin - key);
			if (a < 0) {
				temp = origin + a + 26;
			}
			else
				temp = origin + a % 26;
			//System.out.println(a);
			sb.setCharAt(i, (char)temp);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		CaesarCipher cc = new CaesarCipher(3);
		String cipher = cc.encrypt("xyzXYZabcABC");
		System.out.println(cipher);
		System.out.println(cc.decrypt(cipher));
	}
}