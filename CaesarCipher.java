import java.util.Scanner;

public class CaesarCipher {
	private int key;
	private int[] alphabet;
	public CaesarCipher(int key) {	
		this.key = key;
		alphabet = new int[26];
	}
	public String encrypt(String message) {
		StringBuilder sb = new StringBuilder(message);
		for (int i = 0; i < message.length(); i++) {
			if (sb.charAt(i) == ' ')	continue;
			int temp = (int)sb.charAt(i);
			int origin = (temp >= 97) ? 97 : 65;
			alphabet[temp - origin]++;
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
	public static void crack(String message) {
		StringBuilder sb = new StringBuilder(message);
		for (int i = 0; i < 26; i++) {
			CaesarCipher cc = new CaesarCipher(i);
			System.out.println(cc.decrypt(message) + " - key = " + i);
		}
	}
	public void displayEncryptionStats() {
		for (int i = 0; i < alphabet.length; i++) {
			System.out.println((char)(97 + i) + " has been encrypted " + alphabet[i] + " times");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("What is your key? ");
		int key = 0;
		if (sc.hasNext())
			key = sc.nextInt();
		CaesarCipher cc = new CaesarCipher(key);
		while (true) {
			sc = new Scanner(System.in);
			String cmd = "";
			System.out.println("What would you like to do?\n"
			+ "encypt\n" + "decrypt\n" + "crack\n" + "quit\n");
			if (sc.hasNext())
				cmd = sc.nextLine();
			sc = new Scanner(System.in);
			if (cmd.equals("encrypt")) {
				System.out.print("Please enter the message ");
				String msg = sc.nextLine();
				System.out.println(cc.encrypt(msg));
			}
			else if (cmd.equals("decrypt")) {
				System.out.print("Please enter the message ");
				String msg = sc.nextLine();
				System.out.println(cc.decrypt(msg));
			}
			else if (cmd.equals("crack")) {
				System.out.print("Please enter the message ");
				String msg = sc.nextLine();
				crack("Pe ef Mcfep");
			}
			else if (cmd.equals("quit")) {
				cc.displayEncryptionStats();
				break;
			}
			System.out.println();
		}
	}
}