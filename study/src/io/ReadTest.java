package io;

import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTest {

	public static void main(String[] args) {
		System.out.print("입력 : ");
//		try {
////		STD IO  // standard input output  -- 사용 안함. 문자 하나만 받음
//			int x = System.in.read(); // 엔터를 치는 순간 빠져나옴
//			System.out.println("x : " + x);
//			System.out.println("x : " + (char) x);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

////		 byte read
//		byte[] b = new byte[100];
//		try {
//			int x = System.in.read(b);
//			System.out.println("x : " + x); // 읽어들인 byte 수 (엔터도 포함(2byte))
//			for (int i = 0; i < b.length; i++) {
//				System.out.print((char) b[i]);
//			}
//			String s1 = new String(b);
//			System.out.println("s1.length : " + s1.length());
//
//			String s2 = new String(b, 0, x - 2);
//			System.out.println("s2.length : " + s2.length() + " " + s2);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// char read!!
		char[] c = new char[100]; // byte 는 문자당 3byte 차지, char 은 1byte 차지
		try {
			InputStreamReader isr = new InputStreamReader(System.in);

			int x = isr.read(c);
			System.out.println("x : " + x); // 읽어들인 byte 수 (엔터도 포함(2byte))
			for (int i = 0; i < c.length; i++) {
				System.out.print(c[i]);
			}
			String s1 = new String(c);
			System.out.println("s1.length : " + s1.length());

			String s2 = new String(c, 0, x - 2);
			System.out.println("s2.length : " + s2.length() + " " + s2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
