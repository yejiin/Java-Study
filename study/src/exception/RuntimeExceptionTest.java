package exception;

import java.util.Random;

public class RuntimeExceptionTest {

	public static void main(String[] args) {
//		Random radom = new Random();
//		int num = radom.nextInt(3);
//		int y = 10;
//		int z = y / num;
//		System.out.println(y + " / " + num + " = " + z);

		// 해결책 1
//		Random radom = new Random();
//		int num = radom.nextInt(3) + 1;
//		int y = 10;
//		int z = y / num;
//		System.out.println(y + " / " + num + " = " + z);

		// 해결책 2
		Random radom = new Random();
		int num = radom.nextInt(3);
		int y = 10;
		if (num != 0) {
			int z = y / num;
			System.out.println(y + " / " + num + " = " + z);
		} else {
			System.out.println("숫자를 0으로 나눌 수 없습니다.");
		}
	}

}
