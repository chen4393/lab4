public class CaesarCipher {
	private int key;
	public CaesarCipher(int key) {	this.key = key;}
	public String encrypt(String message) {
		StringBuilder sb = new StringBuilder(message);
		for (int i = 0; i < message.length(); i++) {
			if (sb.charAt(i) == ' ')	continue;
			int temp = (int)sb.charAt(i);
			int origin = (temp >= 97) ? 97 : 65;
			temp = origin + (temp - origin + key) % 26;
			sb.setCharAt(i, (char)temp);
		}
		return sb.toString();
	}
	public String decrypt(String message) {
		StringBuilder sb = new StringBuilder(message);
		for (int i = 0; i < message.length(); i++) {
			if (sb.charAt(i) == ' ')	continue;
			int temp = (int)sb.charAt(i);
			int origin = (temp >= 97) ? 97 : 65;
			int a = temp - origin - key;
			temp = (a < 0) ? origin + a + 26 : origin + a % 26;
			sb.setCharAt(i, (char)temp);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		CaesarCipher cc = new CaesarCipher(3);
		String cipher = cc.encrypt("xyz XYZ abc ABC");
		System.out.println(cipher);
		System.out.println(cc.decrypt(cipher));
	}
}