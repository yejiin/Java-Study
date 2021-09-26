package exception;

import java.io.FileNotFoundException;

public class NonRuntimeMain2 {

	public static void main(String[] args) {
		NonRuntimeExceptionTest nret = new NonRuntimeExceptionTest();
		System.out.println("fileRead1 호출!!!");
		nret.fileRead1("a.txt");
		System.out.println("fileRead2 호출!!!");
		try {
			nret.fileRead2("a.txt");
		} catch (FileNotFoundException e) {
			System.out.println("a.txt대신에 c.txt로 사용!!!");
//			e.printStackTrace();
		}
	}
}
