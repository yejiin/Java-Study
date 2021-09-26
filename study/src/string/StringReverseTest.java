package string;

public class StringReverseTest {
	public static void main(String[] args) {
//		String str = "!!! mik olleh";
		String str = "!!! 김 녕안";
		// 1.
		int len = str.length();
		for (int i = len - 1; i >= 0; i--)
			System.out.print(str.charAt(i));
		System.out.println();
		// 2.
		String result = "";
		for (int i = len - 1; i >= 0; i--) {
//			result += str.charAt(i);
			result = result.concat(str.charAt(i) + "");
		}
		System.out.println(result);
		System.out.println("reverse한 문자열에서 'o'는" + result.indexOf('o') + "번째 입니다.");

		// 3.
		byte[] b = str.getBytes();
		byte[] rb = new byte[len];
		int k = 0;
		for (int i = len - 1; i >= 0; i--)
			rb[k++] = b[i];
		String rs = new String(rb);
		System.out.println(rs);

		// 4.
		char[] c = str.toCharArray();
		char[] rc = new char[len];
		k = 0;
		for (int i = len - 1; i >= 0; i--)
			rc[k++] = c[i];
		rs = new String(rc);
		System.out.println(rc);

		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());
		// hello kim !!!
		// 안녕 김 !!

		// reverse한 문자열에서 'o'는 몇번째 index입니까
	}
}
