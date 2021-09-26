package string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest1 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * 객체 생성방식 1. literal
		 */
		// 객체 생성방식
		// 1. literal : 문자열 저장소 할당
		String s1 = "안녕";
		String s = new String(s1); // original
		// 2. 생성자 : heap
		String s2 = new String("안녕");

		// 여러가지 방법
		String s3 = new String(); // 빈문자열.
		byte b[] = { 65, 66, 67, 68, 69, 70, 71, 72, 73 };
		String s4 = new String(b);
		System.out.println("s4 : " + s4);

		String msg = "안녕하세요";
//		byte[] b2 = msg.getBytes(); // default : utf-8  네트워크를 통해 넘겨줄 수 있게 변환
		byte[] b2 = msg.getBytes("euc-kr");
		System.out.println(Arrays.toString(b2)); // [-66, -56, -77, -25, -57, -49, -68, -68, -65, -28]

//		String s5 = new String(b2);
		String s5 = new String(b2, "euc-kr");
		System.out.println(s5); // 다시 한글로 변환

		String s6 = new String(b, 3, 4);
		System.out.println(s6);


		char[] c = { '안', '녕', '하', '세', '요', '!', '!' };
		String s7 = new String(c);
		System.out.println("s7 : " + s7);

		char[] c2 = msg.toCharArray();
		System.out.println(Arrays.toString(c2));

		String case1 = "heLLo";
		String case2 = "HElLo";
		if (case1.equals(case2))
			System.out.println("문자열 같다");
		if (case1.equalsIgnoreCase(case2))
			System.out.println("대소문자 무시 문자열 같다");
		if (case1.toLowerCase().equals(case2.toLowerCase()))
			System.out.println("대소문자 무시 문자열 같다");

		System.out.println(case1.toLowerCase() + " " + case1.toUpperCase());

		// 문자열 형변환.
		// 숫자 >> 문자열
		int x = 123;
		System.out.println(x + 100);
		// 1.
		String snum = x + "";
		System.out.println(snum + 100);
		// 2.
		snum = String.valueOf(x);
		System.out.println(snum + 100);
		// 3.
		snum = Integer.toString(x);
		System.out.println(snum + 100);

		// 문자열 >> 숫자
		String numStr = "123";
		System.out.println(numStr + 100);
		int num = Integer.parseInt(numStr);
		System.out.println(num + 100);
	}

}
